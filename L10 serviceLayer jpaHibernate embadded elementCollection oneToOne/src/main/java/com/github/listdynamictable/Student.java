package com.github.listdynamictable;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;

    @Embedded
    private Address address;

    @ElementCollection
    private List<String> phoneNumbers;

    @OneToOne
    private Guardian guardian;

}
