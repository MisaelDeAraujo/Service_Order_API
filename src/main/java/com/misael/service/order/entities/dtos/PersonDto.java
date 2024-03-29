package com.misael.service.order.entities.dtos;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record PersonDto(
		@Length(max = 50)
		@NotNull(message = "Complete name não pode estar nulo")
		@NotBlank(message = "Complete name não pode estar vazio")
		String completeName,
		@Length(max = 14, min = 11)
		@NotNull(message = "documento não pode estar nulo")
		@NotBlank(message = "documento não pode estar vazio")
		String document,
		@NotNull(message="cellphone não pode estar nulo")
		@NotBlank(message="cellphone não pode estar vazio")
		String cellphone,
		@Email
		String email) {

}
