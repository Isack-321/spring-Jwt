package com.ituwei.springbootJwt.model;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name ="user")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDetail {

    @Id
    private int id;

    private String username;
    private String password;
    private String email;


}
