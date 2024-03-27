package com.misael.service.order.entities.dtos;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
@Builder
public record PhysicalPersonDto(
        @NotBlank(message = "completeName inválido")
        String completeName,
        @NotBlank
        @CPF
        String cpf,
        @NotBlank(message = "cellphone não pode ser vazio")
        @Length(max = 11, min = 9,message = "cellphone inválido")
        String cellphone,
        @Email(message = "email inválido")
        String email) {
}
