package com.matrimony.athiest.mapping;

import com.matrimony.athiest.entity.AuthoritiesEntity;
import com.matrimony.athiest.entity.UserDetailEntity;
import com.matrimony.athiest.entity.UserEntity;
import com.matrimony.athiest.model.UserDetailModel;
import com.matrimony.athiest.model.UserModel;
import com.matrimony.athiest.model.UserSearchModel;
import org.modelmapper.ModelMapper;

public class MatrimonyMapper {


    public static UserModel mapToModel(UserEntity entity){
        UserModel model= new UserModel();
       model.setUsername(entity.getUsername());
       model.setPassword(entity.getPassword());
       return model;
    }

    public static  AuthoritiesEntity mapToEntity(UserModel model){
        UserEntity entity = new UserEntity();
        entity.setUsername(model.getUsername());
        entity.setPassword("{noop}"+model.getPassword());
        AuthoritiesEntity authoritiesEntity = new AuthoritiesEntity();
        authoritiesEntity.setUsername(model.getUsername());
        authoritiesEntity.setUserEntity(entity);
        return authoritiesEntity;
    }

    public static UserDetailModel mapToUserDetailModel(UserDetailEntity userDetailEntity,ModelMapper modelMapper){
        return modelMapper.map(userDetailEntity, UserDetailModel.class);
    }

    public static UserDetailEntity mapToUserDetailEntity(UserDetailModel userDetailModel, ModelMapper modelMapper){
        return  modelMapper.map(userDetailModel, UserDetailEntity.class);
    }

    public static UserDetailEntity mapSearchModelToDetailEntity(UserSearchModel userSearchModel,ModelMapper modelMapper){

        return modelMapper.map(userSearchModel, UserDetailEntity.class);
    }

    public static UserDetailEntity updateUserDetailEntity(UserDetailModel m, UserDetailEntity e, ModelMapper mm){
        mm.map(m,e);
        return e;
    }


}
