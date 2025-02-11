package dev.java10x.CadastroDeNinjas.Equipamentos;

import org.springframework.stereotype.Component;

@Component
public class EquipamentosMapper {

    public EquipamentosModel map(EquipamentosDTO equipamentosDTO) {

        EquipamentosModel equipamentosModel = new EquipamentosModel();
        equipamentosModel.setId(equipamentosDTO.getId());
        equipamentosModel.setNome(equipamentosDTO.getNome());
        equipamentosModel.setDescricao(equipamentosDTO.getDescricao());
        equipamentosModel.setNinja(equipamentosDTO.getNinja());

        return equipamentosModel;

    }

    public EquipamentosDTO map(EquipamentosModel equipamentosModel) {

        EquipamentosDTO equipamentosDTO = new EquipamentosDTO();
        equipamentosDTO.setId(equipamentosModel.getId());
        equipamentosDTO.setNome(equipamentosModel.getNome());
        equipamentosDTO.setDescricao(equipamentosModel.getDescricao());
        equipamentosDTO.setNinja(equipamentosModel.getNinja());

        return equipamentosDTO;

    }

}
