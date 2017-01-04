package webapp.admin.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import webapp.Entity.Product;
import webapp.dao.ProductDAOImpl;

@Controller
@RequestMapping(path= "/admin")
public class AdminPageController {
	
	@Autowired
	private ProductDAOImpl productDAOImpl;

	public ProductDAOImpl getProductDAOImpl() {
		return productDAOImpl;
	}

	public void setProductDAOImpl(ProductDAOImpl productDAOImpl) {
		this.productDAOImpl = productDAOImpl;
	}

	@RequestMapping(value = "/all.do")
	public String getAdminPage(Model m) {
		List<Product> list = productDAOImpl.getAllProducts();
		m.addAttribute("listProducts", list);
	    return "main_admin_page";
	}
	
	@RequestMapping(value = "/addProduct.do")
	public String getAddProductPage(Model m) {
		m.addAttribute("message", "HelloSpring");
	    return "add_product_page";
	}
}
