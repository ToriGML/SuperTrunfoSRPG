package br.senai.sc.supertrunfosrpg.Service;
import br.senai.sc.supertrunfosrpg.Model.Entity.User;
import br.senai.sc.supertrunfosrpg.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public User cadastrarUsuario(User usuario) {
        return userRepository.save(usuario);
    }

    public List<User> buscarUsuarios() {
        return userRepository.findAll();
    }

    public User editarUsuario(User usuario) {
        return userRepository.save(usuario);
    }

    public Long deletarUsuario(Long id) {
        Optional<User> cartaOptional = userRepository.findById(id);
        if(cartaOptional.isPresent()){

        }
        userRepository.deleteById(id);
        return id;
    }

    public User findById(Long id) {
        return userRepository.findById(id).get();
    }
}
