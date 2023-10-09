package truotuan.spr.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import truotuan.spr.converter.OrderDetailConverter;
import truotuan.spr.dto.OrderDetailDTO;
import truotuan.spr.entity.OrderDetailEntity;
import truotuan.spr.repository.OrderDetailRepository;
import truotuan.spr.repository.OrderRepository;
import truotuan.spr.service.IOrderDetailService;

@Service
public class OrderDetailService implements IOrderDetailService {
	@Autowired
	private OrderDetailRepository orderDetailReponsitory;

	@Autowired
	private OrderDetailConverter orderDetailConverter;

	@Autowired
	private OrderRepository orderRepository;

	@Override
	public OrderDetailDTO save(OrderDetailDTO orderDetailDTO) {
		OrderDetailEntity entity = new OrderDetailEntity();
		if (orderDetailDTO.getId() != null) {
			entity = orderDetailReponsitory.findOne(orderDetailDTO.getId());
			entity = orderDetailConverter.toEntity(orderDetailDTO, entity);
		} else {
			entity = orderDetailConverter.toEntity(orderDetailDTO);
		}
		orderDetailReponsitory.save(entity);
		return orderDetailConverter.toDTO(entity);
	}

	@Override
	@Transactional
	public void deleteByOrderId(Long orderId) {
		orderDetailReponsitory.deleteByOrderId(orderId);
		orderRepository.delete(orderId);
	}

	@Override
	public List<OrderDetailDTO> showByOrderId(Long id) {
		List<OrderDetailDTO> orderDetailDTOs = new ArrayList<>();
		
		List<OrderDetailEntity> orderDetailEntitys =  orderDetailReponsitory.findByOrderId(id);
		for(OrderDetailEntity orderDetailEntity:orderDetailEntitys) {
			orderDetailDTOs.add(orderDetailConverter.toDTO(orderDetailEntity));
		}
		return orderDetailDTOs;
	}
}
