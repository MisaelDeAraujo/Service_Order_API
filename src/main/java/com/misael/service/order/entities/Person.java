package com.misael.service.order.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "person_tb")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50, unique = true)
    private String completeName;

    @Column(unique = true)
    private String cpf;

    @Column(unique = true)
    private String cnpj;

    @Column(length = 11, unique = true)
    private String cellphone;

    @Column(length = 50, unique = true)
    private String email;
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date personCreatedDate;



}
