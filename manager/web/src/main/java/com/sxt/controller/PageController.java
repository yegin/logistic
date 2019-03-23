package com.sxt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * 因为安全，将页面存放至web/inf下
 * 此页面为跳转到jsp页面而设计
 * @author xnfcl
 *
 */
@Controller
public class PageController {
	
	@RequestMapping("/")
	public String showMain(){
		return "login";
	}
	
	@RequestMapping("/{path}")
	public String showPage(@PathVariable String path){
		return path;
	}
}
