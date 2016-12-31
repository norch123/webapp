package webapp.controllers;

import java.util.List;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import webapp.Entity.Product;
import webapp.dao.ProductDaoImpl;

@Controller
@RequestMapping(path= "/products")
public class ProductController {
	
	@Autowired
	private ProductDaoImpl productDAOImpl;

	public ProductDaoImpl getProductDAOImpl() {
		return productDAOImpl;
	}

	public void setProductDAOImpl(ProductDaoImpl productDAOImpl) {
		this.productDAOImpl = productDAOImpl;
	}

	@RequestMapping(value = "/all.do", method = RequestMethod.POST)
	@ResponseBody
	public String getAllProducts() {
		List<Product> listProducts = null;;
		try {
			listProducts = productDAOImpl.getAllProducts();
		} catch(Exception e) {
			System.out.println(e);
		}
		return listProducts.toString();
 	}
	
	@RequestMapping(value = "/add.do", method = RequestMethod.POST) 
	@ResponseBody
	public String addProduct(@RequestParam("productname") String name, 
			@RequestParam("description") String description,
			@RequestParam("price") String price) {
		
		Product product = new Product(name, description, Float.valueOf(price));
		productDAOImpl.addProduct(product);
		System.out.println(product);
		return null;
	}
	

}
