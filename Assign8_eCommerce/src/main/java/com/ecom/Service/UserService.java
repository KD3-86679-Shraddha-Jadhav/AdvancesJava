package com.ecom.Service;

import com.ecom.dto.ApiResponse;
import com.ecom.dto.UserReqDto;
import com.ecom.dto.UserRespDto;

public interface UserService {

	ApiResponse signUpuser(UserReqDto dto);

}
