package com.potato.interview.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "CARDS")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Card {

    @Id
    @Column(name = "C_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "C_NUMBER", length = 16)
    private String number;

    @Column(name = "C_EXP_DATE")
    private LocalDate expirationDate;

    @Column(name = "C_CVV")
    private Integer cvv;

    @Column(name = "C_CONTACTLESS")
    private Boolean isContactless;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "C_U_ID")
    private User user;
}
