package member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.MemberBean;
import member.model.MemberService;


@WebServlet("/member.controller/MemberManager")
public class MemberManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberManager() 
    {
        super();
    }

	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException 
	{
		MemberBean bean = new MemberBean();
		MemberService noticeService = new MemberService();
		List<MemberBean> result = noticeService.select(bean);
		request.setAttribute("select", result);
		request.getRequestDispatcher("/admin/memberList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
