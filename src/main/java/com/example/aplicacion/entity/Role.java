package com.example.aplicacion.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Role implements Serializable {
    private static final long serialVersionUID = -2969524610059270447L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name="native",strategy="native")
    private Long id;

    @Column
    private String name;
    @Column
    private String description;



}
