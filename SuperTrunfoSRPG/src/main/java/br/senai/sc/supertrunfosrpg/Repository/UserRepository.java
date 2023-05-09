package br.senai.sc.supertrunfosrpg.Repository;

import br.senai.sc.supertrunfosrpg.Model.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
