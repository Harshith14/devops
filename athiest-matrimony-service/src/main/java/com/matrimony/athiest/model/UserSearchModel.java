package com.matrimony.athiest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserSearchModel {

    private String fullName;
    private String age;
    private String height;
    private String highestEducation;
    private String currentProfession;
    private String organization;
    private String countryName;
    private String stateName;
    private String cityName;
    private String pincode;

}
