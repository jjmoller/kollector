package com.kollector.app.model;

import lombok.Data;

import javax.persistence.*;

// This class represents domain-specific data and business logic in the model view controller. Also indicates the relavant stored attributes of the cards that are being sold. The id attribute was chosen to generate automatically for ease-of-use. This model is thus to be used in other relevant package classes and or interfaces.
// The many to one relationship is based on the fact that many cards will belong to a single card category.

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
