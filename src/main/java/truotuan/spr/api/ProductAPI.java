package truotuan.spr.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import truotuan.spr.dto.ProductDTO;
import truotuan.spr.service.IProductService;
import truotuan.spr.utils.ImageUtil;

@RestController
public class ProductAPI {
	@Autowired
	private IProductService productService;
	@Autowired
	private ImageUtil imageUtil;

	@GetMapping("/api/products")
	public List<ProductDTO> getProduct() {
		return productService.show();
	}

	@GetMapping("/api/products/{id}")
	public List<ProductDTO> getProduct(@PathVariable("id") long id) {
		return productService.show(id);
	}

	@GetMapping("/api/products/search")
	public List<ProductDTO> searchProduct(@RequestParam(name = "keyword", required = false, defaultValue = "") String name) {
		return productService.searchProductByName(name);
	}

	@PostMapping("api/products")
	public ProductDTO createProduct(@RequestBody ProductDTO productDTO) {
		return productService.save(productDTO);
	}

	@PostMapping("api/products/upload")
	public ProductDTO createProduct(@RequestParam("name") String name,
			@RequestParam("shortDescription") String shortDescription, @RequestParam("content") String content,
			@RequestParam("thumbnail") MultipartFile thumbnailFile, @RequestParam("price") Long price) {
		ProductDTO productDTO = new ProductDTO();
		productDTO.setName(name);
		productDTO.setContent(content);
		productDTO.setShortDescription(shortDescription);
		productDTO.setPrice(price);
		if (!thumbnailFile.isEmpty()) {
			String nameImg = imageUtil.uploadImg(thumbnailFile, name);
			String urlImg = imageUtil.getUrlImage(nameImg);
			productDTO.setThumbnail(urlImg);
		}
		return productService.save(productDTO);
	}

	@PutMapping("api/products/{id}")
	public ProductDTO updateProduct(@RequestBody ProductDTO productDTO, @PathVariable("id") long id) {
		productDTO.setId(id);
		return productService.save(productDTO);
	}

	@PutMapping("api/products")
	public ProductDTO updateProduct(@RequestBody ProductDTO productDTO) {
		if (productDTO.getId() != null) {
			return productService.save(productDTO);
		} else {
			return null;
		}
	}

	@DeleteMapping("api/products/{id}")
	public void deleteProduct(@PathVariable("id") long id) {
		productService.delete(id);
	}

	@DeleteMapping("api/products")
	public void deleteProduct(@RequestBody Long[] ids) {
		productService.delete(ids);
	}
}
