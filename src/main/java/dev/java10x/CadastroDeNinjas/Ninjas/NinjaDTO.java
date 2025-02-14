package dev.java10x.CadastroDeNinjas.Ninjas;

import dev.java10x.CadastroDeNinjas.Equipamentos.EquipamentosModel;

import java.util.List;

public class NinjaDTO {

    private Long id;
    private String nome;
    private String email;
    private String imgUrl;
    private int idade;
    private String rank;
    private List<EquipamentosModel> equipamentos;

    public NinjaDTO() {
    }

    public NinjaDTO(Long id, String nome, String email, String imgUrl, int idade, String rank, List<EquipamentosModel> equipamentos) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.imgUrl = imgUrl;
        this.idade = idade;
        this.rank = rank;
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

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public List<EquipamentosModel> getEquipamentos() {
        return equipamentos;
    }

    public void setEquipamentos(List<EquipamentosModel> equipamentos) {
        this.equipamentos = equipamentos;
    }
}
