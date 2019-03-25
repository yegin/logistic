package com.sxt.service;

import java.util.List;

import org.springframework.ui.Model;

import com.sxt.dto.CustomerDto;
import com.sxt.pojo.Customer;

public interface ICustomerService {
	
	/**
	 * ��ѯ��ӻ���µ���Ϣ
	 * @param id
	 * @param m
	 */
	public void getUpdateInfo(Integer id,Model m);
	
//	����ҳ����Ϣ��ѯ�ͻ���Ϣ
	public List<Customer> query(CustomerDto dto);
	
	//�����û���ѯ
	public List<Customer> query(Customer customer);
	
	
	//����û���Ϣ
	public void addCustomer(Customer customer);
	
//	�����û���Ϣ
	public void updateCustomer(Customer customer);
	
//	ɾ���û���Ϣ
	public void deleteCustomer(int id);

}
