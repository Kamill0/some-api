package com.potato.interview.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "USERS")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @Column(name = "U_ID")
    private Long id;

    @Column(name = "U_FIRST_NAME")
    private String firstName;

    @Column(name = "U_LAST_NAME")
    private String lastName;

    @Column(name = "U_ADDRESS")
    private String address;

    @Column(name = "U_EMAIL")
    private String email;
}
