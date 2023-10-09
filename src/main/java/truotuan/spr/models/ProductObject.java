package truotuan.spr.models;

import truotuan.spr.dto.ProductDTO;

public class ProductObject {
	private ProductDTO product;
	private int quantity;

	public ProductDTO getProduct() {
		return product;
	}

	public void setProduct(ProductDTO product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
