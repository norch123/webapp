package webapp.dao;

import java.util.List;
import webapp.Entity.Product;

public interface ProductDAO {

	public List<Product> getAllProducts();
	public void addProduct(Product product);
	public void deleteProduct(Product product);
	public Product getProduct(long id);
	public void updateProduct(Product product);

}
