package com.misael.service.order.entities.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.lang.Nullable;

public record PersonDto(
        @NotBlank(message = "Nome Completo inválido")
        String completeName,

        @Nullable
        @CPF
        String cpf,
        @Nullable
        @CNPJ
        String cnpj,
        @NotBlank(message = "Telefone não pode ser vazio")
        @Length(max = 11, min = 11,message = "Telefone inválido")
        String cellphone,
        @Email(message = "EMAIL inválido")
        String email) {
}
