/**
 * 
 */
package com.itinna.smalltool.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itinna.smalltool.common.utils.HttpUtils;
import com.itinna.smalltool.common.utils.StringUtils;

/**
 * Home page
 * 
 * @author tinna
 *
 */

@Controller
public class IndexController extends BaseController {

    @RequestMapping(value = { "/", "/index" })
    public String index() {
        String userId = HttpUtils.getLoginUserId();
        if (StringUtils.isEmpty(userId)) {
            return "login";
        } else {
            return "index";
        }
    }

}
