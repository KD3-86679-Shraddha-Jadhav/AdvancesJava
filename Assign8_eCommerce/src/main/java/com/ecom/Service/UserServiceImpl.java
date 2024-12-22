package com.ecom.Service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.dao.UserDao;
import com.ecom.dto.ApiResponse;
import com.ecom.dto.UserReqDto;
import com.ecom.dto.UserRespDto;
import com.ecom.entitties.UserEntity;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private ModelMapper modelMapper;
	

	@Override
	public ApiResponse signUpuser(UserReqDto dto) {
		// TODO Auto-generated method stub
		UserEntity user=modelMapper.map(dto, UserEntity.class);
		UserEntity persistentEntity=userDao.save(user);
		
		return new ApiResponse("user Registered with Id-"+persistentEntity.getId());
	}

}
