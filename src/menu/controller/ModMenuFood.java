package menu.controller;

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

import menu.model.MenuFoodBean;
import menu.model.MenuService;
import news.model.MusicBean;

@WebServlet("/menu.controller/ModMenuFood")
public class ModMenuFood extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ModMenuFood() {
        super();
    }

	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException 
	{
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		//System.out.println(action);
		//this.doPost(request, response);
		if(action.equals("delete"))
		{		
			String num = request.getParameter("foodId");
			int number = Integer.parseInt(num);
			
			MenuFoodBean mfb = new MenuFoodBean();
			MenuService menuService = new MenuService();
			mfb.setFoodId(number);
			boolean result = menuService.delete(mfb);
			RequestDispatcher rd = request.getRequestDispatcher("/admin/menuList.jsp");
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
		
		String foodNameTw = request.getParameter("foodNameTw");
		String foodNameUs = request.getParameter("foodNameUs");
		String textDecoration = request.getParameter("textDecoration");
		String info = request.getParameter("info");
		String temperature = request.getParameter("temperature");
		String price = request.getParameter("price");
		
		String action = request.getParameter("action");
		
		String dateCreate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date().getTime());
		Timestamp dateUpdate = Timestamp.valueOf(dateCreate);
			
		MenuFoodBean mfb = new MenuFoodBean(foodNameTw,foodNameUs,textDecoration
											,info,temperature,price,dateUpdate);
		
		HttpSession session = request.getSession();
		MenuService menuService = new MenuService();
		
		String catNum = "0";
		if("更新".equals(action))
		{
			//for returning original page purposes
			catNum = request.getParameter("categoryNum");
			//System.out.println("!!!!!!!!!!!!!!!"+catNum+"!!!!!!!!!!!!");
			//catching food id
			String num = request.getParameter("foodId");
			int foodIdInt = Integer.parseInt(num);
			mfb.setFoodId(foodIdInt);;
			MenuFoodBean result = menuService.update(mfb);
			request.setAttribute("select", result);
			//this is a must study
			String path = request.getContextPath();
			response.sendRedirect(path + "/admin/menuList.jsp?category="+catNum);
		}
		else if("新增".equals(action))
		{
			String cat = request.getParameter("categories");
			//System.out.println("catcatcatcatcat"+cat);
			int foo = Integer.parseInt(cat);
			mfb.setCategoryNum(foo);
			//System.out.println("pppppppppppp"+mfb);
			MenuFoodBean result = menuService.insert(mfb);
			session.setAttribute("select", result);
//			RequestDispatcher rd = request.getRequestDispatcher("/admin/menuList.jsp?category="+catNum);
//			rd.forward(request, response);
			response.sendRedirect("../admin/menuList.jsp?category="+catNum);
			return;
		}
	}
}
