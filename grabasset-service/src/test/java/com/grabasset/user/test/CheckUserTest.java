
package com.grabasset.user.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.grabasset.service.config.test.PersistencyConfigTest;
import com.grabasset.user.bo.UserBo;
import com.grabasset.user.dao.UserDaoImpl;

public class CheckUserTest {
	public static void main(String[] args) {

		ApplicationContext context = null;
		UserBo userBo = null;
		int key = 0;

		context = new AnnotationConfigApplicationContext(PersistencyConfigTest.class);

		UserDaoImpl userDaoImpl = context.getBean("userDao", UserDaoImpl.class);

		boolean user = userDaoImpl.isUserNameExists("pushpa@gmail.com");
		System.out.println(user);

		/*
		 * int role_id = userDaoImpl.getRole(Roles.MEMBER_ROLE);
		 * System.out.println(role_id);
		 */

	}
}
