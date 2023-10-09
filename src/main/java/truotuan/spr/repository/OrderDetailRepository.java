package truotuan.spr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import truotuan.spr.entity.OrderDetailEntity;

public interface OrderDetailRepository extends JpaRepository<OrderDetailEntity, Long>{
	void deleteByOrderId(Long orderId);
	List<OrderDetailEntity> findByOrderId(Long order_id);
}
