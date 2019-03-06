package com.grabasset.user.test;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.grabasset.csr.bo.UserDetailsBo;
import com.grabasset.service.config.test.PersistencyConfigTest;
import com.grabasset.user.bo.UserBo;
import com.grabasset.user.dao.UserDaoImpl;
import com.grabasset.util.GrabAssetConstants;

public class SaveUserDetailsTest {

	public static void main(String[] args) {

		ApplicationContext context = null;
		UserDetailsBo userDetails = null;
		context = new AnnotationConfigApplicationContext(PersistencyConfigTest.class);

		UserDaoImpl userDaoImpl = context.getBean("userDao", UserDaoImpl.class);
		userDetails = new UserDetailsBo();
		userDetails.setUserAddressId(21);
		userDetails.setSystemUserId(155);
		userDetails.setIdentificationNo("7684659364");
		userDetails.setIdentifictionType("adhar");
		userDetails.setCreatedDate(new Date());
		userDetails.setLastModifiedBy(GrabAssetConstants.LAST_MODIFIED_BY_SYSTEM);
		userDetails.setModifiedDate(new Date());
		userDetails.setCreatedBy(GrabAssetConstants.LAST_MODIFIED_BY_SYSTEM);
		//userDaoImpl.saveUser(userDetails);
	}
}
