package awt.grocery.entity;

public class ProductEntity {

	private long id;

	private String name;

	private float price;

	private int selectedQuantity;

	public ProductEntity() {
		super();
	}

	public ProductEntity(long id, String name, float price, int selectedQuantity) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.selectedQuantity = selectedQuantity;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getSelectedQuantity() {
		return selectedQuantity;
	}

	public void setSelectedQuantity(int selectedQuantity) {
		this.selectedQuantity = selectedQuantity;
	}

}
