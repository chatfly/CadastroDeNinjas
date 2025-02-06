package dev.java10x.CadastroDeNinjas.Ninjas;

import dev.java10x.CadastroDeNinjas.Equipamentos.EquipamentosModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


// Entity ele transforma uma classe em uma entidade do BD
// JPA = Java Persistance API
@Entity // Identifica uma Entidade de banco de dados
@Table(name = "tb_cadastro") // Identifica a tabela de banco de dados e seu nome
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NinjaModel {

    @Id // Identifica que o atributo logo abaixo é um ID
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Estratégia que leva ao gerar um ID novo
    private Long id;

    private String nome;
    
    @Column(unique = true)
    private String email;

    private int idade;

    // @ManyToOne um ninja tem um unico equipamento
    // @OneToMany um ninja tem vários equipamentos
    @OneToMany (mappedBy = "equipamentos")
    private List<EquipamentosModel> equipamentos;


}
