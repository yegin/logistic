package com.sxt.service;

import java.util.List;

import org.springframework.ui.Model;

import com.sxt.dto.UserDto;
import com.sxt.pojo.User;

/**
 * 查询用户接口
 * @author xnfcl
 *
 */
public interface IUserService {
	/**
	 * 根据条件查询用户信息
	 * @param user
	 * @return
	 */
	public List<User> query(User user);
	
	/**
	 * 添加用户
	 * @param user
	 * @throws Exception
	 */
	public void addUser(User user) throws Exception;
	
	/**
	 * 修改用户
	 * @param user
	 * @throws Exception
	 */
	public void updateUser(User user)throws Exception;
	
	/**
	 * 删除用户
	 * @param id
	 * @throws Exception
	 */
	public void deleteUser(int id)throws Exception;
	
	/**
	 * 获取添加或者修改信息所用到的信息
	 * @param id
	 * @param model
	 */
	public void getUpdateUserInfo(Integer id,Model model);

	
	/**
	 * 保存或修改数据
	 * @param userDto
	 */
	public void saveOrUpdate(UserDto userDto);	
	
}
