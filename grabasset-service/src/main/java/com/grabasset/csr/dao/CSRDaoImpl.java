package com.grabasset.csr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import com.grabasset.csr.bo.AddressBo;
import com.grabasset.csr.bo.CSRDetailsBo;

@Repository
public class CSRDaoImpl implements CSRDao {

	private final String SQL_SAVE_CSR = "insert into user(first_nm,last_nm,mobile_nbr,"
			+ "user_nm,password,role_id,activation_code,status,registerd_dt,created_by,created_dt,last_modified_by,last_modified_dt)values(?,?,?,?,?,?,?,?,?,?,?,?,?)";;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public boolean saveCSR(CSRDetailsBo csrbo) {
		GeneratedKeyHolder holder = null;
		int rows = 0;
		long key = 0;
		holder = new GeneratedKeyHolder();
		
		key = (long) holder.getKey();

		return false;
	}

}
