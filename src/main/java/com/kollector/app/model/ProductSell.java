package com.kollector.app.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class ProductSell {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    private Category category;

    private int multiverse_id;
    private String card_name;
    private double usd_price;
    private String condition;
    private String image_url;
    private String user_email;
}
