package com.grabasset.user.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.grabasset.service.config.test.PersistencyConfigTest;
import com.grabasset.user.bo.UserBo;
import com.grabasset.user.dao.UserDaoImpl;

public class GetUserTest {

	public static void main(String[] args) {
		ApplicationContext context = null;
		UserBo userBo = null;

		context = new AnnotationConfigApplicationContext(PersistencyConfigTest.class);
		UserDaoImpl userDaoImpl = context.getBean("userDao", UserDaoImpl.class);
		userBo = userDaoImpl.getUser(1);
		System.out.println(userBo.getMobileNo());
	}

}
