package br.senai.sc.supertrunfosrpg.Model.DTO;

import br.senai.sc.supertrunfosrpg.Model.Entity.Carta;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    @NotNull
    private String nickname;
    @NotNull
    @Email
    private String email;
    @NotNull
    private String senha;
    private List<Carta> baralho;

}
