package crud.crud.service;

import crud.crud.dto.UserDTO;
import crud.crud.entity.Users;
import crud.crud.helpers.EncryptDecryptPwd;
import crud.crud.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    public UserService() {}

    public List<Users> getAll() {
        return userRepository.findAll();
    }

    public Users getOne(String id){
        Optional<Users> user = userRepository.findById(id);
        return user.get();
    }

    public Users saveUser(UserDTO user){
        System.out.println("Primer pass plana => " + user.getPassword());
        String encryptedPass = EncryptDecryptPwd.encryptKey(user.getPassword());;
        user.setPassword(encryptedPass);
        System.out.println("Esta es la nueva pass => " + user.getPassword());
        ModelMapper userMapper = new ModelMapper();
        Users save = userMapper.map(user, Users.class);
        return userRepository.save(save);
    }

    public Users updateUser (UserDTO user){
        ModelMapper update = new ModelMapper();
        Users updateData = update.map(user, Users.class);
        return userRepository.save(updateData);
    }

    public String deleteUser(String id) {
        userRepository.deleteById(id);
        return id;
    }
}
