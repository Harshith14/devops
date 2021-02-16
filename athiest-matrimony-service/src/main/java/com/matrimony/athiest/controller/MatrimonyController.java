package com.matrimony.athiest.controller;

import com.matrimony.athiest.exception.UserExist;
import com.matrimony.athiest.model.UserDetailModel;
import com.matrimony.athiest.model.UserModel;
import com.matrimony.athiest.model.UserSearchModel;
import com.matrimony.athiest.service.MatrimonyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/matrimony")
public class MatrimonyController {

    @Autowired
    MatrimonyService service;

    @PostMapping(value = "/register")
    public void registerUser(@RequestBody UserModel userModel) throws UserExist {
        System.out.print(userModel);
        service.registerUser(userModel);
    }

    @GetMapping(value = "/login")
    public UserDetailModel loginUser(Authentication authentication){
       return service.loginUser(authentication);
    }

    @PutMapping
    public UserDetailModel updateUserDetails(@RequestBody UserDetailModel userDetailModel, @RequestParam("file") MultipartFile file) throws IOException {
        System.out.print(userDetailModel);
        System.out.print(("Multipart file : "+file));
        userDetailModel.setProfileImage(file.getBytes());
       return  service.updateUserDetails(userDetailModel);
    }

    @PostMapping(value = "/search")
    public List<UserDetailModel> searchUsers(@RequestBody UserSearchModel userSearchModel){
        return  service.searchUsers(userSearchModel);
    }
}
