package com.mulheres.mulheres_do_brasil.services;

import com.mulheres.mulheres_do_brasil.dto.UserDTO;
import com.mulheres.mulheres_do_brasil.entities.User;
import com.mulheres.mulheres_do_brasil.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Transactional
    public UserDTO insert(UserDTO dto) {
        User user = new User(
                null,
                dto.getName(),
                dto.getPerfil_image(),
                dto.getEmail(),
                bCryptPasswordEncoder.encode(dto.getPassword()));


        user = userRepository.save(user);

        return new UserDTO(user);
    }

}