package com.sxt.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sxt.dto.UserDto;
import com.sxt.pojo.User;
import com.sxt.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Resource
	private IUserService userService;
	
	@RequestMapping("query")
	public String query(User user,Model model){
		
		List<User> users = userService.query(user);
		model.addAttribute("list",users);
		return "user/user";
	}
	
	@RequestMapping("/userUpdate")
	public String userUpdatePage(Integer id,Model model){
		// 查询添加或者更新需要的数据
		userService.getUpdateUserInfo(id,model);
		
		return "/user/userUpdate";
	}
	
	@RequestMapping("/saveOrUpdate")
	public String saveOrUpdate(UserDto userDto) throws Exception{
		userService.saveOrUpdate(userDto);
		return "redirect:/user/query";
	}
	
	
	
}
