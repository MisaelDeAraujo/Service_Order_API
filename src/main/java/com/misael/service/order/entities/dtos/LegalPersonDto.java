package com.misael.service.order.entities.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CNPJ;
@Builder
public record LegalPersonDto(
        @NotBlank(message = "completeName não pode ser vazio")
        @NotNull(message = "completeName não pode ser nulo")
        String completeName,
        @NotBlank
        @CNPJ
        String cnpj,
        @NotBlank(message = "cellphone não pode ser vazio")
        @Length(max = 11, min = 9,message = "cellphone inválido")
        String cellphone,
        @Email
        String email
) {
}
