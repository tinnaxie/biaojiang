package com.itinna.smalltool.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import com.itinna.smalltool.dao.model.Node;
import com.itinna.smalltool.dao.model.Template;
import com.itinna.smalltool.web.form.template.CreateSaveTemplateForm;
import com.itinna.smalltool.web.form.template.DeleteTemplateForm;
import com.itinna.smalltool.web.form.template.ModifySaveTemplateForm;
import com.itinna.smalltool.web.form.template.ViewTemplateForm;
import com.itinna.smalltool.web.view.NodeView;
import com.itinna.smalltool.web.view.TemplateView;
import com.itinna.smalltool.web.view.ViewTemplateView;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring/spring-context.xml", "classpath:/log/log4j.xml" })
public class TemplateServiceTest {

    @Autowired
    private TemplateService templateService;

    @Test
    public void test() {
        ViewTemplateView view = this.templateService.createSave(this.preCreateSave());
        System.out.println(view.toString());
        System.out.println("1. create template success");

        view = this.templateService.modifySave(this.preModifySave(view));
        this.assertModify(view);
        System.out.println(view.toString());
        System.out.println("2. modify template success");

        String templateId = view.getTemplate().getId();
        ViewTemplateForm viewForm = new ViewTemplateForm();
        viewForm.setTemplateId(templateId);
        view = this.templateService.view(viewForm);
        System.out.println("3. view template success");

        DeleteTemplateForm deleteForm = new DeleteTemplateForm();
        deleteForm.setTemplateId(templateId);
        this.templateService.delete(deleteForm);
        System.out.println("4. delete template success");
    }

    private CreateSaveTemplateForm preCreateSave() {
        CreateSaveTemplateForm form = new CreateSaveTemplateForm();
        Template template = new Template();
        form.setTemplate(template);
        template.setName("现场检查表");
        template.setDescription("郎木公司现场检查表模版");

        List<Node> nodes = new ArrayList<Node>();
        template.setNodes(nodes);
        Node node = new Node();
        nodes.add(node);
        node.setId("1");
        node.setParentId("0");
        node.setNodeTypeId(1);
        node.setName("项目名称：");
        node.setPosition(0);
        node.setIsRequired("1");
        node.setHasAttachment("0");

        node = new Node();
        nodes.add(node);
        node.setId("2");
        node.setParentId("1");
        node.setNodeTypeId(4);
        node.setPosition(1);
        node.setIsRequired("1");
        node.setHasAttachment("0");

        node = new Node();
        nodes.add(node);
        node.setId("3");
        node.setParentId("0");
        node.setNodeTypeId(1);
        node.setName("日期：");
        node.setPosition(2);
        node.setIsRequired("1");
        node.setHasAttachment("0");

        node = new Node();
        nodes.add(node);
        node.setId("4");
        node.setParentId("3");
        node.setNodeTypeId(4);
        node.setPosition(3);
        node.setIsRequired("1");
        node.setHasAttachment("0");

        node = new Node();
        nodes.add(node);
        node.setId("5");
        node.setParentId("0");
        node.setNodeTypeId(1);
        node.setName("工地建设：");
        node.setPosition(4);
        node.setIsRequired("0");
        node.setHasAttachment("0");

        node = new Node();
        nodes.add(node);
        node.setId("6");
        node.setParentId("5");
        node.setNodeTypeId(1);
        node.setName("现场干净整洁：");
        node.setPosition(5);
        node.setIsRequired("1");
        node.setHasAttachment("0");

        node = new Node();
        nodes.add(node);
        node.setId("7");
        node.setParentId("6");
        node.setNodeTypeId(2);
        node.setName("达到要求");
        node.setPosition(6);
        node.setIsRequired("0");
        node.setHasAttachment("0");

        node = new Node();
        nodes.add(node);
        node.setId("8");
        node.setParentId("6");
        node.setNodeTypeId(2);
        node.setName("未达要求");
        node.setPosition(7);
        node.setIsRequired("0");
        node.setHasAttachment("0");

        node = new Node();
        nodes.add(node);
        node.setId("9");
        node.setParentId("5");
        node.setNodeTypeId(1);
        node.setName("标志标识牌清楚");
        node.setPosition(8);
        node.setIsRequired("1");
        node.setHasAttachment("0");

        node = new Node();
        nodes.add(node);
        node.setId("10");
        node.setParentId("9");
        node.setNodeTypeId(2);
        node.setName("达到要求");
        node.setPosition(9);
        node.setIsRequired("0");
        node.setHasAttachment("0");

        node = new Node();
        nodes.add(node);
        node.setId("11");
        node.setParentId("9");
        node.setNodeTypeId(2);
        node.setName("未达要求");
        node.setPosition(10);
        node.setIsRequired("0");
        node.setHasAttachment("0");

        form.setLoginUserId("1");

        List<String> admins = new ArrayList<String>();
        form.setAdminIds(admins);
        admins.add("2");
        admins.add("3");

        List<String> reporters = new ArrayList<String>();
        form.setReporterIds(reporters);
        for (int i = 3; i < 10; i++) {
            reporters.add(String.valueOf(i));
        }
        return form;
    }

