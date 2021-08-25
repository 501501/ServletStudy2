package com.sol.s1.account;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AccountController {
	private AccountDAO accountDAO;
	
	public AccountController() {
		accountDAO = new AccountDAO();
	}
	
	public void start(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Account Controller 실행");
		String uri = request.getRequestURI();
		int index = uri.lastIndexOf("/");
		String path = uri.substring(index+1);
		
		if(path.equals("accountList.do")) {
			System.out.println("계좌목록 진행");
			ArrayList<AccountDTO> ar = new ArrayList<AccountDTO>();
			ar = accountDAO.getList();
			
			for(AccountDTO accountDTO:ar) {
				System.out.println(accountDTO.getAccountNumber());
				System.out.println(accountDTO.getId());
				System.out.println(accountDTO.getBookNumber());
				System.out.println(accountDTO.getAccountDate());
				System.out.println(accountDTO.getAccountBalance());
			}
			
			request.setAttribute("list", ar);
			RequestDispatcher view = request.getRequestDispatcher("../WEB-INF/views/account/accountList.jsp");
			try {
				view.forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
