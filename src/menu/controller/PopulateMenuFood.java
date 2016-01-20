package menu.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import menu.model.MenuFoodBean;
import menu.model.MenuService;

@WebServlet("/menu.controller/PopulateMenuFood")
public class PopulateMenuFood extends HttpServlet {
	private static final long serialVersionUID = 1L;
        
    public PopulateMenuFood() {
        super();
    }

	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException 
	{
		String num = request.getParameter("categoryNumber");
		if(num == null)
		{
			// 編碼設定
			request.setCharacterEncoding("UTF8");
			response.setCharacterEncoding("UTF8");
			// 做事情(把目錄的類別以Json格式傳回給 menuList.jsp , 讓它可以populate select選單)
			MenuService service = new MenuService();
			String result = service.returnCategories();
			
			JsonParser jsonParser = new JsonParser();
			JsonElement element = jsonParser.parse(result);

			//System.out.println("這是json物件" + element);

			response.setContentType("application/json");
			PrintWriter out = response.getWriter();			
			out.print(element);
			out.flush();
			out.close();
		}
		else
		{
			this.doPost(request, response);
		}		
	}
	
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException
	{
		
		//System.out.println("bbb");
		// 編碼設定
		request.setCharacterEncoding("UTF8");
		response.setCharacterEncoding("UTF8");
		
		String num =request.getParameter("categoryNumber");
		int catNum = 0;
		try 
		{
			catNum = Integer.parseInt(num);
		} 
		catch (NumberFormatException e) 
		{
			return;
		}
		MenuService service = new MenuService();
		String result = service.select(catNum);
		
		JsonParser jsonParser = new JsonParser();
		JsonElement element = jsonParser.parse(result);

		//System.out.println("這是json物件" + element);

		response.setContentType("application/json");
		PrintWriter out = response.getWriter();			
		out.print(element);
		out.flush();
		out.close();
		
		
		
	}

}
