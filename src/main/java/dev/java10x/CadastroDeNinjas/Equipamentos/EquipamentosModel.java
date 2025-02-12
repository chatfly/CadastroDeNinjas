package dev.java10x.CadastroDeNinjas.Equipamentos;

import dev.java10x.CadastroDeNinjas.Ninjas.NinjaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "tb_equipamentos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EquipamentosModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String descricao;

    // Um equipamento pode ter apenas um ninja
    @ManyToOne
    @JoinColumn (name = "ninja_id") // Foreign Key ou chave estrangeira
    private NinjaModel ninja;

}
