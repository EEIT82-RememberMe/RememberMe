package products.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import model.dao.ProductDAOHibernate;
import model.hibernate.HibernateUtil;

public class ProductService 
{
	private ProductDAOHibernate productDao;
	
	public ProductService() 
	{
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		productDao = new ProductDAOHibernate(session);
	}
	public String showProducts()
	{
		return productDao.showProducts();
	}
	public ProductBean singleProduct(int productId) 
	{
		return productDao.singleProduct(productId);
	}
	public ProductBean select(int productId)
	{
		ProductBean result = null;
		if( productId > 0) {
			result = productDao.select(productId);
		}
		return result;
	}
	public int getTotalPages()
	{
		return productDao.getTotalPages();	
	}
	public List<ProductBean> select(ProductBean bean, int page) 
	{
		List<ProductBean> result = null;
		if(bean!=null && bean.getProductId()!=0) {
			ProductBean temp = productDao.select(bean.getProductId());
			if(temp!=null) {
				result = new ArrayList<ProductBean>();
				result.add(temp);
			}
		} else {
			result = productDao.selectByPage(page);  
		}
		return result;
	}
	public ProductBean insert(ProductBean bean) 
	{
		ProductBean result = null;
		if(bean!=null) {
			result = productDao.insert(bean);
		}
		return result;
	}
	public ProductBean update(ProductBean bean) 
	{
		ProductBean result = null;
		if(bean!=null) {
			result = productDao.update(bean.getProductId(),bean.getProductNameTw(), bean.getProductNameUs(),
					bean.getProductImage(),bean.getProductPrice(), bean.getProductDescription(), bean.getRemarks(),
					bean.getStock(),bean.getUpdateDate());
		}
		return result;
	}
	public boolean delete(ProductBean bean) {
		boolean result = false;
		if(bean!=null) {
			result = productDao.delete(bean.getProductId());
		}
		return result;
	}
	public int getTotalDataNum()
	{
		return productDao.getTotalDataNum();	
	}
}
