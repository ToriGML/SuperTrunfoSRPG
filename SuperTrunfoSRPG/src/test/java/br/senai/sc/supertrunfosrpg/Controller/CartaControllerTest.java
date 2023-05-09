package br.senai.sc.supertrunfosrpg.Controller;

import br.senai.sc.supertrunfosrpg.Model.DTO.CartaDTO;
import br.senai.sc.supertrunfosrpg.Model.Entity.Carta;
import br.senai.sc.supertrunfosrpg.Service.CartaService;
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

import static br.senai.sc.supertrunfosrpg.Model.enums.Elemento.Medo;
import static br.senai.sc.supertrunfosrpg.Model.enums.Elemento.Morte;
import static br.senai.sc.supertrunfosrpg.Model.enums.Raridade.Reliquia;
import static br.senai.sc.supertrunfosrpg.Model.enums.Tamanho.Grande;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CartaControllerTest {

    @InjectMocks
    private CartaController cartaController;

    @Mock
    private CartaService cartaService;

    @Test
    public void editarCartaTest() {
        CartaDTO cartaDTO = new CartaDTO();
        cartaDTO.setNome("Nova Carta");
        cartaDTO.setVd("Descrição da nova carta");
        cartaDTO.setAtk(10);
        cartaDTO.setDef(8);
        cartaDTO.setHp(5);

        Carta carta = new Carta();
        BeanUtils.copyProperties(cartaDTO, carta);
        carta.setId_carta(1L);

        when(cartaService.editarCarta(carta)).thenReturn(carta);

        ResponseEntity<Carta> responseEntity = cartaController.editarCarta(cartaDTO, 1L);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        Carta cartaEditada = responseEntity.getBody();
        assertEquals(cartaDTO.getNome(), cartaEditada.getNome());
        assertEquals(cartaDTO.getVd(), cartaEditada.getVd());
        assertEquals(cartaDTO.getAtk(), cartaEditada.getAtk());
        assertEquals(cartaDTO.getDef(), cartaEditada.getDef());
        assertEquals(cartaDTO.getHp(), cartaEditada.getHp());
    }

    @Test
    public void cadastrarCartaTest() {
        CartaDTO cartaDTO = new CartaDTO();
        Carta carta = new Carta();
        BeanUtils.copyProperties(cartaDTO, carta);
        when(cartaService.cadastrarCarta(carta)).thenReturn(new Carta(1L, carta.getNome(), carta.getTamanho(), carta.getAtk(), carta.getHp(), carta.getDef(), carta.getVd(), carta.getElemento(), carta.getRaridade()));

        ResponseEntity<Carta> responseEntity = cartaController.cadastrarCarta(cartaDTO);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
        assertEquals(1L, responseEntity.getBody().getId_carta().longValue());
    }

    @Test
    public void buscarCartasTest() {
        List<Carta> cartas = Arrays.asList(
                new Carta(1L, "Carta 1", Grande, 100, 100, 100, "Descrição da Carta 1", Medo, Reliquia),
                new Carta(2L, "Carta 2", Grande, 50, 50, 50, "Descrição da Carta 2", Morte, Reliquia)
        );
        when(cartaService.buscarCartas()).thenReturn(cartas);

        ResponseEntity<List<Carta>> responseEntity = cartaController.buscarCartas();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
        assertEquals(2, responseEntity.getBody().size());
        assertEquals(cartas, responseEntity.getBody());
    }

    @Test
    public void findByIdTest() {
        Long id = 1L;
        Carta carta = new Carta();
        carta.setId_carta(id);
        carta.setNome("Carta de Teste");
        when(cartaService.findById(id)).thenReturn(carta);

        ResponseEntity<Carta> responseEntity = cartaController.findById(id);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
        assertEquals(id, responseEntity.getBody().getId_carta());
        assertEquals("Carta de Teste", responseEntity.getBody().getNome());
    }

    @Test
    public void testDeletarCarta() {
        Carta carta = new Carta();
        carta.setNome("Carta teste");
        cartaService.cadastrarCarta(carta);
        Long id = carta.getId_carta();

        ResponseEntity<Long> response = cartaController.deletarCarta(id);
        assertEquals(HttpStatus.OK, response.getStatusCode());

        Carta cartaDeletada = cartaService.findById(id);
        assertNull(cartaDeletada);
    }
}