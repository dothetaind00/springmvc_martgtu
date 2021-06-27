package com.tai06dothe.controller.admin.api;

import java.util.Base64;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tai06dothe.dto.ProductDTO;
import com.tai06dothe.service.IProductService;
import com.tai06dothe.util.UploadFileUtil;

@RestController(value = "productOfAPI")
public class ProductAPI {

	@Autowired
	private IProductService productService;
	
	@Autowired
	private UploadFileUtil uploadFile;
	
	@PutMapping("/api/product")
	public ProductDTO updateProduct(@RequestBody ProductDTO productDTO,HttpServletRequest request) {
		if (productDTO.getDetails().get(0).getBase64() != null) {
			try {
	            byte[] decodeBase64 = Base64.getDecoder().decode(productDTO.getDetails().get(0).getBase64().getBytes());
	            uploadFile.writeOrUpdate(decodeBase64, "/thumbnail/"+productDTO.getDetails().get(0).getImage(),request);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }		
		}
		return productService.save(productDTO);
	}
	
}
