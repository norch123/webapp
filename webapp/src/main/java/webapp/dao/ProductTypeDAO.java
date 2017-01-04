package webapp.dao;

import java.util.List;

import webapp.Entity.ProductType;

public interface ProductTypeDAO {
	
	public List<ProductType> getAllProductTypes();
	public void addProductType(ProductType productType);
	public void deleteProductType(ProductType productType);
	public ProductType getProductType(long id);
	public void updateProductType(ProductType productType);

}
