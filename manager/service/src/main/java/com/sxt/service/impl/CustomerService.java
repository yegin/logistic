package com.sxt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sxt.dto.CustomerDto;
import com.sxt.mapper.CustomerMapper;
import com.sxt.pojo.BasicData;
import com.sxt.pojo.Customer;
import com.sxt.pojo.Role;
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

	
	/**
	 * 当前用户如果是  业务员 只能查看所属的客户
	 * 如果是 操作员 或者 管理员 能查看所有的客户
	 */
	@Override
	public PageInfo<CustomerDto> queryPage(CustomerDto dto, User user) {
		// TODO Auto-generated method stub
		
		PageHelper.startPage(dto.getPageNum(), dto.getPageSize());
		
		//获取角色信息
		List<Role> list = userService.queryRoleByUserId(user.getUserId());
		boolean flag=false;
		if (list!=null&&list.size()>0) {
			for (Role role : list) {
				//如果是管理员
				if (Constant.ROLE_ADMIN.equals(role.getRoleName())
						||Constant.ROLE_OPERATOR.equals(role.getRoleName())) {
					flag=true;
					break;
				}
			}
		}
		Customer customer = new Customer();
		if (flag==false) {
			customer.setUserId(user.getUserId());
		}
		List<CustomerDto> customers = customerMapper.queryView(customer);
		
		return new PageInfo<>(customers);
	}


}
