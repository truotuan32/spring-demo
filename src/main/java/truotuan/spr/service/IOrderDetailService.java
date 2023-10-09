package truotuan.spr.service;

import java.util.List;

import truotuan.spr.dto.OrderDetailDTO;

public interface IOrderDetailService {
	OrderDetailDTO save(OrderDetailDTO orderDetail);
	void deleteByOrderId(Long orderId);
	List<OrderDetailDTO> showByOrderId(Long id);
}
