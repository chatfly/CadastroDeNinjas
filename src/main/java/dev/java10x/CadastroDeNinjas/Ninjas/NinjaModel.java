package dev.java10x.CadastroDeNinjas.Ninjas;

import dev.java10x.CadastroDeNinjas.Equipamentos.EquipamentosModel;
import jakarta.persistence.*;

import java.util.List;


// Entity ele transforma uma classe em uma entidade do BD
// JPA = Java Persistance API
@Entity // Identifica uma Entidade de banco de dados
@Table(name = "tb_cadastro") // Identifica a tabela de banco de dados e seu nome
public class NinjaModel {

    @Id // Identifica que o atributo logo abaixo é um ID
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Estratégia que leva ao gerar um ID novo
    private Long id;

    private String nome;

    private String email;

    private int idade;

    // @ManyToOne um ninja tem um unico equipamento
    // @OneToMany um ninja tem vários equipamentos
    @OneToMany (mappedBy = "equipamentos")
    private List<EquipamentosModel> equipamentos;

    public NinjaModel() {
    }

    public NinjaModel(String nome, String email, int idade) {
        this.nome = nome;
        this.email = email;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
