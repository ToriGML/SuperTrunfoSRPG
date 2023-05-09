package br.senai.sc.supertrunfosrpg.Model.DTO;

import br.senai.sc.supertrunfosrpg.Model.enums.Elemento;
import br.senai.sc.supertrunfosrpg.Model.enums.Raridade;
import br.senai.sc.supertrunfosrpg.Model.enums.Tamanho;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartaDTO {
    @NotNull
    private String nome;
    @Enumerated(EnumType.STRING)
    private Tamanho tamanho;
    @Positive
    @Min(1)
    @Max(999)
    private Integer atk;
    @Positive
    @Min(1)
    @Max(9999)
    private Integer hp;
    @Positive
    @Min(1)
    @Max(999)
    private Integer def;
    private String vd;
    @NotNull
    @Enumerated(EnumType.STRING)
    private Elemento elemento;
    @Enumerated(EnumType.STRING)
    private Raridade raridade;

}
