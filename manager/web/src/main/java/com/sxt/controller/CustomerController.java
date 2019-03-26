package com.sxt.controller;

import java.io.IOException;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageInfo;
import com.sxt.dto.CustomerDto;
import com.sxt.pojo.Customer;
import com.sxt.pojo.User;
import com.sxt.service.ICustomerService;
import com.sxt.utils.Constant;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Resource
	private ICustomerService customerService;
	
	/**
	 * ǰ�˵����Ӻ󣬺�˷���һ�����ҳ��
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/customerUpdate")
	public String customerUpdate(Integer id,Model model) {
		customerService.getUpdateInfo(id, model);
		return "customer/customerUpdate";
	}
	
	/**
	 * ���ݴ�����id�����Ƿ�Ϊ���ж�����ӻ����޸�����
	 * @param customer
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/saveOrUpdate")
	public String saveOrUpdate(Customer customer) throws IOException  {
		if (customer.getCustomerId()!=null&&!"".equals(customer.getCustomerId())) {
			//���²���
			
		}else{
			customerService.addCustomer(customer);
		}
		return "success";
	}
	
	@RequestMapping("/query")
	public String query(CustomerDto dto,Model model){
		// 获取登录用户信息
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		System.out.println("--->"+user.getUserId());
		PageInfo<CustomerDto> list = customerService.queryPage(dto,user);
		model.addAttribute(Constant.PAGE_MODLE, list);
		return "customer/customer";
	}

	
	
	
	
}
