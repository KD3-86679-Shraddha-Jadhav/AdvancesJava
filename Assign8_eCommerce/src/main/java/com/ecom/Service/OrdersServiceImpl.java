package com.ecom.Service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.customeException.ResourceNotFoundException;
import com.ecom.dao.OrderDao;
import com.ecom.dao.ProductDao;
import com.ecom.dao.UserDao;
import com.ecom.dto.OrderRespDto;
import com.ecom.dto.PlaceOrderDto;
import com.ecom.entitties.OrdersEntity;
import com.ecom.entitties.ProductsEntity;
import com.ecom.entitties.UserEntity;
import com.ecom.entitties.UserRole;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class OrdersServiceImpl implements OrdersService{

	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	@Override
	public OrderRespDto PlaceOrder(PlaceOrderDto dto) {
		// TODO Auto-generated method stub
		
		UserEntity userEnt=userDao.findById(dto.getCustomer() )
		.orElseThrow(()->new ResourceNotFoundException("Invlid User Id"));
		//ProductsEntity prodEnt=productDao.findById(dto.getProductId()).orElseThrow(()->new ResourceNotFoundException("Invlid Product Id"));
		ProductsEntity prodEnt=productDao.findById(dto.getProduct())
		.orElseThrow(()->new ResourceNotFoundException("Product is not Available!!"));
				
				
		if(userEnt.getRole()!=UserRole.CUSTOMER)
		{
			throw new ResourceNotFoundException("Invalid access!!");
		}
		
			if(!prodEnt.isStatus() && prodEnt.getAvailCount()<=0)
			{
				throw new ResourceNotFoundException("Product out of Stack...");
				
			
			}
			if(prodEnt.getAvailCount()>0)
			{
			OrdersEntity orderEnt=modelMapper.map(dto,OrdersEntity.class);
			orderEnt.setProduct(prodEnt);
			orderEnt.setTotal(prodEnt.getPrice()*dto.getQauntity());
			System.out.println(orderEnt.getProduct());
			userEnt.placeOrder(orderEnt);
			
		
//			orderEnt.setCustomer(userEnt);
//			orderEnt.setProduct(prodEnt);
//			orderEnt.setQauntity();
			int count=(int) (prodEnt.getAvailCount()-dto.getQauntity());
			prodEnt.setAvailCount(count);
			OrdersEntity persistentOrder=(orderDao.save(orderEnt));
			System.out.println(persistentOrder.getProduct());
			return modelMapper.map(persistentOrder, OrderRespDto.class);
			}
			else
			{
				throw new ResourceNotFoundException("Product out of Stack...");
			}
		
	
		
	}

}
