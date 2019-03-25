package com.sxt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
		UserExample example = new UserExample();
		if(user!=null){
			if(!"".equals(user.getUserName())&&user.getUserName()!=null){
				example.createCriteria().andUserNameEqualTo(user.getUserName());
			}
		}
		List<User> list = usermapper.selectByExample(example);
		return list;
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
		
		usermapper.deleteRoleIdByUserId(id);
		usermapper.deleteByPrimaryKey(id);
		
	}
	
	/**
	 * ��ȡ��ӻ����޸���Ϣ���õ�����Ϣ
	 * @param id
	 * @param model
	 */
	@Override
	public void getUpdateUserInfo(Integer id, Model model) {
		
		RoleExample roleExample = new RoleExample();
		List<Role> roles = roleMapper.selectByExample(roleExample);
		if (id!=null&&id>0) {
			User user = usermapper.selectByPrimaryKey(id);
			List<Integer> roleIds = usermapper.selectRoleIdByUserId(id);
			model.addAttribute("user", user);
			model.addAttribute("roleIds", roleIds);
		}
		model.addAttribute("roles", roles);
	}

	@Override
	public void saveOrUpdate(UserDto userDto) {
		// ��ȡUser����
		User user = userDto.getUser();
		
		// ��ȡ�����Ľ�ɫ��Ϣ
		List<Integer> roles = userDto.getRoles();
		
		
		// �ж�����ӻ����޸�����
		if(user.getUserId()!=null && user.getUserId() > 0){
			// ��ʾuserId���ڣ�˵���Ǹ���
		}else{
			// ������id˵�����������
			// ������û����� ��ȡ���ɵ�userId
			usermapper.insert(user);
			// �ٱ����û��ͽ�ɫ�Ķ�Ӧ��ϵ����һ�������д���
			if(roles!=null && roles.size() > 0){
				usermapper.updateByPrimaryKeySelective(user);
				
				// �����û�IDɾ������Ľ�ɫ��Ϣ
				usermapper.deleteRoleIdByUserId(user.getUserId());
				// �ٱ����û��ͽ�ɫ�Ĺ�����ϵ
				if(roles!=null && roles.size() > 0){
					for (Integer roleId : roles) {
						usermapper.inserUserIdAndRoleId(user.getUserId(),roleId);
					}
				}

			}else{
				// ������id˵�����������
				// ������û����� ��ȡ���ɵ�userId
				usermapper.insert(user);
				// �ٱ����û��ͽ�ɫ�Ķ�Ӧ��ϵ����һ�������д���
				if(roles!=null && roles.size() > 0){
					for (Integer roleId : roles) {
						usermapper.inserUserIdAndRoleId(user.getUserId(),roleId);
					}
				}
			}
		}
	}

	@Override
	public PageInfo<User> queryPage(UserDto dto) {
		PageHelper.startPage(dto.getPageNum(), dto.getPageSize());
		List<User> list = this.query(dto.getUser());
		PageInfo<User> pageInfo = new PageInfo<User>(list);
		return pageInfo;
	
	}

	@Override
	public List<Role> queryRoleByUserId(int userId) {
		// TODO Auto-generated method stub
		return roleMapper.queryRoleByUserID(userId);
	}

	

	/**
	 * ��ѯҵ��Ա���û���Ϣ
	 */
	@Override
	public List<User> queryByRoleName(String roleSalesman) {
		// TODO Auto-generated method stub
		return usermapper.queryUserByRoleName(roleSalesman);
	}
}
	