    private ModifySaveTemplateForm preModifySave(ViewTemplateView view) {
        ModifySaveTemplateForm form = new ModifySaveTemplateForm();
        Template template = new Template();
        form.setTemplate(template);

        TemplateView templateView = view.getTemplate();
        template.setId(templateView.getId());
        template.setName("模版名称已修改");
        template.setDescription("模版描述已修改");

        Node topNode = this.copyNodes(templateView.getNodes(), null);
        if (topNode != null) {
            template.setNodes(topNode.getSubNodes());
        }
        form.setLoginUserId("2");
        return form;
    }

    private Node copyNodes(List<NodeView> nodeViews, Node parentNode) {
        if (nodeViews != null) {
            List<Node> nodes = new ArrayList<Node>();
            if (parentNode == null) {
                parentNode = new Node();
            }
            parentNode.setSubNodes(nodes);
            for (NodeView nodeView : nodeViews) {
                Node node = new Node();
                node.setId(nodeView.getId());
                node.setName(nodeView.getName());
                node.setParentId(nodeView.getParentId());
                node.setHasAttachment(nodeView.getHasAttachment());
                node.setIsRequired(nodeView.getIsRequired());
                node.setNodeTypeId(nodeView.getNodeTypeId());
                node.setPosition(nodeView.getPosition());
                this.preNode(node);
                if (node.getPosition() != 10) {
                    nodes.add(node);
                }

                copyNodes(nodeView.getSubNodes(), node);
            }
        }
        return parentNode;
    }

    private void preNode(Node node) {
        switch (node.getPosition()) {
        case 0:// modify top node
            node.setName("顶节点名已修改");
            node.setHasAttachment("1");
            node.setIsRequired("0");
            node.setNodeTypeId(3);
            node.setPosition(12);
            break;
        case 1:// modify sub node
            node.setName("子节点名已修改");
            node.setHasAttachment("1");
            node.setIsRequired("0");
            node.setNodeTypeId(2);
            node.setPosition(13);
            break;
        default:
            break;
        }
    }

    private void assertModify(ViewTemplateView view) {
        TemplateView template = view.getTemplate();
        Assert.notNull(template);
        Assert.isTrue(StringUtils.equals("模版名称已修改", template.getName()));
        Assert.isTrue(StringUtils.equals("模版描述已修改", template.getDescription()));

        List<NodeView> nodes = template.getNodes();
        Assert.notNull(nodes);
        for (NodeView node : nodes) {
            this.assertNode(node);
        }
    }

    private void assertNode(NodeView node) {
        switch (node.getPosition()) {
        case 0:// modify top node
            Assert.isTrue(StringUtils.equals("顶节点名已修改", node.getName()));
            Assert.isTrue(StringUtils.equals("1", node.getHasAttachment()));
            Assert.isTrue(StringUtils.equals("0", node.getIsRequired()));
            Assert.isTrue(3 == node.getNodeTypeId());
            Assert.isTrue(12 == node.getPosition());
            break;
        case 1:// modify sub node
            Assert.isTrue(StringUtils.equals("子节点名已修改", node.getName()));
            Assert.isTrue(StringUtils.equals("1", node.getHasAttachment()));
            Assert.isTrue(StringUtils.equals("0", node.getIsRequired()));
            Assert.isTrue(2 == node.getNodeTypeId());
            Assert.isTrue(13 == node.getPosition());
            break;
        default:
            break;
        }
    }

}
