package com.matrimony.athiest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_info")
public class UserDetailEntity {

    @Id
    private String username;
    private String fullName;
    private String age;
    private String height;
    private String education;
    private String profession;
    private String organization;
    private String aboutYou;
    private String country;
    private String state;
    private String city;
    private String pincode;
    private String qualitiesLookingFor;
    private String mobile;
    private byte[] profileImage;
}
