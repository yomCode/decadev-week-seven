package dev.decagon.fcaebookdemo.serviceImpl;


import dev.decagon.fcaebookdemo.models.User;
import dev.decagon.fcaebookdemo.repositories.UserRepository;
import dev.decagon.fcaebookdemo.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import pojos.UserDto;



@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

   private final UserRepository userRepo;

    public User saveUserto_Db(UserDto userDto){
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        User savedUser =  userRepo.save(user);

       return savedUser;
    }

    public User validateUser(UserDto userDto){
        User user = userRepo.findUserByEmailAndPassword(userDto.getEmail(), userDto.getPassword());

        return user;

    }

}
