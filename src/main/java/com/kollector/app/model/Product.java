package com.kollector.app.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    private Category category;

    private int multiverse_id;
    private String card_name;
    private double usd_price;
    private String set;
    private String rarity;
    private String condition;
    private String description;
    private String artist;
    private String image_url;
    private int user_id;
}
