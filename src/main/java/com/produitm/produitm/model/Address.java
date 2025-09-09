package com.produitm.produitm.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long address_id;
    private String street;
    private String city;
    private String state;

    @ManyToOne
    @JoinColumn(name="person_id")
    private Person person;
}
