package com.sxt.service;

import java.util.List;

import com.sxt.pojo.Role;

public interface IRoleService {

//	����������ѯ��ɫ
	public List<Role> query(Role role);
	
	public void addRole(Role role) throws Exception;
	
	public void updateRole(Role role) throws Exception;
	
	public void deleteRole(int id) throws Exception;
	
}
