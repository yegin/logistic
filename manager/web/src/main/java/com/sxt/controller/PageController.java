package com.sxt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * ��Ϊ��ȫ����ҳ������web/inf��
 * ��ҳ��Ϊ��ת��jspҳ������
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
