package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.internousdev.ecsite.dto.LoginDTO;
import com.internousdev.ecsite.util.DBConnector;

public class LoginDAO {

	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();
	private LoginDTO loginDTO = new LoginDTO();
	public LoginDTO getLoginUserInfo(String loginUserId, String loginPassword) {
		String sql =
				"SELECT"
				+ "ubit.id, iit.item_name, ubit.total_price, ubit.total_count,"
				+ "ubit.pay, ubit.insert_date"
				+ "FROM"
				+ "user_buy_item_transaction ubit"
				+ "LEFT JOIN"
				+ "item_info_transaction iit"
				+ "ON"
				+ "ubit.item_transaction_id = iit.id"
				+ "WHERE"
				+ "ubit.item_transaction_id = ? AND ubit.user_master_id = ?"
				+ "ORDER BY"
				+ "insert_date DESC";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, loginUserId);
			preparedStatement.setString(2, loginPassword);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				loginDTO.setLoginId(resultSet.getString("login_id"));
				loginDTO.setLoginPassword(resultSet.getString("login_pass"));
				loginDTO.setUserName(resultSet.getString("user_name"));
				if(!(resultSet.getString("login_id").equals(null))) {
					loginDTO.setLoginFlg(true);
				}
			}

		} catch(Exception e) {
			e.printStackTrace();
		}
		return loginDTO;
		}
		public LoginDTO getLoginDTO() {
			return loginDTO;
	}

}
