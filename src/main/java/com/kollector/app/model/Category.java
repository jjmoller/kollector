package com.kollector.app.model;

import lombok.Data;

import javax.persistence.*;

// Indicates the relavant stored category attributes. The category_id attribute was chosen to generate automatically for ease-of-use. This model is thus to be used in other relevant package classes and or interfaces.

@Entity
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "category_id")
    private int id;

    private String name;

}
