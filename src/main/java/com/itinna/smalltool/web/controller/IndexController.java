/**
 * 
 */
package com.itinna.smalltool.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itinna.smalltool.common.utils.HttpUtils;

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
        Long userId = HttpUtils.getLoginUserId();
        if (userId == null) {
            return "login";
        } else {
            return "index";
        }
    }

}
