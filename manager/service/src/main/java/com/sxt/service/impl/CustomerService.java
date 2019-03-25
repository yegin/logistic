package com.sxt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.sxt.dto.CustomerDto;
import com.sxt.mapper.CustomerMapper;
import com.sxt.pojo.BasicData;
import com.sxt.pojo.Customer;
import com.sxt.pojo.User;
import com.sxt.service.IBasicService;
import com.sxt.service.ICustomerService;
import com.sxt.service.IUserService;
import com.sxt.utils.Constant;

@Service
public class CustomerService implements ICustomerService {

	@Resource
	private CustomerMapper customerMapper;
	
	@Resource
	private IUserService userService;
	
	@Resource
	private IBasicService basicService;
	
	/**
	 * ��ȡǰ��ҳ���ύ��ҳ��������Ϣ
	 */
	@Override
	public void getUpdateInfo(Integer id, Model m) {
		
//		根据角色查询所有用户
		List<User> users = userService.queryByRoleName(Constant.ROLE_SALESMAN);
//		��ѯ��������Ļ�������
		List<BasicData> intervals = basicService.getBasicDataByParentName(Constant.BASIC_COMMON_INTERVAL);
		
		m.addAttribute("users", users);
		m.addAttribute("intervals", intervals);
		
		if(id!=null && id > 0){
			// ��ѯ������Ҫ������
			Customer customer = new Customer();
			customer.setCustomerId(id);
			 List<CustomerDto> list = customerMapper.queryView(customer);
			
			 if(list !=null && list.size() == 1){
					m.addAttribute("dto", list.get(0));
				}
		}
		
	}

	@Override
	public List<Customer> query(CustomerDto dto) {
		
		return null;
	}

	@Override
	public List<Customer> query(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		customerMapper.insertSelective(customer);
	}

	@Override
	public void updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		customerMapper.updateByPrimaryKeySelective(customer);
	}

	@Override
	public void deleteCustomer(int id) {
		// TODO Auto-generated method stub
		customerMapper.deleteByPrimaryKey(id);
	}


}
