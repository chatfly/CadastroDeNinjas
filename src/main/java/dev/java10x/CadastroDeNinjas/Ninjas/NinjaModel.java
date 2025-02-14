package dev.java10x.CadastroDeNinjas.Ninjas;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.java10x.CadastroDeNinjas.Equipamentos.EquipamentosModel;
import jakarta.persistence.*;
import lombok.ToString;

import java.util.List;


// Entity ele transforma uma classe em uma entidade do BD
// JPA = Java Persistance API
@Entity // Identifica uma Entidade de banco de dados
@Table(name = "tb_cadastro") // Identifica a tabela de banco de dados e seu nome
@ToString(exclude = "equipamentos")
public class NinjaModel {

    @Id // Identifica que o atributo logo abaixo é um ID
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Estratégia que leva ao gerar um ID novo
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(unique = true)
    private String email;

    @Column(name = "img_url")
    private String imgUrl;

    @Column(name = "rank")
    private String rank;

    @Column(name = "idade")
    private int idade;

    // @ManyToOne um ninja tem um unico equipamento
    // @OneToMany um ninja tem vários equipamentos
    @OneToMany (mappedBy = "ninja")
    @JsonIgnore
    @Column(name = "equipamentos")
    private List<EquipamentosModel> equipamentos;

    public NinjaModel() {
    }

    public NinjaModel(Long id, String nome, String email, String imgUrl, String rank, int idade, List<EquipamentosModel> equipamentos) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.imgUrl = imgUrl;
        this.rank = rank;
        this.idade = idade;
        this.equipamentos = equipamentos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public List<EquipamentosModel> getEquipamentos() {
        return equipamentos;
    }

    public void setEquipamentos(List<EquipamentosModel> equipamentos) {
        this.equipamentos = equipamentos;
    }
}
