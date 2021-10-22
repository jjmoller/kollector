package com.kollector.app.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

// This class represents domain-specific data and business logic in the model view controller. Also indicates the relavant detail about the specific roles. The id attribute was chosen to generate automatically for ease-of-use. This model is thus to be used in other relevant package classes and or interfaces.
// The many to one relationship is based on the fact that many users will belong to a single role.

@Data
@Entity
@Table(name = "roles")
public class Role {

    @Id@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(nullable = false, unique = true)
    @NotEmpty
    private String name;

    @ManyToMany(mappedBy = "roles")
    private List<User> users;
}
