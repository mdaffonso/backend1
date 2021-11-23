package com.dh.jpa.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "movimento")
@Getter
@Setter
public class MovimentoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "desc")
    private String descricao;

    @Column(name = "qtd")
    private Double quantidade;
}
