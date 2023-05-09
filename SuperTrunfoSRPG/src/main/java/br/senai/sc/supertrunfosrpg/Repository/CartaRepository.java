package br.senai.sc.supertrunfosrpg.Repository;

import br.senai.sc.supertrunfosrpg.Model.Entity.Carta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartaRepository extends JpaRepository<Carta, Long> {
}
