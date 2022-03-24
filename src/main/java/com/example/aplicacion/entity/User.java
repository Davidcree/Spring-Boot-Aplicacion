package com.example.aplicacion.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class User implements Serializable {
    private static final long serialVersionUID = -6833167247955613395L;


    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name="native",strategy="native")
    private Long id;

    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String username;
    @Column
    private String password;

    @Transient
    private String confirmPassword;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="user_roles"
            ,joinColumns=@JoinColumn(name="user_id")
            ,inverseJoinColumns=@JoinColumn(name="role_id"))
    private Set<Role> roles;

    public User() {	}

    public User(Long id) {
        this.id = id;
    }
}
