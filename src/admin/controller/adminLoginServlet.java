package admin.controller;

import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admin.model.AdminBean;
import admin.model.AdminService;

@WebServlet("/admin/Login.controller")
public class adminLoginServlet extends HttpServlet {
	public AdminService adminService =null;
//	public AdminService adminService =new AdminService();錯誤位置!!!注意

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		adminService = new AdminService();//這個一定要放在doget裡面,不然第二次登入時會出現session is close 錯誤
		// 接收資料----------------------------------------------
		String adminId = request.getParameter("adminId");
		String adminPassword = request.getParameter("adminPassword");
		// 驗證資料----------------------------------------
		Map<String, String> errors = new HashMap<String, String>();
		request.setAttribute("errors", errors);

		if (adminId == null || adminId.length() == 0) {
			errors.put("adminId", "請輸入帳號");
		}
		if (adminPassword == null || adminPassword.length() == 0) {
			errors.put("adminPassword", "請輸入密碼");
		}
		if (errors != null && !errors.isEmpty()) {
			request.getRequestDispatcher("/admin/Login.jsp").forward(request, response);
			return;
		}
//-----------呼叫Model---------------------------------------------
		
//		System.out.println("$$$$$$");
		AdminBean bean = adminService.login(adminId, adminPassword);
//		System.out.println(bean);
		System.out.println("---------"+bean);
		// 根據Model執行結果 呼叫View --------------
		if (bean == null) {
			errors.put("adminPassword", "登入失敗,請再輸入一次");
			request.getRequestDispatcher("/admin/Login.jsp").forward(request, response);
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("admin", bean);
			session.setAttribute("state",bean.getState());
			System.out.println("STATE值="+bean.getState());
//			---顯示圖片-----------
			if(bean.getPhoto()!=null){
			byte[] photo = bean.getPhoto();
//			 ServletOutputStream os = response.getOutputStream();
//			 os.write(photo);
			String img = Base64.getEncoder().encodeToString(photo);
//			System.out.println("img____________"+img);
			session.setAttribute("img", img);
			}
//			---------------
			String path = request.getContextPath();
			response.sendRedirect(path+"/admin/admin.jsp");
//			System.out.println("sendreedirect 111");
//			request.getRequestDispatcher("/admin/admin.jsp").forward(request, response);
		}

	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
