package products.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import products.model.ProductService;


@WebServlet("/products.controller/PopulateProducts")
public class PopulateProducts extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PopulateProducts() 
    {
        super();
    }

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException 
	{
		// 編碼設定
		request.setCharacterEncoding("UTF8");
		response.setCharacterEncoding("UTF8");
		ProductService service = new ProductService();
		String result = service.showProducts();
		JsonParser jsonParser = new JsonParser();
		
		JsonElement element = jsonParser.parse(result);
		
		System.out.println("這是json物件" + element);
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();			
		out.print(element);
		out.flush();
		out.close();
	}

	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
