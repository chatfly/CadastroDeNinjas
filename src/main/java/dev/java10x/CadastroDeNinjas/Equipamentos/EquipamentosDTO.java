package dev.java10x.CadastroDeNinjas.Equipamentos;

import dev.java10x.CadastroDeNinjas.Ninjas.NinjaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class EquipamentosDTO {

    private Long id;
    private String nome;
    private String descricao;
    private NinjaModel ninja;

}
