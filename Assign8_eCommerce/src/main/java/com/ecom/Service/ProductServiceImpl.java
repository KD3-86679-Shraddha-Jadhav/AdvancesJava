package com.ecom.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.dao.ProductDao;
import com.ecom.dao.UserDao;
import com.ecom.dto.ApiResponse;
import com.ecom.dto.ProductDelDto;
import com.ecom.dto.ProductReqDto;

import com.ecom.entitties.ProductsEntity;
import com.ecom.entitties.UserEntity;
import com.ecom.entitties.UserRole;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private ModelMapper modelMapper;
	

	@Override
	public ApiResponse addProduct(ProductReqDto dto) {
		// TODO Auto-generated method stub
		
		UserEntity user=userDao.findById(dto.getUserId()).orElseThrow();
		if(user.getRole()==UserRole.ADMIN)
		{
			ProductsEntity productEnt=modelMapper.map(dto, ProductsEntity.class);
			ProductsEntity persistentEntity=productDao.save(productEnt);
			
			return new ApiResponse("Product added with id-"+persistentEntity.getId());
		}
		
		
		
		return new ApiResponse("Invalid Access");
	}

	@Override
	public ApiResponse deleteProduct(ProductDelDto dto) {
		// TODO Auto-generated method stub
		UserEntity userEnt=userDao.findById(dto.getUserid()).orElseThrow();
		ProductsEntity productEnt=productDao.findById(dto.getProductId()).orElseThrow();
		if(userEnt.getRole()==UserRole.ADMIN)
		{
			productEnt.setStatus(false);
			return new ApiResponse("Product Deleted!!!");
			
		}
		return new ApiResponse("Invalid User!!!");
	}


	@Override
	public List<ProductsEntity> getAllproducdetails() {
	
		// TODO Auto-generated method stub
		
		return productDao.findAll();
	
	

	}
}
