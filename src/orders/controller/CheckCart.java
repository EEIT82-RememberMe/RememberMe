package orders.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import products.model.Cart;

@WebServlet("/orders.controller/CheckCart")
public class CheckCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CheckCart() {
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
		
		Cart cart = (Cart) session.getAttribute("cart");
		try {
			if(cart.getItems().size() == 0 || cart.getItems().isEmpty()){
				String path = request.getContextPath();
				response.sendRedirect(path+"/pages/cart.jsp");
			}else{
				String path = request.getContextPath();
				response.sendRedirect(path+"/pages/orderForm.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
			String path = request.getContextPath();
			response.sendRedirect(path+"/pages/cart.jsp");
		}
		
		
	}

}
