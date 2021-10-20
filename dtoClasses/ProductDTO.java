package com.kollector.app.dto;

import lombok.Data;

@Data
public class ProductDTO {
    private Long id;
    private String name;
    private int category;
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
