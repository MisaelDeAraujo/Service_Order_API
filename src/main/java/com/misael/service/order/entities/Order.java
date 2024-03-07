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
@Table(name = "order_tb")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 50)
    private String title;
    @Column
    private String description;
    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderCreatedDate;


}
