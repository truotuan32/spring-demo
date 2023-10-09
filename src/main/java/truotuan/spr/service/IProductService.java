package truotuan.spr.service;

import java.util.List;

import truotuan.spr.dto.ProductDTO;

public interface IProductService {
	ProductDTO save(ProductDTO productDTO);
	ProductDTO findOneById(Long id);
	void delete(Long[] ids);
	void delete(Long id);
	List<ProductDTO> show();
	List<ProductDTO> show(Long id);
	List<ProductDTO> searchProductByName(String name);
}
