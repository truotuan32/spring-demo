package truotuan.spr.service;

import java.util.List;

import truotuan.spr.dto.OrderDTO;

public interface IOrderService {
	OrderDTO save(OrderDTO orderDTO);

	void delete(Long id);

	void delete(Long[] ids);

	List<OrderDTO> show();

	List<OrderDTO> show(Long id);
}
