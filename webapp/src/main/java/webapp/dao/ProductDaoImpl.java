package webapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import webapp.Entity.Product;

public class ProductDaoImpl implements ProductDAO {
	
    private EntityManagerFactory entityManagerFactory;

    @PersistenceUnit
    public void setEntityManagerFactory(EntityManagerFactory entityManager) {
        this.entityManagerFactory = entityManager;
    }

	
	public List<Product> getAllProducts() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Query query = entityManager.createNamedQuery("getAllProducts", Product.class);
		List<Product> listProducts = (List<Product>)query.getResultList();
		return listProducts;
	}

	public void addProduct(Product product) {
		try {
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			entityManager.getTransaction().begin();
			entityManager.persist(product);
			entityManager.getTransaction().commit();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteProduct(Product product) {
		
	}

	public Product getProduct(long id) {
		Product product = entityManagerFactory.createEntityManager().find(Product.class, id);
		return product;
	}

	public void updateProduct(Product product) {
		
	}

}
