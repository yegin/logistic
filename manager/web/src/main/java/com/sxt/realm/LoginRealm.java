package com.sxt.realm;

import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.sxt.pojo.User;
import com.sxt.service.IUserService;

public class LoginRealm extends AuthorizingRealm{

	
	@Resource
	private IUserService userService;
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		
		UsernamePasswordToken usertoken=(UsernamePasswordToken) token;
		String username = (String) usertoken.getPrincipal();
		User user = new User();
		user.setUserName(username);
		System.out.println(user);
		List<User> users = userService.query(user);
		if(users==null){
			return null;
		}
		user=users.get(0);
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getPassword(),this.getName());
		return info;
	}

}
