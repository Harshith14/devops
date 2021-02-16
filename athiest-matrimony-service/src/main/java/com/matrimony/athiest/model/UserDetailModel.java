package com.matrimony.athiest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDetailModel {

    private String username;
    private String fullName;
    private String age;
    private String height;
    private String gender;
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
    private String roles;
    private List<UserDetailModel> userFavourites;
    private byte[] profileImage;
}
