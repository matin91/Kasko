package com.rocklobstre.kasko.data.entities.mappers;

import com.rocklobstre.kasko.data.entities.UserEntity;
import com.rocklobstre.kasko.domain.models.UserModel;
import com.google.firebase.auth.AuthResult;

/**
 * Created by remychantenay on 23/02/2017.
 */
public class UserMapper {

    public static UserModel transform(UserEntity userEntity) {
        UserModel userModel = null;
        if (userEntity != null) {
            userModel = new UserModel(userEntity.getUsername());
            userModel.setEmail(userEntity.getEmail());
            userModel.setUid(userEntity.getUid());
        }

        return userModel;
    }

    public static UserEntity transform(AuthResult authResult) {
        UserEntity userEntity = null;
        if (authResult != null) {
            userEntity = new UserEntity();
            userEntity.setUid(authResult.getUser().getUid());
            userEntity.setUsername(authResult.getUser().getDisplayName());
            userEntity.setUsername(authResult.getUser().getEmail());
        }

        return userEntity;
    }

}
