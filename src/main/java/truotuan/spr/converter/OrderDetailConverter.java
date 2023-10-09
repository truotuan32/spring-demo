package truotuan.spr.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import truotuan.spr.dto.OrderDetailDTO;
import truotuan.spr.entity.OrderDetailEntity;
import truotuan.spr.repository.OrderRepository;
import truotuan.spr.repository.ProductRepository;

@Component
public class OrderDetailConverter {
	@Autowired
	private OrderRepository orderReponsitory;
	@Autowired
	private ProductRepository productReponsitory;

	public OrderDetailEntity toEntity(OrderDetailDTO dto) {
		OrderDetailEntity entity = new OrderDetailEntity();
		entity.setOrder(orderReponsitory.findOne(dto.getOrder_id()));
		entity.setProduct(productReponsitory.findOne(dto.getProduct_id()));
		entity.setQuantity(dto.getQuantity());
		return entity;
	}

	public OrderDetailDTO toDTO(OrderDetailEntity entity) {
		OrderDetailDTO dto = new OrderDetailDTO();
		dto.setQuantity(entity.getQuantity());
		dto.setOrder_id(entity.getOrder().getId());
		dto.setProduct_id(entity.getProduct().getId());
		dto.setCreateDate(entity.getCreateDate());
		dto.setId(entity.getId());
		return dto;
	}
	
	public OrderDetailEntity toEntity(OrderDetailDTO dto, OrderDetailEntity entity) {
		entity.setOrder(orderReponsitory.findOne(dto.getOrder_id()));
		entity.setProduct(productReponsitory.findOne(dto.getProduct_id()));
		entity.setQuantity(dto.getQuantity());
		return entity;
	}
}
