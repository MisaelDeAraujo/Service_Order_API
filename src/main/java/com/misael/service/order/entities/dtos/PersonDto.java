package com.misael.service.order.entities.dtos;

import lombok.Builder;

@Builder
public record PersonDto(
		
		String completeName,
		
		String document,
		
		String cellphone,
		
		String email) {

}
