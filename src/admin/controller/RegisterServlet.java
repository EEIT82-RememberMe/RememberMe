package admin.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.sun.org.apache.xalan.internal.xsltc.compiler.Template;
import com.sun.swing.internal.plaf.basic.resources.basic;

import admin.model.AdminBean;
import admin.model.AdminService;
import admin.model.RegisterService;
import javafx.scene.effect.ImageInput;

@MultipartConfig(location = "", fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 500, maxRequestSize = 1024
		* 1024 * 500 * 5)
@WebServlet("/admin/register.controller")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Map<String, String> errorMsg = new HashMap<String, String>();
		Map<String, String> msgOk = new HashMap<String, String>();
		HttpSession session = request.getSession();
		request.setAttribute("errorMsg", errorMsg);
		session.setAttribute("msgOk", msgOk);

		// 接收使用者輸入的資料--------------------------------------------
		String id = request.getParameter("adminId");
		String pass = request.getParameter("adminPassword");
		String cpass = request.getParameter("confirmPass");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String tempState = request.getParameter("state");
		Part photo = request.getPart("photo");// 接收上傳的檔案,form表單需設定multipart/form-data!!如果是多筆可以用getParts!!
		InputStream is = photo.getInputStream();
		byte[] buff = new byte[(int) photo.getSize()];
		is.read(buff);
		is.close();
		// System.out.println(buff);

		// 驗證資料------------------------------------------------------------
		// System.out.println(id + pass + cpass + name + email + photo +
		// tempState);

		Map<String, String> errors = new HashMap<String, String>();
		request.setAttribute("errors", errors);
		if (id == null || id.length() == 0) {
			errors.put("adminId", "請輸入帳號");
		}
		if (pass == null || pass.length() == 0) {
			errors.put("adminPassword", "請輸入密碼");
		}
		if (cpass == null || cpass.length() == 0) {
			errors.put("confirmPassword", "請再次輸入密碼");
		}
		if (!pass.equals(cpass)) {
			errors.put("confirmPass1", "密碼驗證錯誤");
		}
		if (tempState == null || tempState.length() == 0) {
			errors.put("state", "請選擇權限");
		}
		if (errors != null && !errors.isEmpty()) {
			request.getRequestDispatcher("/admin/register.jsp").forward(request, response);
			return;
		}
		// 轉換資料--------------
		int state = 0;
		if (tempState != null && tempState.length() != 0) {
			// int intstate= Integer.parseInt(tempState);
			state = new Integer(tempState);
			if (state == -1000) {
				errors.put("id", "Id必須是整數");
			}
		}
		// 呼叫Model把使用者輸入的值塞進資料庫欄位------------------------
		AdminBean bean = new AdminBean();
		bean.setAdminId(id);
		bean.setAdminPassword(pass);
		bean.setName(name);
		bean.setEmail(email);
		bean.setState(state);
		bean.setPhoto(buff);
		// System.out.println("----------------------");
		// System.out.println(bean.getAdminId());
		// System.out.println(bean.getAdminPassword());
		// System.out.println("buf======"+buff);
		// System.out.println("photo~~~~~~~~"+photo);
		// System.out.println("----------------------");
		// ------------

		// ------------
		RegisterService registerService = new RegisterService();
		registerService.saveAdmin(bean);
		// 根據Model執行結果 呼叫View
		//
		int stateInt = (int) session.getAttribute("state");
		String path = request.getContextPath();
		if (stateInt < 1) {
			request.getRequestDispatcher("/admin/stateTooLow.jsp").forward(request, response);
		}
		// request.setAttribute("newaccount","歡迎使用新帳號登入");
		// response.sendRedirect(path + "/admin/Login.jsp");
//		request.setAttribute("id", id);
//		request.setAttribute("pass", pass);
//		request.getRequestDispatcher("/admin/admin.jsp").forward(request, response);
		session.setAttribute("id", id);
		session.setAttribute("pass", pass);
		response.sendRedirect("../admin/admin.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
