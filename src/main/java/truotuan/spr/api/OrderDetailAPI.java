package truotuan.spr.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import truotuan.spr.dto.OrderDTO;
import truotuan.spr.dto.OrderDetailDTO;
import truotuan.spr.dto.ProductDTO;
import truotuan.spr.models.OrderDetailObject;
import truotuan.spr.models.ProductObject;
import truotuan.spr.service.IOrderDetailService;
import truotuan.spr.service.IOrderService;
import truotuan.spr.service.IProductService;

@RestController
public class OrderDetailAPI {
	@Autowired
	private IOrderService orderService;
	@Autowired
	private IProductService productService;
	@Autowired
	private IOrderDetailService orderDetailService;

	@GetMapping("/order-detail/{id}")
	public OrderDetailObject getOrderDetailByOrderId(@PathVariable(name = "id", required = true) Long id) {
		OrderDetailObject orderDetailObject = new OrderDetailObject();
		OrderDTO orderDTO = new OrderDTO();
		List<ProductObject> productObjects = new ArrayList<>();
		List<OrderDetailDTO> orderDetailDTOs = orderDetailService.showByOrderId(id);
		
		orderDTO = orderService.show(id).get(0);
		for(OrderDetailDTO orderDetailDTO:orderDetailDTOs) {
			ProductObject productObject = new ProductObject();
			productObject.setProduct(productService.findOneById(orderDetailDTO.getProduct_id()));
			productObject.setQuantity(orderDetailDTO.getQuantity());
			productObjects.add(productObject);
		}
		
		orderDetailObject.setOrder(orderDTO);
		orderDetailObject.setProducts(productObjects);
		
		return orderDetailObject;
	}

	@PostMapping("/order-detail")
	public OrderDetailObject postOrderDetail(@RequestBody OrderDetailObject orderDetailObject) {
		OrderDTO orderDTO = orderDetailObject.getOrder();
		OrderDetailDTO orderDetailDTO = new OrderDetailDTO();
		ProductDTO productDTO = new ProductDTO();
		List<ProductObject> productObjects = new ArrayList<>();
		
		orderDTO = orderService.save(orderDTO);
		for (ProductObject productObject : orderDetailObject.getProducts()) {
			productDTO = productService.findOneById(productObject.getProduct().getId());
			
			orderDetailDTO.setOrder_id(orderDTO.getId());
			orderDetailDTO.setProduct_id(productObject.getProduct().getId());
			orderDetailDTO.setQuantity(productObject.getQuantity());
			orderDetailService.save(orderDetailDTO);
			
			productObject.setProduct(productDTO);
			productObject.setQuantity(productObject.getQuantity());
			productObjects.add(productObject);
		}
		orderDetailObject.setOrder(orderDTO);
		orderDetailObject.setProducts(productObjects);

		return orderDetailObject;
	}
	
	@PutMapping("/order-detail/{id}")
	public OrderDetailObject putOrderDetail(@PathVariable(name="id", required=true) Long id, @RequestBody OrderDetailObject orderDetailObject) {
		OrderDTO orderDTO = orderDetailObject.getOrder();
		OrderDetailDTO orderDetailDTO = new OrderDetailDTO();
		ProductDTO productDTO = new ProductDTO();
		List<ProductObject> productObjects = new ArrayList<>();
		orderDTO.setId(id);
		orderDTO = orderService.save(orderDTO);
		
		for (ProductObject productObject : orderDetailObject.getProducts()) {
			productDTO = productService.findOneById(productObject.getProduct().getId());
			
			orderDetailDTO.setOrder_id(orderDTO.getId());
			orderDetailDTO.setProduct_id(productObject.getProduct().getId());
			orderDetailDTO.setQuantity(productObject.getQuantity());
			orderDetailService.save(orderDetailDTO);
			
			productObject.setProduct(productDTO);
			productObject.setQuantity(productObject.getQuantity());
			productObjects.add(productObject);
		}
		orderDetailObject.setOrder(orderDTO);
		orderDetailObject.setProducts(productObjects);

		return orderDetailObject;
	}
	
	@DeleteMapping("/order-detail/{id}")
	public void deleteByOrderId(@PathVariable(name = "id", required = true) Long id) {
		try {
			orderDetailService.deleteByOrderId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
