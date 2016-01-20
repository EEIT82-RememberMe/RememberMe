package orders.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/orders.controller/ProcessOrderForm")
public class ProcessOrderForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProcessOrderForm() {
        super();
    }

	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException 
	{
		//接收資料
		request.setCharacterEncoding("UTF8");
		String receiver = request.getParameter("receiver");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String payMethod = request.getParameter("payMethod");
		String transportPrice = request.getParameter("transportPrice");
		
		Map<String, String> errors = new HashMap<String, String>();
		request.setAttribute("errors",errors );
		
		if(receiver.trim().length() ==0 || receiver==null){
			errors.put("NOreceiver", "必須輸入收件者");
		}
		if(email.trim().length() ==0 || email==null){
			errors.put("NOemail", "必須輸入E-Mail");
		}
		if(phone.trim().length() ==0 || phone==null){
			errors.put("NOphone", "必須輸入電話");
		}
		if(address.trim().length() ==0 || address==null){
			errors.put("NOaddress", "必須輸入地址");
		}
		if(transportPrice.trim().length() ==0 || transportPrice==null){
			errors.put("NOpayMethod", "必須輸入付款方式");
		}
		if(!errors.isEmpty())
		{
			RequestDispatcher rd = request.getRequestDispatcher("/pages/orderForm.jsp");
			rd.forward(request, response);
			return;
		}
	    
		HttpSession session = request.getSession();
		
		session.setAttribute("email", email);
		session.setAttribute("phone", phone);
		session.setAttribute("receiver", receiver);
		session.setAttribute("address", address);
		session.setAttribute("payMethod", payMethod);
		session.setAttribute("transportPrice", transportPrice);
		
		String path = request.getContextPath();
		response.sendRedirect(path+"/pages/checkOrderDetails.jsp");
	}

}
