/**
 * 
 */
package com.itinna.smalltool.common.utils;

/**
 * <p>
 * 分页器：根据参数进行分页计算。
 * </p>
 * <ul>
 * 支持两种翻页功能：
 * <li>直接指定跳转页：</li>
 * <ul>
 * 输入：
 * <li>totalNum：总记录数，必填参数</li>
 * <li>toPage：跳转页，默认值为1</li>
 * <li>pageSize：每页显示记录数，默认值为10</li>
 * </ul>
 * <li>由翻页动作触发：</li>
 * <ul>
 * 输入：
 * <li>recordCount：总记录数，必填参数</li>
 * <li>action：翻页动作，必填参数（若直接指定跳转页，则此参数可选）</li>
 * <li>currentPage：当前页，默认值为1</li>
 * <li>pageSize：每页显示记录数，默认值为10</li>
 * </ul>
 * </ul>
 * <ul>
 * 输出：
 * <li>fromRecord：起始记录</li>
 * <li>toRecord：结束记录</li>
 * <li>pageCount：总页数</li>
 * <li>recordCount：总记录数</li>
 * <li>toPage：跳转页</li>
 * <li>pageSize：每页记录数</li>
 * <li>currentPage：每页记录数</li>
 * </ul>
 * 
 * @author tinna.xie
 *
 */
public class Pagination {

    /** 翻页动作：首页 */
    public static final String ACTION_FIRST = "first";

    /** 翻页动作：上一页 */
    public static final String ACTION_PREV = "prev";

    /** 翻页动作：下一页 */
    public static final String ACTION_NEXT = "next";

    /** 翻页动作：尾页 */
    public static final String ACTION_LAST = "last";

    /** 默认每页显示记录数 */
    private static final int DEFAULT_PAGE_SIZE = 10;

    /** 默认当前页 */
    private static final int DEFAULT_CURRENT_PAGE = 1;

    /** 默认记录总数 */
    public static final int DEFAULT_RECORD_COUNT = Integer.MAX_VALUE;

    /** 当前页 */
    private int currentPage = DEFAULT_CURRENT_PAGE;

    /** 翻页动作 */
    private String action;

    /** 跳转页 */
    private int toPage = 1;

    /** 每页显示记录数 */
    private int pageSize = DEFAULT_PAGE_SIZE;

    /** 总记录数 */
    private int recordCount;

    /** 总页数 */
    private int pageCount;

    /** 起始记录 */
    private int fromRecord;

    /** 结束记录 */
    private int toRecord;

    /**
     * 分页器构造器
     * 
     * @param recordCount
     *            总记录数
     * @param pageSize
     *            每页显示记录数
     * @param currentPage
     *            当前页
     * @param action
     *            翻页动作
     */
    public Pagination(int recordCount, int pageSize, int currentPage, String action) {
        this.recordCount = recordCount;
        this.pageSize = pageSize;
        this.currentPage = currentPage;
        this.action = action;
        this.compute();
    }

    /**
     * 分页器构造器：每页显示10条数据
     * 
     * @param recordCount
     *            总记录数
     * @param currentPage
     *            当前页
     * @param action
     *            翻页动作
     */
    public Pagination(int recordCount, int currentPage, String action) {
        this(recordCount, DEFAULT_PAGE_SIZE, currentPage, action);
    }

    /**
     * 分页器构造器：每页显示10条数据，当前页为第一页
     * 
     * @param recordCount
     *            总记录数
     * @param action
     *            翻页动作
     */
    public Pagination(int recordCount, String action) {
        this(recordCount, DEFAULT_PAGE_SIZE, DEFAULT_CURRENT_PAGE, action);
    }

    /**
     * 分页器构造器：显示当前页为第一页
     * 
     * @param recordCount
     * @param pageSize
     */
    public Pagination(int recordCount, int pageSize) {
        this(recordCount, pageSize, DEFAULT_CURRENT_PAGE, null);
    }

    /**
     * 分页器构造器：每页显示10条数据，显示当前页为第一页
     * 
     * @param recordCount
     *            总记录数
     */
    public Pagination(int recordCount) {
        this(recordCount, DEFAULT_PAGE_SIZE);
    }

    /**
     * 分页器构造器：每页显示10条数据，显示当前页为第一页，显示记录总数为integer最大值
     */
    public Pagination() {
        this(DEFAULT_RECORD_COUNT);
    }

    /**
     * <p>
     * 设置当前页
     * </p>
     * 
     * @param currentPage
     *            the currentPage to set
     */
    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    /**
     * @return the currentPage
     */
    public int getCurrentPage() {
        return currentPage;
    }

