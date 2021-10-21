package com.kollector.app.dto;

import lombok.Data;

@Data
public class ProductSellDTO {
    private Long id;
    private int category;
    private int multiverse_id;
    private String card_name;
    private double usd_price;
    private String condition;
    private String image_url;
    private String user_email;
}
