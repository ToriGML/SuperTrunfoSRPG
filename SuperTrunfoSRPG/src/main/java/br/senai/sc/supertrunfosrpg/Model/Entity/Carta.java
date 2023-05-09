package br.senai.sc.supertrunfosrpg.Model.Entity;

import br.senai.sc.supertrunfosrpg.Model.enums.Elemento;
import br.senai.sc.supertrunfosrpg.Model.enums.Raridade;
import br.senai.sc.supertrunfosrpg.Model.enums.Tamanho;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_carta")
public class Carta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_carta;

    private String nome;
    @Enumerated(EnumType.STRING)
    private Tamanho tamanho;
    private Integer atk;
    private Integer hp;
    private Integer def;
    private String vd;
    @Enumerated(EnumType.STRING)
    private Elemento elemento;
    @Enumerated(EnumType.STRING)
    private Raridade raridade;

}
