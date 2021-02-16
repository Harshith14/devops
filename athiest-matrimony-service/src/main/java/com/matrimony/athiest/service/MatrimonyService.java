package com.matrimony.athiest.service;

import com.matrimony.athiest.entity.UserDetailEntity;
import com.matrimony.athiest.exception.UserExist;
import com.matrimony.athiest.mapping.MatrimonyMapper;
import com.matrimony.athiest.model.UserDetailModel;
import com.matrimony.athiest.model.UserModel;
import com.matrimony.athiest.model.UserSearchModel;
import com.matrimony.athiest.repo.AuthoritiesRepo;
import com.matrimony.athiest.repo.UserDetailRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class MatrimonyService {

    @Autowired
    AuthoritiesRepo authoritiesRepo;

    @Autowired
    UserDetailRepo userDetailRepo;

    @Autowired
    ModelMapper modelMapper;


    @Transactional
    public void registerUser(UserModel userModel) throws UserExist {
        userModel.getUserDetailModel().setUsername(userModel.getUsername());
        if (!authoritiesRepo.existsById(userModel.getUsername())) {
            authoritiesRepo.save(MatrimonyMapper.mapToEntity(userModel));
            userDetailRepo.save(MatrimonyMapper.mapToUserDetailEntity(userModel.getUserDetailModel(), modelMapper));
        }
        else {
            throw new UserExist("User already exist");
        }
    }
    public UserDetailModel loginUser(Authentication authentication){

      return MatrimonyMapper.mapToUserDetailModel(userDetailRepo
                .findById(authentication.getName()).get(), modelMapper);
    }

    public UserDetailModel updateUserDetails(UserDetailModel userDetailModel) {

        UserDetailEntity entity = userDetailRepo.findById(userDetailModel.getUsername()).get();
       return MatrimonyMapper.mapToUserDetailModel(userDetailRepo.save(MatrimonyMapper.updateUserDetailEntity(userDetailModel,entity,modelMapper)),modelMapper);
    }

    public List<UserDetailModel> searchUsers(UserSearchModel userSearchModel) {

      List<UserDetailEntity> userDetailEntities= userDetailRepo.findAll(
              Example.of(mapToEntity(userSearchModel)));
      List<UserDetailModel> userDetailModels= new ArrayList<>();
        for (UserDetailEntity detailEntity:userDetailEntities) {
            userDetailModels.add(MatrimonyMapper.mapToUserDetailModel(detailEntity,modelMapper));
        }
      return userDetailModels;
    }

    private UserDetailEntity mapToEntity(UserSearchModel userSearchModel){
        UserDetailEntity entity= new UserDetailEntity();
        entity.setAge(userSearchModel.getAge());
        entity.setCountry(userSearchModel.getCountryName());
        entity.setState(userSearchModel.getStateName());
        entity.setCity(userSearchModel.getCityName());
        entity.setFullName(userSearchModel.getFullName());
        entity.setProfession(userSearchModel.getCurrentProfession());
        entity.setHeight(userSearchModel.getHeight());
        entity.setEducation(userSearchModel.getHighestEducation());
        entity.setOrganization(userSearchModel.getOrganization());
        entity.setPincode(userSearchModel.getPincode());
        return entity;
    }
}
