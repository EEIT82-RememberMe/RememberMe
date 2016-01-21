package products.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import products.model.ProductBean;
import products.model.ProductService;

@WebServlet("/products.controller/ProductManager")
public class ProductManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProductManager() 
    {
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
		String pageStr = request.getParameter("page");
		int page = Integer.valueOf(pageStr);
		ProductBean bean = new ProductBean();
		ProductService productService = new ProductService();
		List<ProductBean> result = productService.select(bean,page);
		int totalPages = productService.getTotalPages();
		int totalData = productService.getTotalDataNum();
		request.setAttribute("currentPage",page);
		request.setAttribute("select", result);
		request.setAttribute("pages", totalPages);
		request.setAttribute("datas", totalData);
		request.getRequestDispatcher(
				"/admin/productList.jsp").forward(request, response);
	}

}
