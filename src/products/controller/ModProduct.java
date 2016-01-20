package products.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;

import products.model.ProductBean;
import products.model.ProductService;

@WebServlet("/products.controller/ModProduct")
public class ModProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static String UPLOAD_DIRECTORY = "/Users/ougoukun/Documents/程式設計/RememberMe/RememberMe82/WebContent/imageProducts";
	
    public ModProduct() 
    {
        super();
    }
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException 
	{
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		String page = request.getParameter("page");
		//System.out.println(action);
		//this.doPost(request, response);
		if(action.equals("delete"))
		{		
			String num = request.getParameter("productId");
			int number = Integer.parseInt(num);
			
			ProductBean mb = new ProductBean();
			ProductService productService = new ProductService();
			mb.setProductId(number);
			boolean result = productService.delete(mb);
			RequestDispatcher rd = request.getRequestDispatcher("/products.controller/ProductManager?page=1");
			rd.forward(request, response);
			return;
		}
	}

	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException 
	{
		String encoding = "UTF8";
		int maxFileSize = 50000*1024;
		MultipartRequest mreq = new MultipartRequest(request,UPLOAD_DIRECTORY,maxFileSize,encoding);
		
		
		String productNameTw = mreq.getParameter("productNameTw");
		String productNameUs = mreq.getParameter("productNameUs");	
		String productDescription = mreq.getParameter("productDescription");
		String remarks = mreq.getParameter("remarks");		
		String productImage = mreq.getFilesystemName("productImage");
		String productPrice = mreq.getParameter("productPrice");
		int productPriceInt = Integer.valueOf(productPrice);
		String stock = mreq.getParameter("stock");
		int stockInt = Integer.valueOf(stock);
		
		String action = mreq.getParameter("action");
		
		String dateCreate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date().getTime());
		Timestamp dateUpdate = Timestamp.valueOf(dateCreate);
		
			ProductBean pb = new ProductBean(productNameTw,productNameUs,productDescription
					,remarks,productImage,productPriceInt,stockInt,dateUpdate);
			
			HttpSession session = request.getSession();
			ProductService productService = new ProductService();
			if("新增".equals(action))
			{
				ProductBean result = productService.insert(pb);
				session.setAttribute("select", result);
//				RequestDispatcher rd = request.getRequestDispatcher("/products.controller/ProductManager?page=1");
//				rd.forward(request, response);
				response.sendRedirect("../products.controller/ProductManager?page=1");
				return;
			}
			else if("更新".equals(action))
			{
				String page = mreq.getParameter("page");
				String productId = mreq.getParameter("productId");
				int productIdInt = Integer.valueOf(productId);
				pb.setProductId(productIdInt);
				ProductBean result = productService.update(pb);
				session.setAttribute("select", result);
//				RequestDispatcher rd = request.getRequestDispatcher("/products.controller/ProductManager?page="+page);
//				rd.forward(request, response);
				response.sendRedirect("../products.controller/ProductManager?page="+page);
				return;
			}	
	}

}
