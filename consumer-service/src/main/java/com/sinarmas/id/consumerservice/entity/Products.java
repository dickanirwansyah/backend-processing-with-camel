package com.sinarmas.id.consumerservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Products implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "product_code", nullable = false, unique = true)
    private String productCode;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "qty")
    private Integer qty;

    @Column(name = "category")
    private String category;

}
