package products.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import products.model.Cart;
import products.model.LineItem;
import products.model.ProductBean;
import products.model.ProductService;


@WebServlet("/products.controller/ProcessCart")
public class ProcessCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public ProcessCart()
    {
        super();
    }

	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException 
	{
		
	}

	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException
	{
		request.setCharacterEncoding("UTF8");
		String action = request.getParameter("action");
		
		if(action.equals("加入購物車"))
		{
			HttpSession session = request.getSession();
			Cart cart = (Cart) session.getAttribute("cart");
			 if (cart == null)
			 {
		       cart = new Cart();
		     }
			 String productId = request.getParameter("productId");
			 String quantity = request.getParameter("quantity");
			 int productIdInt = Integer.valueOf(productId);
			 int quantityInt = Integer.valueOf(quantity);
			 //System.out.println("picked"+quantityInt);
			 
			 ProductService service = new ProductService();
			 ProductBean product = service.singleProduct(productIdInt);
			 if (product != null) 
			 {
		       LineItem lineItem = new LineItem();
		       lineItem.setProduct(product);
		       lineItem.setQuantity(quantityInt);
		       lineItem.setTotal(product,quantityInt);
		       cart.addItem(lineItem);
		     }
			 List<LineItem> items = cart.getItems();
			 session.setAttribute("cart", cart);
			 session.setAttribute("items", items);
			 System.out.println(cart);
			 //request.getRequestDispatcher("/pages/cart.jsp").forward(request, response);
		}
		else if(action.equals("X 移除"))
		{
			System.out.println("this is do post");
			HttpSession session = request.getSession();
			Cart cart = (Cart)session.getAttribute("cart");
			String productId = request.getParameter("productId");
			int productIdInt = Integer.valueOf(productId);
			ProductService service = new ProductService();
			ProductBean product = service.singleProduct(productIdInt);
			if(product!=null && cart!=null)
			{
				LineItem lineItem = new LineItem();
				lineItem.setProduct(product);
				cart.removeItem(lineItem);
			}
		}
		else if(action.equals("更新"))
		{
			
			HttpSession session = request.getSession();
			Cart cart = (Cart) session.getAttribute("cart");
			String quantityString = request.getParameter("quantity");
			String productIdString = request.getParameter("productId");
			
			int quantity = Integer.parseInt(quantityString);
			System.out.println("quantity:"+quantity);
			int productIdInt = Integer.valueOf(productIdString);
			System.out.println("productId:"+productIdInt);
			
			ProductService service = new ProductService();
			ProductBean product = service.singleProduct(productIdInt);
//			LineItem item = cart.getItems().
//			cart.removeItem(item);

			if(product!=null && cart!=null)
			{
				LineItem lineItem = new LineItem();
				lineItem.setProduct(product);
				lineItem.setQuantity(quantity);
				//refresh total
				lineItem.setTotal(product,quantity);
//				System.out.println(lineItem.getTotal());
				cart.addItem(lineItem);
			}
			List<LineItem> items = cart.getItems();

			session.setAttribute("cart", cart);
			session.setAttribute("items", items);
		}
		String path = request.getContextPath();
		response.sendRedirect(path+"/pages/cart.jsp");
	}
}
