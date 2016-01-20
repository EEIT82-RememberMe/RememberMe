package member.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.MemberBean;
import member.model.MemberDAO;
import member.model.MemberService;
import model.dao.MemberDAOHibernate;

@WebServlet("/member.controller/ProcessRegister")
public class ProcessRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProcessRegister() {
        super();
    }

	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException 
	{
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException 
	{
		// 定義存放錯誤訊息的 Collection物件
		Map<String, String> errors = new HashMap<String, String>();
		//Collection<String> errorMessage = new ArrayList<String>();
		request.setAttribute("errors",errors );
		// 設定輸入資料的編碼
		request.setCharacterEncoding("UTF-8");
		
		String memberId = request.getParameter("memberId");
		// 檢查使用者所輸入的資料
		if(memberId == null || memberId.trim().length()==0)
		{
			errors.put("memberId","此欄位必須輸入!");
		}
		// 讀取使用者所輸入，由瀏覽器送來的 pswd 欄位內的資料，注意大小寫
		String memberPassword = request.getParameter("memberPassword");
		// 檢查使用者所輸入的資料
		if(memberPassword == null || memberPassword.trim().length()==0)
		{
			errors.put("memberPassword","此欄位必須輸入!");
		}
		//讀取使用者所輸入，由瀏覽器送來的 email欄位內的資料
		String email = request.getParameter("email");
		// 檢查使用者所輸入的資料
		if(email == null || email.trim().length()==0)
		{
			errors.put("email","email欄位必須輸入!");
		}	
		if(!errors.isEmpty())
		{
			RequestDispatcher rd = request.getRequestDispatcher("/pages/register.jsp");
			rd.forward(request, response);
			return;
		}
		
		//MemberBean mb = new MemberBean(username,password,email);//傳進來
		MemberBean mb = new MemberBean(memberId,memberPassword,email);
		try 
		{
			/***********************************/
			MemberService memberService = new MemberService();
			//MemberDAO mDao = new MemberDAOHibernate();
			memberService.insertMember(mb);
			/***********************************/
			
			request.setAttribute("memberBean", mb);
			System.out.println("yes");
			RequestDispatcher rd = request.getRequestDispatcher("/pages/login.jsp");
			rd.forward(request, response);
			return;
		} 
		catch (SQLException e) 
		{
			if (e.getMessage().indexOf("重複的索引鍵") != -1 || 
					e.getMessage().indexOf("Duplicate entry") != -1) 
			{
				errors.put("memberId","帳號重複，請重新輸入帳號");
			} 
			else 
			{
				errors.put("memberId","資料庫存取錯誤:" + e.getMessage());
			}
			//RequestDispatcher rd = request.getRequestDispatcher("/pages/InsertMemberError.jsp");
			//rd.forward(request, response);
			System.out.println("no");
			return;
		}
	}
}
