package webapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import webapp.Entity.ProductType;

public class ProductTypeDAOImpl implements ProductTypeDAO {
	
    private EntityManagerFactory entityManagerFactory;

    @PersistenceUnit
    public void setEntityManagerFactory(EntityManagerFactory entityManager) {
        this.entityManagerFactory = entityManager;
    }

	public List<ProductType> getAllProductTypes() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Query query = entityManager.createNamedQuery("getAllProductTypes", ProductType.class);
		List<ProductType> listProductTypes = (List<ProductType>)query.getResultList();
		return listProductTypes;
	}

	public void addProductType(ProductType productType) {
		try {
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			entityManager.getTransaction().begin();
			entityManager.persist(productType);
			entityManager.getTransaction().commit();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteProductType(ProductType productType) {
		// TODO Auto-generated method stub
		
	}

	public ProductType getProductType(long id) {
		ProductType productType = null;
		try {
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			productType = entityManager.find(ProductType.class, id);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return productType;
	}

	public void updateProductType(ProductType productType) {
		// TODO Auto-generated method stub
		
	}

}
