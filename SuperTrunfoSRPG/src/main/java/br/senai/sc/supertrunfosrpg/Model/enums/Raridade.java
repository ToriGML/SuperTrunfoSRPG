package br.senai.sc.supertrunfosrpg.Model.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Raridade {
    Criatura("Criatura"), Desastre("Desastre"), Humano("Humano"), Reliquia("Relíquia");

    String nome;
}
