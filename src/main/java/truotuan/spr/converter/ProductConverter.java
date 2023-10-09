package truotuan.spr.converter;

import org.springframework.stereotype.Component;

import truotuan.spr.dto.ProductDTO;
import truotuan.spr.entity.ProductEntity;

@Component
public class ProductConverter {
	public ProductEntity toEntity(ProductDTO productDTO) {
		ProductEntity productEntity = new ProductEntity();
		productEntity.setContent(productDTO.getContent());
		productEntity.setName(productDTO.getName());
		productEntity.setPrice(productDTO.getPrice());
		productEntity.setShortDescription(productDTO.getShortDescription());
		productEntity.setThumbnail(productDTO.getThumbnail());
		
		return productEntity;
	}
	
	public ProductDTO toDTO(ProductEntity productEntity) {
		ProductDTO productDTO = new ProductDTO();
		if(productEntity.getId() != null) {
			productDTO.setId(productEntity.getId());
		}
		productDTO.setContent(productEntity.getContent());
		productDTO.setName(productEntity.getName());
		productDTO.setPrice(productEntity.getPrice());
		productDTO.setShortDescription(productEntity.getShortDescription());
		productDTO.setThumbnail(productEntity.getThumbnail());
		productDTO.setCreateDate(productEntity.getCreateDate());
		
		return productDTO;
	}
	
	public ProductEntity toEntity(ProductDTO productDTO, ProductEntity productEntity) {
		productEntity.setContent(productDTO.getContent());
		productEntity.setName(productDTO.getName());
		productEntity.setPrice(productDTO.getPrice());
		productEntity.setShortDescription(productDTO.getShortDescription());
		productEntity.setThumbnail(productDTO.getThumbnail());
		
		return productEntity;
	}
}
