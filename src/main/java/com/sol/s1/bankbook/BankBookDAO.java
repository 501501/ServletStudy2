package com.sol.s1.bankbook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.sol.s1.util.DBConnector;

public class BankBookDAO {
	private DBConnector dbConnector;
	
	public BankBookDAO() {
		dbConnector = new DBConnector();
	}
	
	//setInsert
	public int setInsert(BankBookDTO bankbookDTO) {
		
		Connection con = dbConnector.getConnect();
		PreparedStatement st = null;
		int result = 0;
		
		//디비에서 bankbook_seq -> bankbook_sqe 오타
		String sql = "INSERT INTO BANKBOOK (bookNumber, bookName, bookRate, bookSale) "
				+ "VALUES (bankbook_sqe.nextval, ?, ?, ?)";
		try {
			st = con.prepareStatement(sql);
			st.setString(1, bankbookDTO.getBookName());
			st.setDouble(2, bankbookDTO.getBookRate());
			st.setInt(3, bankbookDTO.getBookSale());
			
			result = st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbConnector.disConnect(st, con);
		}
		return result;
	}
	
	
	//getList
	public ArrayList<BankBookDTO> getList() {
		ArrayList<BankBookDTO> bankBookDTOs = new ArrayList<BankBookDTO>();
		
		Connection con = dbConnector.getConnect();
		PreparedStatement st = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM BANKBOOK";
		
		try {
			st = con.prepareStatement(sql);
			rs = st.executeQuery();
			
			while(rs.next()) {
				BankBookDTO bankBookDTO = new BankBookDTO();
				bankBookDTO.setBookNumber(rs.getLong("bookNumber"));
				bankBookDTO.setBookName(rs.getString("bookName"));
				bankBookDTO.setBookRate(rs.getDouble("bookRate"));
				bankBookDTO.setBookSale(rs.getInt("bookSale"));
				bankBookDTOs.add(bankBookDTO);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbConnector.disConnect(rs, st, con);
		}
		return bankBookDTOs;
	}
	
	
	//getSelect
	public BankBookDTO getSelect(BankBookDTO bankBookDTO) {
		
		Connection con = dbConnector.getConnect();
		PreparedStatement st = null;
		ResultSet rs = null;
		BankBookDTO result = null;
		String sql = "SELECT * FROM BANKBOOK WHERE BOOKNUMBER = ?";

		try {
			st = con.prepareStatement(sql);
			st.setLong(1, bankBookDTO.getBookNumber());
			rs = st.executeQuery();
			
			if (rs.next()) {
				result = new BankBookDTO();
				result.setBookNumber(rs.getLong("bookNumber"));
				result.setBookName(rs.getString("bookName"));
				result.setBookRate(rs.getDouble("bookRate"));
				result.setBookSale(rs.getInt("bookSale"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbConnector.disConnect(rs, st, con);
		}
		return result;
	}
}
