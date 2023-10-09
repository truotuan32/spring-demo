package truotuan.spr.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import truotuan.spr.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long>{
	
}
