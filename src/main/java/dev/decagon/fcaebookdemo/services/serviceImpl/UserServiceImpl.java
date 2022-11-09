package dev.decagon.fcaebookdemo.services.serviceImpl;

import com.fasterxml.jackson.databind.util.BeanUtil;
import dev.decagon.fcaebookdemo.models.User;
import dev.decagon.fcaebookdemo.repositories.UserRepo;
import dev.decagon.fcaebookdemo.services.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import pojos.UserDto;
import pojos.UserResponseDto;

@Service
public class UserServiceImpl implements UserService {

    UserRepo userRepo;

    @Override
    public User userSignup(UserDto userDto) {

        User user = new User();

        BeanUtils.copyProperties(userDto, user);

        return userRepo.save(user);
    }

    @Override
    public UserResponseDto getUserbyEmail(String email) {

        User user = userRepo.findByEmail(email);

        UserResponseDto responseDto = new UserResponseDto();

        BeanUtils.copyProperties(user, responseDto);

        return responseDto;
    }

    @Override
    public void deleteUserAccount(Long user_id) {
        userRepo.deleteById(user_id);

    }

    @Override
    public void editUserProfile(Long user_id) {
    }


}
