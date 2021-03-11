package com.mulheres.mulheres_do_brasil.services;

import com.amazonaws.services.applicationautoscaling.model.ObjectNotFoundException;
import com.mulheres.mulheres_do_brasil.dto.UserDTO;
import com.mulheres.mulheres_do_brasil.entities.Category;
import com.mulheres.mulheres_do_brasil.entities.User;
import com.mulheres.mulheres_do_brasil.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.net.URI;
import java.util.Optional;
import java.util.UUID;


@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private S3Service s3Service;

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

    public User find(UUID id) {
        Optional<User> optional = userRepository.findById(id);
        return optional.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + User.class.getName()));
    }

    public URI uploadImage(UUID id, MultipartFile file) {
        URI uri = s3Service.uploadFile(file);
        User user = find(id);
        userRepository.save(user);

        return uri;
    }
}