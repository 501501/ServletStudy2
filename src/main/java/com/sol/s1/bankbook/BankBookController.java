package com.sol.s1.bankbook;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.View;

public class BankBookController {
	
	private BankBookDAO bankBookDAO;
	
	public BankBookController() {
		bankBookDAO = new BankBookDAO();
	}
	
	public void start(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("BankBook Controller 실행");
		String uri = request.getRequestURI();
		int index = uri.lastIndexOf("/");
		String path = uri.substring(index+1);
		
		/** 		BankBook List		 */
		if(path.equals("bankbookList.do")) {
			System.out.println("상품목록 진행");
			ArrayList<BankBookDTO> bankBookDTOs = new ArrayList<BankBookDTO>();
			bankBookDTOs = bankBookDAO.getList();
			//for(초기식;조건식;증감식)
//			for(int i=0;i<bankBookDTOs.size();i++) {
//			System.out.println(bankBookDTOs.get(i).getBookNumber());
//			System.out.println(bankBookDTOs.get(i).getBookName());
//			System.out.println(bankBookDTOs.get(i).getBookRate());
//			System.out.println(bankBookDTOs.get(i).getBookSale());
//			}
			
			//for(모은타입명 변수명:컬렉션참조변수명)
			for(BankBookDTO bankBookDTO:bankBookDTOs) {
				System.out.println(bankBookDTO.getBookName());
			}
			
			request.setAttribute("list", bankBookDTOs);
			RequestDispatcher view = request.getRequestDispatcher("../WEB-INF/views/bankbook/bankbookList.jsp");
			try {
				view.forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			
			
		} else if(path.equals("bankbookInsert.do")) {
			System.out.println("상품등록 진행");
			
			String method = request.getMethod();
			System.out.println("Method: "+method);
			
			//POST 방식
			if(method.equals("POST")) {
				System.out.println("insert2");
				// 파라미터값 출력
				String bookName = request.getParameter("bookName");
				String bookRate = request.getParameter("bookRate");
				String bookSale = request.getParameter("bookSale");
				System.out.println("bookName: "+bookName);
				System.out.println("bookRate: "+bookRate);
				System.out.println("bookSale: "+bookSale);
				
				BankBookDTO bankBookDTO = new BankBookDTO();
				bankBookDTO.setBookName(bookName);
				bankBookDTO.setBookRate(Double.parseDouble(bookRate));
				bankBookDTO.setBookSale(Integer.parseInt(bookSale));
				
				int result = bankBookDAO.setInsert(bankBookDTO);
				System.out.println(result);
				
//				ArrayList<BankBookDTO> ar = bankBookDAO.getList();
//				request.setAttribute("list", ar);
				
				//Redirect 방식
				try {
					response.sendRedirect("./bankbookList.do");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} 
			
			//GET 방식
			else {
				RequestDispatcher view = request.getRequestDispatcher("../WEB-INF/views/bankbook/bankbookInsert.jsp");
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

		/** BankBook Select */
		else if (path.equals("bankbookSelect.do")) {
			System.out.println("상품 상세조회 진행");
			String num = request.getParameter("bookNumber");
			long num2 = Long.parseLong(num);
			BankBookDTO bankBookDTO = new BankBookDTO();
			bankBookDTO.setBookNumber(num2);
			bankBookDTO = bankBookDAO.getSelect(bankBookDTO);
			System.out.println(bankBookDTO.getBookName());

			request.setAttribute("dto", bankBookDTO);

			RequestDispatcher view = request.getRequestDispatcher("../WEB-INF/views/bankbook/bankbookSelect.jsp");
			try {
				view.forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("그 외 나머지");
		}
	}
}
