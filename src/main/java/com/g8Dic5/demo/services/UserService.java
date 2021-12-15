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

    public Optional<User> getUser(int id){
        return userRepository.getUser(id);
    }

    public User create(User user){

        //obtiene el maximo id existente en la coleccion
        Optional<User> userIdMaximo = userRepository.lastUserId();

        //si el id del usuario que se recibe como parametro es nulo, entonces valida el maximo id existente en bdatos
        if(user.getId() == null) {
            //valida el maximo id generado, si no hay ninguno aun el primer id sera 1
            if (userIdMaximo.isEmpty())
                user.setId(1);
                //si retorna informacion suma 1 al meximo id existente y lo asigna como el codigo de usuario
            else
                user.setId(userIdMaximo.get().getId() + 1);
        }
        Optional<User> e = userRepository.getUser(user.getId());
        if (e.isEmpty()){
            if(emailExists(user.getEmail())==false){
                return userRepository.create(user);
            }else{
                return user;
            }
        }else{
            return user;
        }
    }

    public User update(User user){
        if(user.getId()!=null){
            Optional<User> existeUser = userRepository.getUser(user.getId());
            if(!existeUser.isEmpty()){
                if(user.getIdentification()!=null) {
                    existeUser.get().setIdentification((user.getIdentification()));
                }
                if(user.getName()!=null) {
                    existeUser.get().setName((user.getName()));
                }
                if(user.getBirthtDay()!=null) {
                    existeUser.get().setBirthtDay((user.getBirthtDay()));
                }
                if(user.getMonthBirthtDay()!=null) {
                    existeUser.get().setMonthBirthtDay((user.getMonthBirthtDay()));
                }
                if(user.getAddress()!=null) {
                    existeUser.get().setAddress((user.getAddress()));
                }
                if(user.getCellPhone()!=null) {
                    existeUser.get().setCellPhone((user.getCellPhone()));
                }
                if(user.getEmail()!=null) {
                    existeUser.get().setEmail((user.getEmail()));
                }
                if(user.getPassword()!=null) {
                    existeUser.get().setPassword((user.getPassword()));
                }
                if(user.getZone()!=null) {
                    existeUser.get().setZone((user.getZone()));
                }
                if(user.getType()!=null) {
                    existeUser.get().setType((user.getType()));
                }
                return userRepository.create(existeUser.get());
            }
        }
        return user;
    }

    public boolean delete(int userId){
        Boolean aBoolean = getUser(userId).map(user ->{
            userRepository.delete(user);
            return true;
        }).orElse(false);
        return aBoolean;
    }

    public boolean emailExists(String email) {
        return userRepository.emailExists(email);
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
