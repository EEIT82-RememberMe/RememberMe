package admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;

import admin.model.AdminBean;
import admin.model.AdminService;

/**
 * Servlet implementation class AdminListServlet
 */
@WebServlet("/admin/AdminListServlet.controller")
public class AdminListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AdminListServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AdminBean bean = new AdminBean();
		AdminService adminService = new AdminService();		
		List<AdminBean> result = adminService.select(bean);
		request.setAttribute("select", result);
//		System.out.println("result=!!!!!!!!!!!!!!!!!"+result);
		HttpSession session = request.getSession();
		
		int stateInt = (int) session.getAttribute("state");
		if(stateInt==3){
		request.getRequestDispatcher("/admin/stateTooLow.jsp").forward(request, response);
		}
		else if(stateInt<3){
		request.getRequestDispatcher("/admin/adminList.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
