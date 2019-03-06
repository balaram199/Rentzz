package com.grabasset.user.test;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.grabasset.service.config.test.PersistencyConfigTest;
import com.grabasset.user.bo.UserBo;
import com.grabasset.user.dao.UserDaoImpl;

public class SaveUserTest {

	public static void main(String[] args) {

		ApplicationContext context = null;
		UserBo userBo = null;
		int key = 0;

		context = new AnnotationConfigApplicationContext(PersistencyConfigTest.class);

		UserDaoImpl userDaoImpl = context.getBean("userDao", UserDaoImpl.class);

		userBo = new UserBo();
		userBo.setFirstName("devid");
		userBo.setLastName("s");
		userBo.setMobileNo("896874765");
		userBo.setUserName("devid@gmail.com");
		userBo.setPassword("46282");
		userBo.setStatus("R");
		userBo.setRoleId(1);
		userBo.setActivationCode("987h");
		userBo.setRegisteredDate(new Date());
		// userBo.setActivationDate(new Date());
		userBo.setCreatedBy("system");
		userBo.setCreatedDate(new Date());
		userBo.setLastModifiedBy("system");
		userBo.setLastModifiedDate(new Date());
		key = userDaoImpl.saveUser(userBo);
		System.out.println(key);
	}

}
