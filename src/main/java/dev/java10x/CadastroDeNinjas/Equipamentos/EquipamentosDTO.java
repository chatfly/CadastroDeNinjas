package dev.java10x.CadastroDeNinjas.Equipamentos;

import dev.java10x.CadastroDeNinjas.Ninjas.NinjaModel;

public class EquipamentosDTO {

    private Long id;
    private String nome;
    private String descricao;
    private NinjaModel ninja;

    public EquipamentosDTO() {
    }

    public EquipamentosDTO(Long id, String nome, String descricao, NinjaModel ninja) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.ninja = ninja;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public NinjaModel getNinja() {
        return ninja;
    }

    public void setNinja(NinjaModel ninja) {
        this.ninja = ninja;
    }
}
