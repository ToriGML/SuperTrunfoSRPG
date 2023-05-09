package br.senai.sc.supertrunfosrpg.Service;

import br.senai.sc.supertrunfosrpg.Model.Entity.Carta;
import br.senai.sc.supertrunfosrpg.Repository.CartaRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class CartaService {

    @Autowired
    private CartaRepository cartaRepository;


    public Carta cadastrarCarta(Carta carta) {
        return cartaRepository.save(carta);
    }

    public List<Carta> buscarCartas() {
        return cartaRepository.findAll();
    }

    public Carta editarCarta(Carta carta) {
        return cartaRepository.save(carta);
    }

    public Long deletarCarta(Long id) {
        cartaRepository.deleteById(id);
        return id;
    }

    public Carta findById(Long id) {
        return cartaRepository.findById(id).get();
    }
}

