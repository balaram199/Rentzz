package com.grabasset.csr.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grabasset.csr.bo.CSRDetailsBo;
import com.grabasset.user.bo.CityBo;
import com.grabasset.user.bo.CountryBo;
import com.grabasset.user.bo.StateBo;
import com.grabasset.user.dao.UserDao;
import com.grabasset.util.GrabAssetConstants;

@Service
public class ManageCsrServiceImpl implements ManageCsrService {

	@Autowired
	private UserDao userDao;

	@Override
	@Transactional(readOnly = false)
	public void registerCsr(CSRDetailsBo csrbo) {

		int roleId = 0;
		int addressId = 0;
		int sysUserId = 0;

		roleId = userDao.getRole(GrabAssetConstants.ROLE_CSR);

		csrbo.getAddressBo().setCreatedBy(GrabAssetConstants.LAST_MODIFIED_BY_SYSTEM);
		csrbo.getAddressBo().setCratedDt(new Date());
		csrbo.getAddressBo().setLastmodifiedBy(GrabAssetConstants.LAST_MODIFIED_BY_SYSTEM);
		csrbo.getAddressBo().setLastmodifiedDt(new Date());
		addressId = userDao.saveAddress(csrbo.getAddressBo());

		csrbo.getUserBo().setRoleId(roleId);
		csrbo.getUserBo().setCreatedBy(GrabAssetConstants.LAST_MODIFIED_BY_SYSTEM);
		csrbo.getUserBo().setCreatedDate(new Date());
		csrbo.getUserBo().setLastModifiedBy(GrabAssetConstants.LAST_MODIFIED_BY_SYSTEM);
		csrbo.getUserBo().setLastModifiedDate(new Date());
		csrbo.getUserBo().setStatus(GrabAssetConstants.USER_ACTIVATED);
		csrbo.getUserBo().setRegisteredDate(new Date());
		csrbo.getUserBo().setActivationDate(new Date());
		sysUserId = userDao.saveUser(csrbo.getUserBo());

		csrbo.getUserDetailsBo().setSystemUserId(sysUserId);
		csrbo.getUserDetailsBo().setUserAddressId(addressId);
		csrbo.getUserDetailsBo().setCreatedBy(GrabAssetConstants.LAST_MODIFIED_BY_SYSTEM);
		csrbo.getUserDetailsBo().setCreatedDate(new Date());
		csrbo.getUserDetailsBo().setLastModifiedBy(GrabAssetConstants.LAST_MODIFIED_BY_SYSTEM);
		csrbo.getUserDetailsBo().setModifiedDate(new Date());

		userDao.saveUser(csrbo.getUserDetailsBo());

	}

	@Override
	public List<CityBo> getCities() {
		return userDao.getCities();
	}

	@Override
	public List<StateBo> getStates() {
		return userDao.getStates();
	}

	 @Override
	public List<CountryBo> getCountries() {
		return userDao.getCountries();
	}

}
