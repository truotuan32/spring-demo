package truotuan.spr.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import truotuan.spr.converter.ProductConverter;
import truotuan.spr.dto.ProductDTO;
import truotuan.spr.entity.ProductEntity;
import truotuan.spr.repository.ProductRepository;
import truotuan.spr.service.IProductService;

@Service
public class ProductService implements IProductService {
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private ProductConverter productConverter;

	@Override
	public ProductDTO save(ProductDTO productDTO) {
		ProductEntity productEntity = new ProductEntity();
		if (productDTO.getId() != null) {
			productEntity = productRepository.findOne(productDTO.getId());
			productEntity = productConverter.toEntity(productDTO, productEntity);
		} else {
			productEntity = productConverter.toEntity(productDTO);
		}
		productEntity = productRepository.save(productEntity);
		productDTO = productConverter.toDTO(productEntity);
		return productDTO;
	}

	@Override
	public void delete(Long id) {
		productRepository.delete(id);
	}

	@Override
	public void delete(Long[] ids) {
		for (long id : ids) {
			productRepository.delete(id);
		}
	}

	@Override
	public List<ProductDTO> show() {
		List<ProductEntity> entities = productRepository.findAll();
		List<ProductDTO> rs = new ArrayList<>();
		for (ProductEntity en : entities) {
			rs.add(productConverter.toDTO(en));
		}
		return rs;
	}

	@Override
	public List<ProductDTO> show(Long id) {
		List<ProductDTO> rs = new ArrayList<>();
		rs.add(productConverter.toDTO(productRepository.findOne(id)));
		return rs;
	}
	@Override
	public List<ProductDTO> searchProductByName(String name) {
		List<ProductEntity> entities = productRepository.findAll();
		List<ProductDTO> rs = new ArrayList<>();
		for (ProductEntity en : entities) {
			if(en.getName().contains(name)) {
				rs.add(productConverter.toDTO(en));	
			}
		}
		return rs;
	}
	@Override
	public ProductDTO findOneById(Long id) {
		return productConverter.toDTO(productRepository.findOne(id));
	}
}
