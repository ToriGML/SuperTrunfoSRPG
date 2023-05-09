package br.senai.sc.supertrunfosrpg.Controller;

import br.senai.sc.supertrunfosrpg.Model.DTO.CartaDTO;
import br.senai.sc.supertrunfosrpg.Model.Entity.Carta;
import br.senai.sc.supertrunfosrpg.Service.CartaService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
@RequestMapping("/card")
@CrossOrigin
public class CartaController {

    @Autowired
    private CartaService cartaService;

    @PostMapping("/create")
    public ResponseEntity<Carta> cadastrarCarta(@RequestBody @Valid CartaDTO cartaDTO){
        Carta carta = new Carta();
        BeanUtils.copyProperties(cartaDTO, carta);
        return ResponseEntity.ok(cartaService.cadastrarCarta(carta));
    }

    @GetMapping("/find/all")
    public ResponseEntity<List<Carta>> buscarCartas(){
        return ResponseEntity.ok(cartaService.buscarCartas());
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Carta> findById(@PathVariable Long id) {
        return ResponseEntity.ok(cartaService.findById(id));
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Carta> editarCarta(@RequestBody @Valid CartaDTO cartaDTO, @PathVariable Long id){
        Carta carta = new Carta();
        BeanUtils.copyProperties(cartaDTO, carta);
        carta.setId_carta(id);
        return ResponseEntity.ok(cartaService.editarCarta(carta));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Long> deletarCarta(@PathVariable Long id){
        return ResponseEntity.ok(cartaService.deletarCarta(id));
    }
}
