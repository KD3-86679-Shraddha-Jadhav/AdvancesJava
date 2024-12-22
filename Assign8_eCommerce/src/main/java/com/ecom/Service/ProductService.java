package com.ecom.Service;

import java.util.List;

import com.ecom.dao.ProductDao;
import com.ecom.dto.ApiResponse;
import com.ecom.dto.ProductDelDto;
import com.ecom.dto.ProductReqDto;
import com.ecom.dto.ProductRespDto;
import com.ecom.entitties.ProductsEntity;

public interface ProductService {

	ApiResponse addProduct(ProductReqDto dto);

	ApiResponse deleteProduct(ProductDelDto dto);

	List<ProductsEntity> getAllproducdetails();

}
