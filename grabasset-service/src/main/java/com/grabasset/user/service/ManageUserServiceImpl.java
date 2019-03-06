package com.grabasset.user.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grabasset.exception.UserActivationFailedException;
import com.grabasset.exception.UserAlreadyActivatedException;
import com.grabasset.logger.GrabAssetLogger;
import com.grabasset.mail.dto.Message;
import com.grabasset.mail.service.GrabassetMailService;
import com.grabasset.user.bo.UserBo;
import com.grabasset.user.dao.UserDao;
import com.grabasset.util.Base64Converter;
import com.grabasset.util.GrabAssetConstants;
import com.grabasset.util.GrabAssetMail;

@Service
public class ManageUserServiceImpl implements ManageUserService {
	private static final GrabAssetLogger logger = GrabAssetLogger.getLogger(ManageUserServiceImpl.class);

	@Autowired
	private Environment environment;

	@Autowired
	private UserDao userDao;

	@Autowired
	private GrabassetMailService mailService;

	@Override
	@Transactional(readOnly = false)
	public void registerUser(UserBo userBo) {

		int roleId = 0;
		int userId = 0;
		Message message = null;
		String activationCode = null;
		String base64activationCode = null;
		Map<String, String> parameters = null;

		activationCode = getActivationCode();
		roleId = userDao.getRole(GrabAssetConstants.ROLE_MEMBER);
		userBo.setActivationCode(activationCode);
		userBo.setStatus(GrabAssetConstants.USER_REGISTERED);
		userBo.setRoleId(roleId);
		userBo.setRegisteredDate(new Date());
		userBo.setCreatedBy(GrabAssetConstants.LAST_MODIFIED_BY_SYSTEM);
		userBo.setCreatedDate(new Date());
		userBo.setLastModifiedBy(GrabAssetConstants.LAST_MODIFIED_BY_SYSTEM);
		userBo.setLastModifiedDate(new Date());
		userId = userDao.saveUser(userBo);
		logger.info(userBo.getUserName() + " is registered");
		logger.error("user reg failed");
		logger.debug("user debug");
		message = new Message();
		parameters = new HashMap<>();

		base64activationCode = Base64Converter.base64Encoder(userBo.getActivationCode());

		parameters.put("username", userBo.getUserName());
		parameters.put("host", environment.getProperty("hostName"));
		parameters.put("port", environment.getProperty("portNumber"));
		parameters.put("activationcode", base64activationCode);
		parameters.put("userid", String.valueOf(userId));

		message.setFrom(GrabAssetMail.INFO);
		message.setTemplateName(GrabAssetMail.CUSTOMER_REGISTRATION_TEMPLATE);
		message.setTo(userBo.getUserName());
		message.setProperties(parameters);

		try {
			mailService.sendMail(message);
		} catch (Exception e) {
			// do somthing
		}

	}

	private String getActivationCode() {
		Integer activationCode = 0;
		Random rand = null;

		rand = new Random();
		activationCode = rand.nextInt(100000);
		return activationCode.toString();
	}

	@Override
	@Transactional(readOnly = true)
	public boolean isUserNameExists(String userName) {
		if (userDao.isUserNameExists(userName)) {
			return true;
		}
		return false;
	}

	@Override
	@Transactional(readOnly = false)
	public void activateUser(String activationCode, int userId) {

		UserBo userBo = null;
		String decodeactivationCode = null;

		decodeactivationCode = Base64Converter.base64Decoder(activationCode);

		userBo = userDao.getUser(userId);

		if (!decodeactivationCode.equals(userBo.getActivationCode())) {
			throw new UserActivationFailedException("activation should not be matched");

		}
		if (userBo.getStatus().equals(GrabAssetConstants.USER_ACTIVATED)) {
			throw new UserAlreadyActivatedException("user already activated");
		}

		userBo.setStatus(GrabAssetConstants.USER_ACTIVATED);
		userBo.setActivationDate(new Date());
		userBo.setLastModifiedBy("system");
		userBo.setLastModifiedDate(new Date());

		userDao.updateUserStatus(userBo);
	}

}
