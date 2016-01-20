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

import com.oreilly.servlet.MultipartRequest;

import model.dao.MusicDAOHibernate;
import news.model.MusicBean;
import news.model.MusicService;

@WebServlet("/news.controller/ModMusic")
public class ModMusic extends HttpServlet {
	
	private final String UPLOAD_DIRECTORY = "C:/Java/workspaceTest/RememberMe/WebContent/images";
	
	private static final long serialVersionUID = 1L;
    public ModMusic() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		String page = request.getParameter("page");
		if(action.equals("delete"))
		{		
			String num = request.getParameter("number");
			int number = Integer.parseInt(num);
			
			MusicBean mb = new MusicBean();
			MusicService musicService = new MusicService();
			mb.setNumber(number);
			boolean result = musicService.delete(mb);
			RequestDispatcher rd = request.getRequestDispatcher("/news.controller/NewsQueryList?action=music&page="+page);
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
		String encoding = "UTF8";
		int maxFileSize = 50000*1024;
		MultipartRequest mreq = new MultipartRequest(request,UPLOAD_DIRECTORY,maxFileSize,encoding);
		
		String title = mreq.getParameter("title");
		String description = mreq.getParameter("description");
		String performer = mreq.getParameter("performer");
		String musicContent = mreq.getParameter("musicContent");
		String photo = mreq.getFilesystemName("photo");
		String blogLink = mreq.getParameter("blogLink");
		
		String action = mreq.getParameter("action");	
		
		String dateCreate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date().getTime());
		Timestamp dateUpdate = Timestamp.valueOf(dateCreate);
			
		MusicBean mb = new MusicBean();
		mb.setTitle(title);
		mb.setDescription(description);
		if(photo!=null)
		{
			mb.setPhoto(photo);
		}
		mb.setPerformer(performer);
		mb.setMusicContent(musicContent);
		mb.setBlogLink(blogLink);
		mb.setUpdateDate(dateUpdate);
		
		HttpSession session = request.getSession();
		MusicService musicService = new MusicService();
	
		if("新增".equals(action))
		{
			MusicBean result = musicService.insert(mb);
			session.setAttribute("select", result);
//			RequestDispatcher rd = request.getRequestDispatcher("/news.controller/NewsQueryList?action=music&page=1");
//			rd.forward(request, response);
			response.sendRedirect("../news.controller/NewsQueryList?action=music&page=1");
			return;
		}
		else if("更新".equals(action))
		{
			String page = mreq.getParameter("page");
			String num = mreq.getParameter("number");
			int number = Integer.parseInt(num);
			mb.setNumber(number);
			MusicBean result = musicService.update(mb);
			session.setAttribute("select", result);
			session.setAttribute("page", page);
//			RequestDispatcher rd = request.getRequestDispatcher("/news.controller/NewsQueryList?action=music&page="+page);
//			rd.forward(request, response);
			response.sendRedirect("../news.controller/NewsQueryList?action=music&page="+page);
			return;
		}
	}
}
