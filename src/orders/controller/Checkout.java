package orders.controller;


import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import orders.model.OrderDetailBean;
import orders.model.OrderService;
import orders.model.OrdersBean;
import products.model.Cart;
import products.model.LineItem;

@WebServlet("/orders.controller/Checkout")
public class Checkout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Checkout() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
												throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
												throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		request.setCharacterEncoding("UTF8");
		
		OrderService orderService = new OrderService();
		
		String action = request.getParameter("action");
		int orderId=(int) (Math.random()*10000000);
		String memberId = request.getParameter("memberId");
		String receiver = request.getParameter("receiver");
//		int totalQuantity = request.getParameter("");
		int totalQuantity = 0;
//		String totalPrice = request.getParameter("");
		int totalPrice = 0;
		Timestamp orderDate = new Timestamp(new Date().getTime());
//		String ordersStatus = request.getParameter("");
		String ordersStatus = "處理中";
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String quantity = request.getParameter("quantity");
		String payMethod = request.getParameter("payMethod");
		String transportPrice = request.getParameter("transportPrice");
		Timestamp payDate = new Timestamp(new Date().getTime());
//		String transportPrice = request.getParameter("");
		int transportPriceInt = Integer.valueOf(transportPrice);
//		String shippedDate = request.getParameter("");
		Timestamp shippedDate = null;
//		String remark = request.getParameter("");
		String remark = null;
		
		OrdersBean order = new OrdersBean(orderId, memberId, phone, email, address, receiver,
									totalQuantity, totalPrice, orderDate, payMethod, payDate, 
										transportPriceInt, shippedDate, remark, ordersStatus);
		
		orderService.insert(order);
		session.setAttribute("orderId", orderId);
		session.setAttribute("receiveName", receiver);
		List<OrdersBean> od = orderService.select(order);
		session.setAttribute("order", od);
		System.out.println(od);

		Cart cart = (Cart) session.getAttribute("cart");
		List<OrderDetailBean> beans = new ArrayList<OrderDetailBean>();
		for (LineItem item : cart.getItems()) {
			OrderDetailBean orderDetail = new OrderDetailBean();
			orderDetail.setOrderId(orderId);
			orderDetail.setMemberId(memberId);
			orderDetail.setProductNameTw(item.getProduct().getProductNameTw());
			orderDetail.setProductNameUs(item.getProduct().getProductNameUs());
			orderDetail.setQuantity(item.getQuantity());
			orderDetail.setPrice(item.getProduct().getProductPrice());
			beans.add(orderDetail);
		}
		orderService.insert(orderId, beans);
		
		String path = request.getContextPath();
		response.sendRedirect(path + "/pages/orderDetails.jsp");
		
	}

	
}
