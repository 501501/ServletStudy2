package com.sol.s1.account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sol.s1.util.DBConnector;

public class AccountDAO {
	
	private DBConnector dbConnector;
	
	public AccountDAO() {
		dbConnector = new DBConnector();
	}
	
	public ArrayList<AccountDTO> getList() {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		ArrayList<AccountDTO> ar = new ArrayList<AccountDTO>();
		
		con = dbConnector.getConnect();
		String sql = "SELECT * FROM ACCOUNT";
		try {
			st = con.prepareStatement(sql);
			rs = st.executeQuery();
			
			while(rs.next()) {
				AccountDTO dto = new AccountDTO();
				dto.setAccountNumber(rs.getLong("accountNumber"));
				dto.setId(rs.getString("id"));
				dto.setBookNumber(rs.getLong("bookNumber"));
				dto.setAccountDate(rs.getDate("accountDate"));
				dto.setAccountBalance(rs.getLong("accountBalance"));
				ar.add(dto);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbConnector.disConnect(rs, st, con);
		}
		return ar;
	}
}
