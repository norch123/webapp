package webapp.Entity;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "products_type")
@NamedQueries({
	@NamedQuery(name="getAllProductTypes", query="SELECT p FROM ProductType p")      
})
public class ProductType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String type;
	@OneToMany(fetch=FetchType.LAZY, mappedBy="productType")
	private List<Product> listProducts;
	
	public ProductType() {
	
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public List<Product> getListProducts() {
		return listProducts;
	}

	public void setListProducts(List<Product> listProducts) {
		this.listProducts = listProducts;
	}

	@Override
	public String toString() {
		return "ProductType [id=" + id + ", type=" + type + "]";
	}
	

}
