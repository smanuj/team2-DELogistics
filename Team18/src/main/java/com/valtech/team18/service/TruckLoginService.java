package com.valtech.team18.service;

import com.valtech.team18.entity.PendingDriver;
import com.valtech.team18.entity.TruckDetails;

public interface TruckLoginService {

	boolean loginvalidation(String username, String password) throws NullPointerException;

	TruckDetails saveNew(PendingDriver pd);

}