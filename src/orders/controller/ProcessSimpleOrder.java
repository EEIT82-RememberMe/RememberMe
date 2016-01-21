package orders.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import orders.model.OrderService;
import orders.model.OrdersBean;

@WebServlet("/orders.controller/ProcessSimpleOrder")
public class ProcessSimpleOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProcessSimpleOrder() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
												throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
												throws ServletException, IOException {
		request.setCharacterEncoding("UTF8");
		HttpSession session = request.getSession();
		
		OrderService orderService = new OrderService();
		
		String orderId = request.getParameter("orderId");
		int orderIdInt = Integer.valueOf(orderId);
		OrdersBean o = orderService.selectSimple(orderIdInt);
		o.setOrdersStatus("已出貨");
		System.out.println("insertOK");
		
		OrdersBean order = new OrdersBean();
		List<OrdersBean> ord = orderService.select(order);
		session.setAttribute("orderIndex", ord);

		request.getRequestDispatcher(
				"/admin/orderList.jsp").forward(request, response);
		
	}

}
