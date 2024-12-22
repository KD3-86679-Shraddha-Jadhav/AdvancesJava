package com.ecom.Service;

import com.ecom.dto.OrderRespDto;
import com.ecom.dto.PlaceOrderDto;
import com.ecom.entitties.OrdersEntity;

public interface OrdersService {

	OrderRespDto PlaceOrder(PlaceOrderDto dto);

}
