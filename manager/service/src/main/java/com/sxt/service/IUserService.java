package com.sxt.service;

import java.util.List;

import org.springframework.ui.Model;

import com.github.pagehelper.PageInfo;
import com.sxt.dto.UserDto;
import com.sxt.pojo.Role;
import com.sxt.pojo.User;

/**
 * ��ѯ�û��ӿ�
 * @author xnfcl
 *
 */
public interface IUserService {
	/**
	 * ����������ѯ�û���Ϣ
	 * @param user
	 * @return
	 */
	public List<User> query(User user);
	
	/**
	 * ����û�
	 * @param user
	 * @throws Exception
	 */
	public void addUser(User user) throws Exception;
	
	/**
	 * �޸��û�
	 * @param user
	 * @throws Exception
	 */
	public void updateUser(User user)throws Exception;
	
	/**
	 * ɾ���û�
	 * @param id
	 * @throws Exception
	 */
	public void deleteUser(int id)throws Exception;
	
	/**
	 * ��ȡ��ӻ����޸���Ϣ���õ�����Ϣ
	 * @param id
	 * @param model
	 */
	public void getUpdateUserInfo(Integer id,Model model);

	
	/**
	 * ������޸�����
	 * @param userDto
	 */
	public void saveOrUpdate(UserDto userDto);

	
	/**
	 * ��ѯ��ҳ����
	 * @param dto
	 * @return
	 */
	public PageInfo<User> queryPage(UserDto dto);
	
	/**
	 * �����û���Ų�ѯȨ����Ϣ
	 * @param userId
	 * @return
	 */
	public List<Role> queryRoleByUserId(int userId);

	
	/*
	 *��ѯ����ҵ��Ա���û���Ϣ
	 *根据角色查询所有id
	 */
	public List<User> queryByRoleName(String roleSalesman);

}
