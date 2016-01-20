package products.model;

import java.util.List;

public interface ProductDAO 
{
	public abstract int getTotalPages();
	public abstract String showProducts();
	public abstract int getTotalDataNum();	
	public abstract ProductBean singleProduct(int productId);
	
	public abstract List<ProductBean> selectByPage(int page);
	public abstract ProductBean select(int productId);
	//新增
	public abstract ProductBean insert(ProductBean bean);
	//修改
	public abstract ProductBean update(int productId,String productNameTw, String productNameUs,
			String productIamge,int productPrice ,String productDescription,
			String remarks, int stock ,java.util.Date updateDate);
	//刪除
	 public abstract boolean delete(int productId);
	
}
