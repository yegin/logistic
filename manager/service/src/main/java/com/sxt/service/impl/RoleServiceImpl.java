package com.sxt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sxt.mapper.RoleMapper;
import com.sxt.pojo.Role;
import com.sxt.pojo.RoleExample;
import com.sxt.service.IRoleService;

@Service
public class RoleServiceImpl implements IRoleService{
	
	@Resource
	private RoleMapper mapper;
	
	public List<Role> query(Role role) {
		RoleExample example = new RoleExample();
		if (role !=null&& !"".equals(role.getRoleName()) && role.getRoleName()!=null) {
			example.createCriteria().andRoleNameLike("%"+role.getRoleName()+"%");
		}
		return mapper.selectByExample(example);
	}

	public void addRole(Role role) throws Exception {
		mapper.insertSelective(role);
		
	}

	public void updateRole(Role role) throws Exception {
		// TODO Auto-generated method stub
		mapper.updateByPrimaryKeySelective(role);
	}

	public void deleteRole(int id) throws Exception {
		// TODO Auto-generated method stub
		mapper.deleteByPrimaryKey(id);
	}

}
