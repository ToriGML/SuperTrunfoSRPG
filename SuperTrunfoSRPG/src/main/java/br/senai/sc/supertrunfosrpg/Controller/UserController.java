package br.senai.sc.supertrunfosrpg.Controller;

import br.senai.sc.supertrunfosrpg.Model.DTO.UserDTO;
import br.senai.sc.supertrunfosrpg.Model.Entity.User;
import br.senai.sc.supertrunfosrpg.Service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
@NoArgsConstructor
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("create")
    public ResponseEntity<User> cadastrarUsuario(@RequestBody @Valid UserDTO userDTO){
        User usuario = new User();
        BeanUtils.copyProperties(userDTO, usuario);
        return ResponseEntity.ok(userService.cadastrarUsuario(usuario));
    }

    @GetMapping("/find/all")
    public ResponseEntity<List<User>> buscarUsuarios(){
        return ResponseEntity.ok(userService.buscarUsuarios());
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.findById(id));
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<User> editarCarta(@RequestBody @Valid UserDTO userDTO, @PathVariable Long id){
        User usuario = new User();
        BeanUtils.copyProperties(userDTO, usuario);
        usuario.setId_usuario(id);
        return ResponseEntity.ok(userService.editarUsuario(usuario));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Long> deletarUsuario(@PathVariable Long id){
        return ResponseEntity.ok(userService.deletarUsuario(id));
    }

}
