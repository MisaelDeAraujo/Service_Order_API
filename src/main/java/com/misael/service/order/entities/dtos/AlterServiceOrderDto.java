package com.misael.service.order.entities.dtos;

import org.hibernate.validator.constraints.Length;

public record AlterServiceOrderDto(

        @Length(max = 50, message = "title atingiu limite de caracteres")
        String title,
        String description
) {
}
