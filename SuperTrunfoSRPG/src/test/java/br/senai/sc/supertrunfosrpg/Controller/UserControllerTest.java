package br.senai.sc.supertrunfosrpg.Controller;

import br.senai.sc.supertrunfosrpg.Model.DTO.UserDTO;
import br.senai.sc.supertrunfosrpg.Model.Entity.User;
import br.senai.sc.supertrunfosrpg.Service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {
    @InjectMocks
    private UserController userController;

    @Mock
    private UserService userService;

    @Test
    public void cadastrarUsuarioTest() {
        UserDTO userDTO = new UserDTO("John", "Doe@doe.com", "123", null);
        User user = new User();
        BeanUtils.copyProperties(userDTO, user);
        when(userService.cadastrarUsuario(user)).thenReturn(user);

        ResponseEntity<User> responseEntity = userController.cadastrarUsuario(userDTO);

        assertEquals(200, responseEntity.getStatusCodeValue());
        assertNotNull(responseEntity.getBody());
        assertEquals(user, responseEntity.getBody());
    }

    @Test
    public void buscarUsuariosTest() {
        User user1 = new User(1L, "John", "Doe@doe.com", "123", null);
        User user2 = new User(2L, "John", "Doe@doe.com", "123", null);
        when(userService.buscarUsuarios()).thenReturn(Arrays.asList(user1, user2));

        ResponseEntity<List<User>> responseEntity = userController.buscarUsuarios();

        assertEquals(200, responseEntity.getStatusCodeValue());
        assertEquals(2, responseEntity.getBody().size());
        assertEquals(user1, responseEntity.getBody().get(0));
        assertEquals(user2, responseEntity.getBody().get(1));
        assertNotNull(responseEntity.getBody());
    }

    @Test
    public void findByIdTest() {
        // Given
        User user = new User(1L, "John", "Doe@doe.com", "123", null);
        when(userService.findById(user.getId_usuario())).thenReturn(user);

        // When
        ResponseEntity<User> responseEntity = userController.findById(user.getId_usuario());

        // Then
        assertEquals(200, responseEntity.getStatusCodeValue());
        assertNotNull(responseEntity.getBody());
        assertEquals(user, responseEntity.getBody());
    }

    @Test
    public void editarUsuarioTest() {
        UserDTO userDTO = new UserDTO("John", "Doe@doe.com", "123", null);
        User user = new User();
        BeanUtils.copyProperties(userDTO, user);
        user.setId_usuario(1L);
        when(userService.editarUsuario(user)).thenReturn(user);

        ResponseEntity<User> responseEntity = userController.editarCarta(userDTO, user.getId_usuario());

        assertEquals(200, responseEntity.getStatusCodeValue());
        assertEquals(user, responseEntity.getBody());
    }

    @Test
    public void deletarUsuarioTest() {
        User user = new User();
        user.setNickname("Richarlyson");
        userService.cadastrarUsuario(user);
        Long id = user.getId_usuario();
        when(userService.deletarUsuario(id)).thenReturn(id);

        ResponseEntity<Long> responseEntity = userController.deletarUsuario(id);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        User userDeletado = userService.findById(id);
        assertNull(userDeletado);

        assertEquals(200, responseEntity.getStatusCodeValue());
        assertEquals(id, responseEntity.getBody());
    }
}