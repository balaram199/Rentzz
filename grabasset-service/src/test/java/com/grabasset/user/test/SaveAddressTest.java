package com.grabasset.user.test;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.grabasset.csr.bo.AddressBo;
import com.grabasset.service.config.test.PersistencyConfigTest;
import com.grabasset.user.dao.UserDaoImpl;

public class SaveAddressTest {

	public static void main(String[] args) {
		int key = 0;
		AddressBo addressBo = null;
		UserDaoImpl userDaoImpl = null;
		ApplicationContext context = null;

		context = new AnnotationConfigApplicationContext(PersistencyConfigTest.class);

		userDaoImpl = context.getBean("userDao", UserDaoImpl.class);
		addressBo = new AddressBo();
		addressBo.setAddressLine1("504");
		addressBo.setAddressLine2("housng bord");
		addressBo.setCity(1);
		addressBo.setState(1);
		addressBo.setCountry(1);
		addressBo.setZip(54637);
		addressBo.setCreatedBy("system");
		addressBo.setCratedDt(new Date());
		addressBo.setLastmodifiedBy("system");
		addressBo.setLastmodifiedDt(new Date());
		key = userDaoImpl.saveAddress(addressBo);
		System.out.println(key);

	}
}
