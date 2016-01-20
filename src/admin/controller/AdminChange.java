package admin.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Base64;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import admin.model.AdminBean;
import admin.model.AdminService;
@MultipartConfig(location = "", fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 500, maxRequestSize = 1024
* 1024 * 500 * 5)
@WebServlet("/AdminChange")
public class AdminChange extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminChange() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// 接收資料----------------------------------

		String adminId = request.getParameter("adminId");
		String oldPass = request.getParameter("oldPass");
		String newPass = request.getParameter("newPass");
		String confirmPass = request.getParameter("confirmPass");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
//		---照片--------------------
		Part tempPhoto = request.getPart("photo");
		byte[] byPhoto=null;
		System.out.println("ddddddddddddddd:"+tempPhoto.getSize());
		if(tempPhoto.getSize()==0){
			tempPhoto=null;
		}else{
			InputStream is = tempPhoto.getInputStream();
			byPhoto= new byte[(int) tempPhoto.getSize()];
			is.read(byPhoto);
			is.close();
		}
//		---時間------------------
//		SimpleDateFormat sdf =new SimpleDateFormat();//時間格式
		Date date =new Date();//現在時間
//		String strdate =sdf.format(date);//把時間轉為sdf類型的字串
//		try {
////			Date jDate =sdf.parse(strdate);
////			java.sql.Date  sqlDate = new java.sql.Date(jDate.getTime());
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
		// 驗證資料----------------------------------
		AdminBean bean = new AdminBean();
//		bean.setAdminId(adminId);
		AdminService service = new AdminService();
		Map<String, String> errors = new HashMap<String,String>();
		
		AdminBean adbean= service.login(adminId, oldPass);
		

		request.setAttribute("errors", errors);
		if (oldPass == null || oldPass.length() == 0) {
			errors.put("oldPass", "請輸舊入密碼");
		}
		if(newPass==null||newPass.length()==0){
			errors.put("newPass", "請輸入新密碼");
		}
		if(confirmPass==null||confirmPass.length()==0){
			errors.put("confirmPass", "請確認新密碼");
		}
//		if(!oldPass.equals(adbean.getAdminPassword())){
////			System.out.println("!!!!!!!!!"+bean.getAdminPassword());
////			System.out.println("&&&&&&&&"+oldPass);
//			errors.put("oldPass2","舊密碼錯誤");
//		}
		if(!newPass.equals(confirmPass)){
			errors.put("passEqual","密碼驗證錯誤");
		}
		
		if(errors!=null&&!errors.isEmpty()){
			request.getRequestDispatcher("/admin/modifyAdmin.jsp").forward(request, response);
		}else {
			
			bean.setAdminPassword(newPass);
			AdminBean result = service.changePassword(adminId, oldPass, newPass);
//		-------------------------
			bean.setAdminId(adbean.getAdminId());
			bean.setUpdateDate(date);
			System.out.println("tempPhoto============="+tempPhoto);
			bean.setPhoto(byPhoto);
			bean.setName(name);
			bean.setEmail(email);
			
			AdminBean newbean =service.updateAll(bean);
			HttpSession session = request.getSession();
			AdminBean bean2 = service.login(adminId, newPass);
			session.setAttribute("bean2", bean2);
			AdminBean b2 = (AdminBean) session.getAttribute("bean2");
			byte[] newphoto= b2.getPhoto();
			String img = Base64.getEncoder().encodeToString(newphoto);
			session.setAttribute("img", img);
			session.setAttribute("admin", bean2);
//			System.out.println("controller bean======="+bean);
//		-------------------------
		String path = request.getContextPath();
		response.sendRedirect(path+"/admin/updateOk.jsp");	
//			request.getRequestDispatcher("/admin/updateOk.jsp").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
