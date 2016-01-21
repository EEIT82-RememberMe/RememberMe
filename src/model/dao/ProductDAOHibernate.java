package model.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.json.simple.JSONValue;

import products.model.ProductBean;
import products.model.ProductDAO;

public class ProductDAOHibernate implements ProductDAO
{
	private Session session;
	public ProductDAOHibernate(Session session) 
	{	
		this.session = session;
	}
	public Session getSession() {
		return session;
	}
	@Override
	public int getTotalDataNum() {
		List<ProductBean> list = (List<ProductBean>) getSession().createQuery("from ProductBean").list();
		int listCount = list.size();
		return listCount;
	}
	@Override
	public String showProducts() 
	{
		String jsonString = null;
		
		List<ProductBean> list = (List<ProductBean>) getSession()
				.createQuery("FROM ProductBean ORDER BY ProductId").list();
		
		int listCount = list.size();
		System.out.println("listcount = ------>"+listCount);
		List linkList = new LinkedList(); 
		Map<String,String> map = new HashMap();
		for(int i= 0; i<listCount; i++)//從第一筆開始顯示
		{
		    map = new HashMap<String,String>();
			
		    map.put("productId", String.valueOf(list.get(i).getProductId()));
		    //map.put("productCode", String.valueOf(list.get(i).getProductCode()));
			map.put("productNameTw", list.get(i).getProductNameTw());
			map.put("productNameUs", list.get(i).getProductNameUs());
			map.put("productPrice", String.valueOf(list.get(i).getProductPrice()));
			map.put("productImage", list.get(i).getProductImage());
//			map.put("", list.get(i));
//			map.put("", list.get(i));
//			map.put("", list.get(i));
			linkList.add(map);
				System.out.println("i="+i + "linklist="+ linkList);
		}
		jsonString = JSONValue.toJSONString(linkList);
		return jsonString;	
	}
	@Override
	public ProductBean singleProduct(int productId) 
	{
//		String hql = "FROM ProductBean WHERE productCode=:productCode";
//		Query query = session.createQuery(hql);
//		query.setParameter("productCode", productCode);
//		List results = query.list();
//		System.out.println(results);
		ProductBean result = (ProductBean) getSession().get(ProductBean.class, productId);
		System.out.println(result);
		if(result!=null) 
		{
			getSession().save(result);
			return result;
		}
		return null;
	}
	@Override
	public ProductBean select(int productId) 
	{
		return (ProductBean) getSession().get(ProductBean.class, productId);
	}
	@Override
	public int getTotalPages() {
		
		List<ProductBean> list = (List<ProductBean>) getSession().createQuery("from ProductBean").list();
		int listCount = list.size();
		int pages = 0;
		if(listCount%3 ==  0)
		{
			pages = (listCount / 3);
		}
		else if(listCount%3 != 0)
		{
			pages = (listCount / 3) + 1;
		}
		
		return pages;
	}
	@Override
	public List<ProductBean> selectByPage(int page) 
	{
		List<ProductBean> list = (List<ProductBean>) getSession().createQuery("from ProductBean order by ProductId desc")
				.setFirstResult(3 * (page-1) )
				.setMaxResults(3)
                .list();	
		
		return list;
	}
	@Override
	public ProductBean update(int productId,String productNameTw, String productNameUs, String productImage, int productPrice,
			String productDescription, String remarks, int stock, Date updateDate) 
	{
		ProductBean result = (ProductBean) getSession().get(ProductBean.class, productId);
		if(result!=null) {
			result.setProductId(productId);
			result.setProductNameTw(productNameTw);
			result.setProductNameUs(productNameUs);
			if(productImage!=null)
			{
				result.setProductImage(productImage);
			}		
			result.setProductPrice(productPrice);
			result.setProductDescription(productDescription);
			result.setRemarks(remarks);
			result.setStock(stock);
			result.setUpdateDate(updateDate);
		}
		return result;
	}
	@Override
	public boolean delete(int productId) {
		ProductBean bean = (ProductBean) getSession().get(ProductBean.class, productId);
		if(bean!=null) {
			getSession().delete(bean);
			return true;
		}
		return false;
	}
	@Override
	public ProductBean insert(ProductBean bean) {
		ProductBean result = (ProductBean) getSession().get(ProductBean.class, bean.getProductId());
		if(result==null) 
		{
			getSession().save(bean);
			return bean;
		}
		return null;
	}
}
