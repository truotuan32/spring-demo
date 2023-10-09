package truotuan.spr.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import truotuan.spr.entity.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, Long>{

}
