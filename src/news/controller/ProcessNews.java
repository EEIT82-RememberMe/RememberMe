package news.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import model.dao.MusicDAOHibernate;
import news.model.MusicBean;
import news.model.MusicDAO;
import news.model.MusicService;
import news.model.NoticeService;

@WebServlet("/news.controller/ProcessNews")
public class ProcessNews extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ProcessNews() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//this.doPost(request, response);
		System.out.println("isin");
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 編碼設定
		request.setCharacterEncoding("UTF8");
		response.setCharacterEncoding("UTF8");
		// 接收資料
		String action = request.getParameter("action"); //action is the page user wants to see
		System.out.println(action);
		String pg = request.getParameter("page");// pg is the value of page
		System.out.println(pg);
		// 驗證資料
		// 轉換資料
		int pageInt = Integer.valueOf(pg);// convert pg to int
		// 根據action值去呼叫Model
		String result = null;
		if(action.equals("notice"))
		{
			NoticeService noticeService = new NoticeService();
			result = noticeService.showByPage(pageInt);
		}
		else if(action.equals("music"))
		{
			System.out.println("isin");
			MusicService musicService = new MusicService();
			result = musicService.showByPage(pageInt);
		}
		
		System.out.println(result + "\n");
		System.out.println("");

		JsonParser jsonParser = new JsonParser();
		JsonElement element = jsonParser.parse(result);

		System.out.println("這是json物件" + element);

		response.setContentType("application/json");
		// Get the printwriter object from response to write the required json
		// object to the output stream
		PrintWriter out = response.getWriter();
		// Assuming your json object is **jsonObject**, perform the following,
		// it will return your json object
		out.print(element);
		out.flush();
		out.close();

		// 根據Model執行結果，呼叫View
	}

}
