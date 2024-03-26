package com.misael.service.order.entities.dtos;

import java.util.Set;

import com.misael.service.order.entities.Order;

public record UserDto(
		String userName,
		
		String password,
		
		String email) {

}
