package orders.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.MemberBean;
import orders.model.OrderService;
import orders.model.OrdersBean;

@WebServlet("/orders.controller/OrdersMember")
public class OrdersMember extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public OrdersMember() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF8");
		response.setContentType("UTF8");
				
		
		HttpSession session = request.getSession();
		MemberBean member = (MemberBean) session.getAttribute("receiveInformation");
		System.out.println(member);
		String memberId = member.getMemberId();
		System.out.println(memberId);
		OrderService orderService = new OrderService();
		List<OrdersBean> orderList = orderService.selectMemberOrders(memberId);
		session.setAttribute("orderList", orderList);
		
		session.removeAttribute("cart");
		
		request.getRequestDispatcher(
				"/pages/memberProfile.jsp").forward(request, response);
	}

}
