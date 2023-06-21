package com.example.product_app.model.entity;

import lombok.Data;
import javax.persistence.*;
import java.util.Date;

@SequenceGenerator(name = "PRODUCTS_SEQUENCE", sequenceName = "PRODUCTS_SEQ", initialValue = 1, allocationSize = 1)
@Data
@Entity
@Table(name = "PRODUCTS")
public class Product {

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRODUCT_SEQUENCE")
    @Id
    @Column(name = "PRODUCT_ID")
    private Integer productID;

    @Column(name = "NAME", length = 120, nullable = false)
    private String name;

    @Column(name = "PRICE", nullable = false)
    private String price;

    @Column(name = "CATEGORY", length = 80, nullable = false)
    private String category;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "CREATED_DATE", nullable = false)
    private Date createdDate;
}
