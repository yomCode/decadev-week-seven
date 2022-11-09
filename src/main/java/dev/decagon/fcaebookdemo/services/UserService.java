package dev.decagon.fcaebookdemo.services;

import dev.decagon.fcaebookdemo.models.User;
import pojos.UserDto;
import pojos.UserResponseDto;

public interface UserService {

    User userSignup(UserDto userDto);

    UserResponseDto getUserbyEmail(String email);

    void deleteUserAccount(Long user_id);

    void editUserProfile(Long user_id);

}
