package dev.decagon.fcaebookdemo.services;


import dev.decagon.fcaebookdemo.models.User;
import pojos.UserDto;


public interface UserService {

    User saveUserto_Db(UserDto userDto);

    User  validateUser(UserDto userDto);

}
