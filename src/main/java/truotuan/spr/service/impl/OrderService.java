package truotuan.spr.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import truotuan.spr.converter.OrderConverter;
import truotuan.spr.dto.OrderDTO;
import truotuan.spr.entity.OrderEntity;
import truotuan.spr.repository.OrderRepository;
import truotuan.spr.service.IOrderService;

@Service
public class OrderService implements IOrderService {
	@Autowired
	private OrderConverter orderConverter;
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public OrderDTO save(OrderDTO orderDTO) {
		OrderEntity orderEntity = new OrderEntity();
		if (orderDTO.getId() == null) {
			orderEntity = orderConverter.toEntity(orderDTO);
		} else {
			orderEntity = orderRepository.findOne(orderDTO.getId());
			orderEntity = orderConverter.toEntity(orderDTO, orderEntity);
		}
		orderRepository.save(orderEntity);
		return orderConverter.toDTO(orderEntity);
	}

	@Override
	public void delete(Long id) {
		orderRepository.delete(id);
	}

	@Override
	public void delete(Long[] ids) {
		for (long id : ids) {
			orderRepository.delete(id);
		}
	}

	@Override
	public List<OrderDTO> show() {
		List<OrderEntity> entities = orderRepository.findAll();
		List<OrderDTO> rs = new ArrayList<>();
		for (OrderEntity entity : entities) {
			rs.add(orderConverter.toDTO(entity));
		}
		return rs;
	}

	@Override
	public List<OrderDTO> show(Long id) {
		List<OrderDTO> rs = new ArrayList<>();
		rs.add(orderConverter.toDTO(orderRepository.findOne(id)));
		return rs;
	}
}
