package admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admin.model.AdminBean;
import admin.model.AdminService;

@WebServlet("/admin/AdminManager.controller")
public class AdminManager extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminManager() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		AdminBean bean = new AdminBean();
		AdminService adminService = new AdminService();
		String action = request.getParameter("action");// 得到按鈕的值
		String id = request.getParameter("Id");// 得到ID
		// System.out.println("ididid=" + id);
		bean.setAdminId(id);// 將得到的id塞進bean

		// --------------
		HttpSession session = request.getSession();
		int uState = (int) session.getAttribute("state");
		// System.out.println("uState===========" + uState);
		// --------------

		// --------------------呼叫delete方法-----------------------------------------
		// System.out.println(id + "id..........");
		// System.out.println(action + "action=??????");

		if ("Delete".equals(action) && uState == 1) {
			boolean result = adminService.delete(bean);
			if (!result) {
				request.setAttribute("delete", 1);
			} else {
				request.setAttribute("delete", 0);
			}
			request.getRequestDispatcher("/admin/AdminListServlet.controller").forward(request, response);
		} else if ("Delete".equals(action) && uState > 1) {
			System.out.println("權限不足～～～～");
			request.getRequestDispatcher("/admin/AdminListServlet.controller").forward(request, response);
		}
		// ---------------呼叫update方法------------------------------------------------------------------------------------
		else if ("修改".equals(action) && uState == 1) {
			// --接收資料---------------
			String tempState = request.getParameter("state");
			System.out.println(tempState + "=tempState<<<<<<<<<<<<<<<<<");
			// String[] states = request.getParameterValues("state");
			// System.out.println(states+"=States<<<<<<<<<<<<<<<");

			// --轉換資料---------------
			// int intstate= Integer.parseInt(tempState);
			// int state =0;
			// state= new Integer(tempState);
			int state = new Integer(tempState);
			//塞值-------
			bean.setState(state);
			System.out.println("bean=???????????" + bean);
			AdminBean result = adminService.update(bean);
			if (result != null) {
				request.setAttribute("update", 1);
			} else {
				request.setAttribute("update", 0);
			}
			request.getRequestDispatcher("/admin/AdminListServlet.controller").forward(request, response);
		} else if ("UpdateNum".equals(action) && uState > 1) {
			System.out.println("權限不足");
			request.getRequestDispatcher("/admin/AdminListServlet.controller").forward(request, response);
		}
	}

	// -------------------------------------------------------

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
