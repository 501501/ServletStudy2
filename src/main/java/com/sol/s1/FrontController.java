package com.sol.s1;

import java.io.IOException;
import java.util.StringTokenizer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sol.s1.account.AccountController;
import com.sol.s1.bankbook.BankBookController;
import com.sol.s1.member.MemberController;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("/FrontController")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private MemberController memberController;
	private BankBookController bankBookController;
	private AccountController accountController;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
        memberController = new MemberController();
        bankBookController = new BankBookController();
        accountController = new AccountController();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Front Controller 실행");
//		String url = request.getRequestURL().toString();
		String uri = request.getRequestURI();
//		System.out.println("url: "+url);
		System.out.println("uri: "+uri);
		
		//StringTokenizer
//		StringTokenizer st = new StringTokenizer(uri, "/");
//		String s1 = st.nextToken();
//		String s2 = st.nextToken();
//		String path = s2;
//		path = s2;
//		System.out.println(path);
		
		//subString
		int startIndex = request.getContextPath().length();
		int lastIndex = uri.lastIndexOf("/");
		String path = uri.substring(startIndex, lastIndex);
		
		if (path.equals("/member")) {
			try {
				memberController.start(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (path.equals("/bankbook")) {
			bankBookController.start(request, response);
		} else if (path.equals("/account")) {
			accountController.start(request, response);
		}
		else {
			System.out.println("없는 URL");
		}
//		System.out.println("path: "+path);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
