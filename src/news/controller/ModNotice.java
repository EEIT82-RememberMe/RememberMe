package news.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import news.model.NoticeBean;
import news.model.NoticeService;

@WebServlet("/news.controller/ModNotice")
public class ModNotice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ModNotice() {
        super();
    }

	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException 
	{
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		String page = request.getParameter("page");
		if(action.equals("delete"))
		{		
			String num = request.getParameter("number");
			int number = Integer.parseInt(num);
			
			NoticeBean mb = new NoticeBean();
			NoticeService noticeService = new NoticeService();
			mb.setNumber(number);
			boolean result = noticeService.delete(mb);
			RequestDispatcher rd = request.getRequestDispatcher("/news.controller/NewsQueryList?action=notice&page="+page);
			rd.forward(request, response);
			return;
		}
		else
		{
			this.doPost(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException 
	{
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        
		String title = request.getParameter("title");
		String noticeContent = request.getParameter("noticeContent");	
		String photo = request.getParameter("photo");
		String date = request.getParameter("date");
		
		String action = request.getParameter("action");
		
		String dateCreateString = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date().getTime());
		session.setAttribute("dateCreateString", dateCreateString);
		Timestamp dateCreate = Timestamp.valueOf(dateCreateString);
		Timestamp dateUpdate = dateCreate;
		
		NoticeBean mb = new NoticeBean(title,noticeContent,photo,date,dateUpdate);
		NoticeService noticeService = new NoticeService();
		if("公佈".equals(action))
		{
			NoticeBean result = noticeService.insert(mb);
			session.setAttribute("select", result);
//			RequestDispatcher rd = request.getRequestDispatcher("/news.controller/NewsQueryList?action=notice&page=1");
//			rd.forward(request, response);
			response.sendRedirect("../news.controller/NewsQueryList?action=notice&page=1");
			return;
		}
		else if("更新".equals(action))
		{
			String page = request.getParameter("page");
			String num = request.getParameter("number");
			int number = Integer.parseInt(num);
			System.out.println(number);
			mb.setNumber(number);
			NoticeBean result = noticeService.update(mb);
			session.setAttribute("select", result);
//			RequestDispatcher rd = request.getRequestDispatcher("/news.controller/NewsQueryList?action=notice&page="+page);
//			rd.forward(request, response);
			response.sendRedirect("../news.controller/NewsQueryList?action=notice&page="+page);
			return;
		}
	}
}
