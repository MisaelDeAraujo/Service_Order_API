package com.misael.service.order.entities.dtos;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public record SearchPersonAndRegisterOrderDto(
        @NotBlank(message = "title não pode ser vazio")
        @Length(max = 50, message = "title atingiu limite de caracteres")
        String title,
        @NotBlank(message = "description não pode ser vazio")
        @NotBlank(message = "description não pode ser nulo")
        String description,
        @NotBlank(message = "searchPersonByName não pode ser vazio")
        @Length(max = 50, message = "searchPersonByName atingiu limite de cacteres")
        String searchPersonByName


) {
}