    /**
     * <p>
     * 获取跳转页
     * </p>
     * <ul>
     * <li>若action匹配成功，则根据action计算toPage;</li>
     * <li>若action未匹配成功，则跳转页已指定</li>
     * </ul>
     * 
     * @return the toPage
     */
    public void computeCurrentPage() {
        if (StringUtils.equals(ACTION_FIRST, this.action)) { // 跳转至首页
            this.currentPage = 1;
        } else if (StringUtils.equals(ACTION_PREV, this.action)) { // 跳转至上一页
            this.currentPage = (this.currentPage - 1) > 0 ? (this.currentPage - 1) : 1;
        } else if (StringUtils.equals(ACTION_NEXT, this.action)) { // 跳转至下一页
            this.currentPage = (this.currentPage + 1) > this.getPageCount() ? this.getPageCount()
                    : (this.currentPage + 1);
        } else if (StringUtils.equals(ACTION_LAST, this.action)) { // 跳转至尾页
            this.currentPage = this.getPageCount();
        } else { // 跳转至指定页
            if (this.toPage < 1) {
                this.currentPage = 1;
            } else if (this.toPage > this.getPageCount()) {
                this.currentPage = this.getPageCount();
            } else {
                this.currentPage = this.toPage;
            }
        }
    }

    /**
     * <p>
     * 设置翻页动作
     * </p>
     * 
     * @param action
     *            the action to set
     */
    public void setAction(String action) {
        this.action = action;
    }

    /**
     * @return the action
     */
    public String getAction() {
        return action;
    }

    /**
     * <p>
     * 设置跳转页
     * </p>
     * 
     * @param toPage
     *            the toPage to set
     */
    public void setToPage(int toPage) {
        this.toPage = toPage;
    }

    /**
     * <p>
     * 设置每页显示记录数
     * </p>
     * 
     * @param pageSize
     *            the pageSize to set
     */
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * <p>
     * 返回每页记录显示数
     * </p>
     * 
     * @return 每页显示数
     */
    public int getPageSize() {
        return this.pageSize;
    }

    /**
     * <p>
     * 获取总记录数
     * </p>
     * 
     * @return the recordCount
     */
    public int getRecordCount() {
        return this.recordCount;
    }

    /**
     * <p>
     * 设置总记录数
     * </p>
     * 
     * @param recordCount
     *            the recordCount to set
     */
    public void setRecordCount(int recordCount) {
        this.recordCount = recordCount;
    }

    /**
     * <p>
     * 获取总页数
     * </p>
     * 
     * @return the pageCount
     */
    public int getPageCount() {
        return this.pageCount;
    }

    /**
     * <p>
     * 计算总页数
     * </p>
     * 
     * @return the pageCount
     */
    public void computePageNum() {
        this.pageCount = (this.recordCount % this.pageSize == 0) ? (this.recordCount / this.pageSize)
                : ((this.recordCount / this.pageSize) + 1);
    }

    /**
     * <p>
     * 获取起始记录
     * </p>
     * 
     * @return the fromRecord
     */
    public int getFromRecord() {
        return this.fromRecord;
    }

    /**
     * <p>
     * 计算起始记录
     * </p>
     * 
     * @return the fromRecord
     */
    public void computeFromRecord() {
        this.fromRecord = (this.currentPage - 1) * this.pageSize;
        this.fromRecord = (this.fromRecord < 0) ? 0 : this.fromRecord;
    }

    /**
     * <p>
     * 获取结束记录
     * </p>
     * 
     * @return the toRecord
     */
    public int getToRecord() {
        return this.toRecord;
    }

    /**
     * <p>
     * 计算结束记录
     * </p>
     * 
     * @return the toRecord
     */
    public void computeToRecord() {
        this.toRecord = this.fromRecord + this.pageSize - 1;
        this.toRecord = (this.toRecord > this.recordCount) ? this.recordCount : this.toRecord;
    }

    public void compute() {
        this.computePageNum();
        this.computeCurrentPage();
        this.computeFromRecord();
        this.computeToRecord();
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return StringUtils.toString(this);
    }

    public static void main(String[] args) {
        Pagination page = new Pagination(23);
        System.out.println(page);

        page.setAction(ACTION_NEXT);
        page.compute();
        System.out.println(page);

        page = new Pagination(23, Pagination.ACTION_NEXT);
        System.out.println(page);

        page.setAction(ACTION_NEXT);
        page.compute();
        System.out.println(page);

        page.setAction(null);
        page.setToPage(2);
        page.compute();
        System.out.println(page);

    }
}
