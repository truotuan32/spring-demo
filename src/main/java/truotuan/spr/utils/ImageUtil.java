package truotuan.spr.utils;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class ImageUtil {

	public String getUrlImage(String nameImg) {
		try {
			Path path = Paths.get("uploads/", nameImg);
			Resource resource = new UrlResource(path.toUri());
			if (resource.exists() && resource.isReadable()) {
				return path.toUri().toString();
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String uploadImg(MultipartFile thumbnailFile, String name) {
		Path path = Paths.get("uploads/");
		try {
			InputStream inputStream = thumbnailFile.getInputStream();
			String nameImg = name + "_" + thumbnailFile.getOriginalFilename();
			Files.copy(inputStream, path.resolve(nameImg), StandardCopyOption.REPLACE_EXISTING);
			return nameImg;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
