package com.g8Dic5.demo.services;

import com.g8Dic5.demo.models.User;
import com.g8Dic5.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAll()
    {
        return userRepository.getAll();
    }

    public Optional<User> getById(Integer id){
        return userRepository.getById(id);
    }

    public Optional<User> getByEmail(String email){
        return userRepository.getByEmail(email);
    }

    public User save(User user){
        if(user.getId() == null)
            return user;
        Optional<User> existeUser = getById((user.getId()));

        if(existeUser.isPresent())
            return user;

        return userRepository.save(user);
    }

    /*
    public User update(User user){
        Optional<User> existeUser = getById(user.getId());

        if(existeUser.isEmpty()){
            return user;
        }
        existeUser.get().setIdentification((user.getIdentification()));
        existeUser.get().setName((user.getName()));
        existeUser.get().setAddress((user.getAddress()));
        existeUser.get().setCellPhone((user.getCellPhone()));
        existeUser.get().setEmail((user.getEmail()));
        existeUser.get().setPassword((user.getPassword()));
        existeUser.get().setZone((user.getZone()));
        existeUser.get().setType((user.getType()));
        return userRepository.save(existeUser.get());
    }
    */

    public User update(User user){
        if(user.getId()!=null){
            Optional<User> existeUser =getById(user.getId());
            if(!existeUser.isEmpty()){
                if(user.getId()!=null){
                    existeUser.get().setIdentification((user.getIdentification()));
                    existeUser.get().setName((user.getName()));
                    existeUser.get().setAddress((user.getAddress()));
                    existeUser.get().setCellPhone((user.getCellPhone()));
                    existeUser.get().setEmail((user.getEmail()));
                    existeUser.get().setPassword((user.getPassword()));
                    existeUser.get().setZone((user.getZone()));
                    existeUser.get().setType((user.getType()));
                }
                if(user.getName()!=null){
                    existeUser.get().setName(user.getName());
                }
                return userRepository.save(existeUser.get());
            }
        }
        return user;
    }

    public void delete(Integer id){
        userRepository.delete(id);
    }

    public boolean existeEmail(String email) {
        return userRepository.existeEmail(email);
    }

    public User autenticarUsuario(String email, String password) {
        Optional<User> usuario = userRepository.autenticarUsuario(email, password);

        if (usuario.isEmpty()) {
            return new User(email, password, "NO DEFINIDO");
        } else {
            return usuario.get();
        }
    }

}
