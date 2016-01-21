package member.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admin.model.AdminBean;
import member.model.MemberBean;
import member.model.MemberService;

@WebServlet("/member.controller/ProcessLogin")
public class ProcessLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	
    public ProcessLogin() {
        super();
    }

	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException 
	{
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException 
	{
		//接收資料
		String memberId = request.getParameter("memberId");
		String memberPassword = request.getParameter("memberPassword");
		//驗證資料
		Map<String, String> errors = new HashMap<String, String>();
		request.setAttribute("errors", errors);
				
		if(memberId==null || memberId.length()==0) {
			errors.put("memberId", "請輸入帳號");
		}
		if(memberPassword==null || memberPassword.length()==0) {
			errors.put("memberPassword", "請輸入密碼");
		}
		if(errors!=null && !errors.isEmpty()) {
			request.getRequestDispatcher(
					"/pages/login.jsp").forward(request, response);
			return;
		}
		//呼叫Model
		MemberService memberService = new MemberService();
		MemberBean bean = memberService.login(memberId, memberPassword);
		MemberBean selectReceive = memberService.selectMember(memberId);
		//根據Model執行結果，呼叫View
		if(bean==null) 
		{
			System.out.println("login fail...");
			errors.put("memberPassword", "登入失敗，請檢查帳號或密碼是否正確");
			request.getRequestDispatcher(
					"/pages/login.jsp").forward(request, response);
		} 
		else
		{//登入成功!
			HttpSession session = request.getSession();
			String requestURI  = (String) session.getAttribute("requestURI");
			//將bean物件放入Session範圍內,識別字串為"user"
			session.setAttribute("user", bean);
			session.setAttribute("receiveInformation", selectReceive);
			String path = request.getContextPath();
			if(requestURI==null){
				System.out.println("111111111111111");
				response.sendRedirect(path+"/index.jsp");	
			}else{
				session.removeAttribute("requestURI");
				System.out.println(requestURI);
				System.out.println("222222");
				response.sendRedirect(requestURI);	
			}
		}
		
	}
	

}
