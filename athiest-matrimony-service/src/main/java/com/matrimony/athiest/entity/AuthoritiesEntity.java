package com.matrimony.athiest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "authorities")
@AllArgsConstructor
@NoArgsConstructor
public class AuthoritiesEntity {

    @Id
    private String username;

    @PrimaryKeyJoinColumn(name = "username")
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private UserEntity userEntity;
}
