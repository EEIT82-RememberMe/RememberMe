package products.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import products.model.ProductBean;
import products.model.ProductService;

@WebServlet("/products.controller/ProcessSingleProduct")
public class ProcessSingleProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProcessSingleProduct() 
    {
        super();
    }
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException 
	{
		 //接收資料
		String productId = request.getParameter("productId");
		int productIdInt = Integer.valueOf(productId);
		ProductService service = new ProductService();
		ProductBean result = service.singleProduct(productIdInt);
		//System.out.println(result.getProductNameTw());
		request.setAttribute("product", result);
		request.getRequestDispatcher("/pages/productDetails.jsp").forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
