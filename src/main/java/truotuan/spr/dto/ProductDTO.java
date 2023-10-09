package truotuan.spr.dto;

public class ProductDTO extends BaseDTO {
	private String name;
	private String shortDescription;
	private String content;
	private String thumbnail;
	private Long price;

	public ProductDTO() {}

	public ProductDTO(String name, String shortDescription, String content, String thumbnail, Long price) {
		this.name = name;
		this.shortDescription = shortDescription;
		this.content = content;
		this.thumbnail = thumbnail;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

}
