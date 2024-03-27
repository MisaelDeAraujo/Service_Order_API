package com.misael.service.order.entities.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum PersonRegisteredType {

	PHYSYCAL("PHYSYCAL"),
	LEGAL("LEGAL");
	
	private final String personType;
	
}
