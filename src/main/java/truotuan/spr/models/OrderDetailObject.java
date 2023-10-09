package truotuan.spr.models;

import java.util.ArrayList;
import java.util.List;

import truotuan.spr.dto.OrderDTO;

public class OrderDetailObject {
//	private Long id; //order_id
	private OrderDTO order;
	private List<ProductObject> products = new ArrayList<>();

//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}

	public OrderDTO getOrder() {
		return order;
	}

	public void setOrder(OrderDTO order) {
		this.order = order;
	}

	public List<ProductObject> getProducts() {
		return products;
	}

	public void setProducts(List<ProductObject> products) {
		this.products = products;
	}

}
