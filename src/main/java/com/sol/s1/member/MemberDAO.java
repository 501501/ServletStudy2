package com.sol.s1.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.sol.s1.util.DBConnector;

public class MemberDAO {
	private DBConnector dbConnector;
	
	public MemberDAO() {
		dbConnector = new DBConnector();
	}
	
	// 회원가입 메서드 setInsert
	public int memberJoin(MemberDTO memberDTO) {
		Connection con = dbConnector.getConnect();
		PreparedStatement st = null;
		int result = 0;
		
		String sql = "INSERT INTO MEMBER(id, pw, name, phone, email) VALUES (?, ?, ?, ?, ?)";
		
		try {
			st = con.prepareStatement(sql);
			st.setString(1, memberDTO.getId());
			st.setString(2, memberDTO.getPw());
			st.setString(3, memberDTO.getName());
			st.setString(4, memberDTO.getPhone());
			st.setString(5, memberDTO.getEmail());
			
			result = st.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbConnector.disConnect(st, con);
		}
		return result;
	}
}
