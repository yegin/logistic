package com.sxt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.sxt.dto.UserDto;
import com.sxt.mapper.RoleMapper;
import com.sxt.mapper.UserMapper;
import com.sxt.pojo.Role;
import com.sxt.pojo.RoleExample;
import com.sxt.pojo.User;
import com.sxt.pojo.UserExample;
import com.sxt.service.IUserService;

@Service
public class UserServiceImpl implements IUserService{

	@Resource
	private UserMapper usermapper;
	
	@Resource
	private RoleMapper roleMapper;
	
	@Override
	public List<User> query(User user) {
		// TODO Auto-generated method stub
		return usermapper.selectByExample(new UserExample());
	}

	@Override
	public void addUser(User user) throws Exception {
		usermapper.insertSelective(user);
	}

	@Override
	public void updateUser(User user) throws Exception {
		usermapper.updateByPrimaryKey(user);
	}

	@Override
	public void deleteUser(int id) throws Exception {
		// TODO Auto-generated method stub
		usermapper.deleteByPrimaryKey(id);
	}
	
	/**
	 * 获取添加或者修改信息所用到的信息
	 * @param id
	 * @param model
	 */
	@Override
	public void getUpdateUserInfo(Integer id, Model model) {
		
		RoleExample roleExample = new RoleExample();
		List<Role> roles = roleMapper.selectByExample(roleExample);
		model.addAttribute("roles", roles);
		
	}

	@Override
	public void saveOrUpdate(UserDto userDto) {
		// 获取User对象
		User user = userDto.getUser();
		
		// 获取关联的角色信息
		List<Integer> roles = userDto.getRoles();
		
		
		// 判断是添加还是修改数据
		if(user.getUserId()!=null && user.getUserId() > 0){
			// 表示userId存在，说明是更新
		}else{
			// 不存在id说明是添加数据
			// 先添加用户数据 获取生成的userId
			usermapper.insert(user);
			// 再保存用户和角色的对应关系，在一个事务中处理
			if(roles!=null && roles.size() > 0){
				for (Integer roleId : roles) {
					usermapper.inserUserIdAndRoleId(user.getUserId(),roleId);
				}
			}
			
		}
	}
}
