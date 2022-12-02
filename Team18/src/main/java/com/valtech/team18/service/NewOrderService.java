package com.valtech.team18.service;

import com.valtech.team18.entity.OrderDetails;

public interface NewOrderService {

	//Save new order information into the database
	OrderDetails saveNew(OrderDetails od);

}