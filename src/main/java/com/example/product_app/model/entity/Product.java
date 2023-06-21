package com.example.product_app.model.entity;

import lombok.Data;
import javax.persistence.*;
import java.util.Date;

@SequenceGenerator(name = "PRODUCT_SEQUENCE", sequenceName = "PRODUCTS_SEQ", initialValue = 1, allocationSize = 1)
@Data
@Entity
@Table(name = "PRODUCTS")
public class Product {

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRODUCT_SEQUENCE")
    @Id
    @Column(name = "PRODUCT_ID")
    private String productID;

    @Column(name = "PRICE")
    private String price;

    @Column(name = "CATEGORY")
    private String category;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "CREATED_DATE")
    private Date createdDate;
}
