package truotuan.spr.converter;

import org.springframework.stereotype.Component;

import truotuan.spr.dto.OrderDTO;
import truotuan.spr.entity.OrderEntity;

@Component
public class OrderConverter {
	public OrderEntity toEntity(OrderDTO orderDTO) {
		OrderEntity orderEntity = new OrderEntity();
		orderEntity.setCustomerName(orderDTO.getCustomerName());
		orderEntity.setCustomerPhone(orderDTO.getCustomerPhone());
		orderEntity.setCustomerAddress(orderDTO.getCustomerAddress());
		orderEntity.setContent(orderDTO.getContent());
		
		return orderEntity;
	}
	
	public OrderDTO toDTO(OrderEntity orderEntity) {
		OrderDTO orderDTO = new OrderDTO();
		if(orderEntity.getId() != null) {
			orderDTO.setId(orderEntity.getId());
		}
		orderDTO.setCustomerName(orderEntity.getCustomerName());
		orderDTO.setCustomerPhone(orderEntity.getCustomerPhone());
		orderDTO.setCustomerAddress(orderEntity.getCustomerAddress());
		orderDTO.setContent(orderEntity.getContent());
		orderDTO.setCreateDate(orderEntity.getCreateDate());
		
		return orderDTO;
	}
	
	public OrderEntity toEntity(OrderDTO orderDTO, OrderEntity orderEntity) {
		orderEntity.setCustomerName(orderDTO.getCustomerName());
		orderEntity.setCustomerPhone(orderDTO.getCustomerPhone());
		orderEntity.setCustomerAddress(orderDTO.getCustomerAddress());
		orderEntity.setContent(orderDTO.getContent());
		
		return orderEntity;
	}
}
