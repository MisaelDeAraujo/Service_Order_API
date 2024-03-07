package com.misael.service.order.entities.dtos;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public record OrderDto(
        @NotBlank(message = "title não pode ser vazio")
        @Length(max = 50, message = "title atingiu limite de caracteres")
        String title,
        @NotBlank(message = "description não pode ser vazio")
        @Length(max = 255, message = "description atingiu limite de cacteres")
        String description,

        @NotBlank(message = "searchPersonByName não pode ser vazio")
        @Length(max = 50, message = "searchPersonByName atingiu limite de cacteres")
        String searchPersonByName


) {
}
