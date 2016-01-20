package member.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.MemberBean;
import member.model.MemberService;

@WebServlet("/member.controller/ProcessFacebookLogin")
public class ProcessFacebookLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProcessFacebookLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException 
	{
	    request.setCharacterEncoding("UTF8");
	    response.setCharacterEncoding("UTF8");
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		
		System.out.println(name);
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//		response.getWriter().append("name: ").append(name);
//		response.getWriter().append("id: ").append(id);
		
		MemberBean bean = new MemberBean();
		bean.setMemberId(id);
		bean.setName(name);
		
		char[] chars = "1234567890".toCharArray();
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < 5; i++) {
		    char c = chars[random.nextInt(chars.length)];
		    sb.append(c);
		}
		String newPassword = sb.toString();
		//System.out.println(output);
		bean.setMemberPassword(id+newPassword);
		//System.out.println(bean.getMemberPassword());
		MemberService memberService = new MemberService();
		try
		{
			memberService.insertMember(bean);
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		request.setAttribute("memberBean", bean);
		
		MemberBean mb = memberService.login(id, newPassword);
		if(bean==null) 
		{
			System.out.println("login fail...");
			request.getRequestDispatcher(
					"/pages/login.jsp").forward(request, response);
		} 
		else
		{//登入成功!
			HttpSession session = request.getSession();
			//將bean物件放入Session範圍內,識別字串為"user"
			session.setAttribute("user", bean);
			String path = request.getContextPath();
			response.sendRedirect(path+"/index.jsp");	
		}
		//String path = request.getContextPath();
//		RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
//		rd.forward(request, response);
//		return;
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
