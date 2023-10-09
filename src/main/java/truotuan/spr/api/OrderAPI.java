package truotuan.spr.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import truotuan.spr.dto.OrderDTO;
import truotuan.spr.service.IOrderService;

@RestController
public class OrderAPI {

	@Autowired
	private IOrderService orderService;

	@GetMapping("/api/order")
	private List<OrderDTO> show() {
		return orderService.show();
	}

	@GetMapping("/api/order/{id}")
	private List<OrderDTO> show(@PathVariable("id") long id) {
		return orderService.show(id);
	}

	@PostMapping("/api/order")
	public OrderDTO createOrder(@RequestBody OrderDTO orderDTO) {
		return orderService.save(orderDTO);
	}

	@PutMapping("/api/order")
	public OrderDTO updateOrder(@RequestBody OrderDTO orderDTO) {
		return orderService.save(orderDTO);
	}

	@PutMapping("/api/order/{id}")
	public OrderDTO updateOrder(@RequestBody OrderDTO orderDTO, @PathVariable("id") long id) {
		orderDTO.setId(id);
		return orderService.save(orderDTO);
	}

	@DeleteMapping("/api/order/{id}")
	public void deleteOrder(@PathVariable("id") long id) {
		orderService.delete(id);
	}

	@DeleteMapping("/api/order")
	public void deleteOrder(@RequestBody Long[] ids) {
		orderService.delete(ids);
	}
}
