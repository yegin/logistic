package com.sxt.service;

import java.util.List;

import org.springframework.ui.Model;

import com.sxt.dto.UserDto;
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
	 * �����û�
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
	 * ��ȡ���ӻ����޸���Ϣ���õ�����Ϣ
	 * @param id
	 * @param model
	 */
	public void getUpdateUserInfo(Integer id,Model model);

	
	/**
	 * ������޸�����
	 * @param userDto
	 */
	public void saveOrUpdate(UserDto userDto);	
	
}