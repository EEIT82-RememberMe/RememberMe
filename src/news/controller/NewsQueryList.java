package news.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import news.model.MusicBean;
import news.model.MusicService;
import news.model.NoticeBean;
import news.model.NoticeService;

@WebServlet("/news.controller/NewsQueryList")
public class NewsQueryList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException 
	{
		String action = request.getParameter("action");
		String pageStr = request.getParameter("page");
		int page = Integer.valueOf(pageStr);
		
		if(action.equals("notice"))
		{
			NoticeBean bean = new NoticeBean();
			NoticeService noticeService = new NoticeService();
			List<NoticeBean> result = noticeService.select(bean,page);
			int totalPages = noticeService.getTotalPages();
			int totalData = noticeService.getTotalDataNum();
			request.setAttribute("currentPage",page);
			request.setAttribute("select", result);
			request.setAttribute("pages", totalPages);
			request.setAttribute("datas", totalData);
			request.getRequestDispatcher("/admin/noticeManager.jsp").forward(request, response);
		}
		else if(action.equals("music"))
		{
			MusicBean bean = new MusicBean();
			MusicService musicService = new MusicService();
			//get list of results according to which page 
			List<MusicBean> result = musicService.select(bean,page);
			//get Total pages
			int totalPages = musicService.getTotalPages();
			//getTotalData 
			int totalData = musicService.getTotalDataNum();
			
			//java.util.Date newDate = musicService.getRecentDate();
			
			request.setAttribute("currentPage",page);
			request.setAttribute("select", result);
			request.setAttribute("pages", totalPages);
			request.setAttribute("datas", totalData);
			request.getRequestDispatcher("/admin/musicManager.jsp?page="+page).forward(request, response);
		}	
	}
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException 
	{
		this.doGet(request, response);
	}
}
