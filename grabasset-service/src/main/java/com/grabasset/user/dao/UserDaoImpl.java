package com.grabasset.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.grabasset.csr.bo.AddressBo;
import com.grabasset.user.bo.UserBo;
import com.grabasset.util.DateConverter;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

	private final String SQL_SAVE_USER = "insert into user(first_nm,last_nm,mobile_nbr,"
			+ "user_nm,password,role_id,activation_code,status,registerd_dt,created_by,created_dt,last_modified_by,last_modified_dt)values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private final String SQL_FIND_USER = "select count(*) from user where user_nm=?";
	private final String SQL_GET_USER = "select  system_user_id,first_nm,last_nm,mobile_nbr,user_nm,password,role_id,activation_code,status,registerd_dt,activation_dt,created_by,created_dt,last_modified_by,last_modified_dt from user where system_user_id=?";
	private final String SQL_UPDATE_USER = "update users set status = ?,activation_dt=?,last_modified_by=?,last_modified_dt=? where system_user_id = ?";
	private final String SQL_GET_ROLE = "select role_id from role where role_code=?";
	private final String SQL_SAVE_ADDRESS = "insert into address(address_line1,address_line2,city,state,zip,country,created_by,created_dt,last_modified_by,last_modified_dt)values(?,?,?,?,?,?,?,?,?,?,?)";
	//private final String SQL_FIND_AUTH_USER="select  u.user_nm,u.password,u.status,r.role_id from user u inner join role r where u.user_nm=? ";
	private final String SQL_FIND_AUTH_USER="select  u.user_nm,u.password,u.status,u.role_id from user u  where u.user_nm=? ";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int saveUser(UserBo userBo) {

		GeneratedKeyHolder keyHolder = null;
		int rows = 0;
		long key = 0;

		keyHolder = new GeneratedKeyHolder();

		rows = jdbcTemplate.update(new UserPreparedStatementCreator(userBo), keyHolder);

		key = (long) keyHolder.getKey();
		return (int) key;
	}

	@Override
	public boolean isUserNameExists(String userName) {
		int userId = 0;

		userId = jdbcTemplate.queryForObject(SQL_FIND_USER, new Object[] { userName }, Integer.class);

		if (userId != 0) {
			return true;
		}
		return false;
	}

	@Override
	public int getRole(String roleCode) {
		return jdbcTemplate.queryForObject(SQL_GET_ROLE, new Object[] { roleCode }, Integer.class);
	}

	@Override
	public UserBo getUser(int userId) {
		return (UserBo) jdbcTemplate.queryForObject(SQL_GET_USER, new Object[] { userId }, new UserRowMapper());
	}

	@Override
	public boolean updateUserStatus(UserBo userBo) {

		jdbcTemplate.update(SQL_UPDATE_USER, new Object[] { userBo.getStatus(), userBo.getActivationDate(),
				userBo.getLastModifiedBy(), DateConverter.utilDateTosqlTimeStamp(userBo.getLastModifiedDate()) });

		return false;
	}

	@Override
	public int saveAddress(AddressBo addressBo) {
		long key = 0;
		KeyHolder keyHolder = null;

		keyHolder = new GeneratedKeyHolder();

		jdbcTemplate.update(new AddressPreparedStatementCreator(addressBo), keyHolder);

		key = (long) keyHolder.getKey();
		return (int) key;
	}

	private final class UserPreparedStatementCreator implements PreparedStatementCreator {

		private UserBo userBo;

		public UserPreparedStatementCreator(UserBo userBo) {
			this.userBo = userBo;
		}

		@Override
		public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
			PreparedStatement pstm = null;
			pstm = con.prepareStatement(SQL_SAVE_USER, (String[]) new String[] { "system_user_id" });
			pstm.setString(1, userBo.getFirstName());
			pstm.setString(2, userBo.getLastName());
			pstm.setString(3, userBo.getMobileNo());
			pstm.setString(4, userBo.getUserName());
			pstm.setString(5, userBo.getPassword());
			pstm.setInt(6, userBo.getRoleId());
			pstm.setString(7, userBo.getActivationCode());
			pstm.setString(8, userBo.getStatus());
			pstm.setDate(9, DateConverter.utilDateToSqlDate(userBo.getRegisteredDate()));
			pstm.setString(10, userBo.getCreatedBy());
			pstm.setTimestamp(11, DateConverter.utilDateTosqlTimeStamp(userBo.getCreatedDate()));
			pstm.setString(12, userBo.getLastModifiedBy());
			pstm.setTimestamp(13, DateConverter.utilDateTosqlTimeStamp(userBo.getLastModifiedDate()));

			return pstm;
		}

	}

	private final class UserRowMapper implements RowMapper<UserBo> {

		@Override
		public UserBo mapRow(ResultSet rs, int row) throws SQLException {

			UserBo userBo = null;

			userBo = new UserBo();
			userBo.setSystemUserId(rs.getInt(1));
			userBo.setFirstName(rs.getString(2));
			userBo.setLastName(rs.getString(3));
			userBo.setMobileNo(rs.getString(4));
			userBo.setUserName(rs.getString(5));
			userBo.setPassword(rs.getString(6));

			userBo.setRoleId(rs.getInt(7));
			userBo.setActivationCode(rs.getString(8));
			userBo.setStatus(rs.getString(9));
			userBo.setRegisteredDate(rs.getDate(10));
			userBo.setActivationDate(rs.getDate(11));
			userBo.setCreatedBy(rs.getString(12));
			userBo.setCreatedDate(rs.getDate(13));
			userBo.setLastModifiedBy(rs.getString(14));
			userBo.setLastModifiedDate(rs.getDate(15));
			return userBo;
		}
	}

	private class AddressPreparedStatementCreator implements PreparedStatementCreator {

		private AddressBo addressBo;

		public AddressPreparedStatementCreator(AddressBo addressBo) {
			super();
			this.addressBo = addressBo;
		}

		@Override
		public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
			PreparedStatement pstm = null;
			pstm = connection.prepareStatement(SQL_SAVE_ADDRESS, (String[]) new String[] { "address_id" });
			pstm.setString(1, addressBo.getAddressLine1());
			pstm.setString(2, addressBo.getAddressLine2());
			pstm.setInt(3, addressBo.getCity());
			pstm.setInt(4, addressBo.getState());
			pstm.setInt(5, addressBo.getZip());
			pstm.setInt(6, addressBo.getCountry());
			pstm.setString(7, addressBo.getCreatedBy());
			pstm.setTimestamp(8, DateConverter.utilDateTosqlTimeStamp(addressBo.getCratedDt()));
			pstm.setString(9, addressBo.getLastmodifiedBy());
			pstm.setTimestamp(10, DateConverter.utilDateTosqlTimeStamp(addressBo.getLastmodifiedDt()));

			return pstm;
		}

	}

	@Override
	public UserBo findAuthenticatedUser(String userName) {
		return jdbcTemplate.queryForObject(SQL_FIND_AUTH_USER, new Object[] { userName}, new RowMapper<UserBo>(){
			@Override
			public UserBo mapRow(ResultSet rs, int rowNum) throws SQLException {
				UserBo userBo=null;
/*				userBo=getUserBo();*/
				userBo=new UserBo();
				userBo.setUserName(rs.getString(1));
				userBo.setPassword(rs.getString(2));
				userBo.setStatus(rs.getString(3));
				userBo.setRoleId(rs.getInt(4));
				
				return userBo;
			}});
	}
/*	@Lookup
	public UserBo getUserBo(){
		return null;
	}*/
}
