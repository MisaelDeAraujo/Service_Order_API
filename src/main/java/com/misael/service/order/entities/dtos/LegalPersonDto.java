package com.misael.service.order.entities.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CNPJ;

public record LegalPersonDto(
        @NotBlank(message = "completeName inválido")
        String completeName,
        @NotBlank
        @CNPJ
        String cnpj,
        @NotBlank(message = "cellphone não pode ser vazio")
        @Length(max = 11, min = 9,message = "cellphone inválido")
        String cellphone,
        @Email(message = "email inválido")
        String email
) {
}
