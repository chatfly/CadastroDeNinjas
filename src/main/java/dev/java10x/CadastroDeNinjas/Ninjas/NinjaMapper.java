package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Component;

@Component
public class NinjaMapper {

    public NinjaModel map(NinjaDTO ninjaDTO) {

        NinjaModel ninjaModel = new NinjaModel();
        ninjaModel.setId(ninjaDTO.getId());
        ninjaModel.setNome(ninjaDTO.getNome());
        ninjaModel.setEmail(ninjaDTO.getEmail());
        ninjaModel.setImgUrl(ninjaDTO.getImgUrl());
        ninjaModel.setIdade(ninjaDTO.getIdade());
        ninjaModel.setRank(ninjaDTO.getRank());
        ninjaModel.setEquipamentos(ninjaDTO.getEquipamentos());

        return ninjaModel;

    }

    public NinjaDTO map(NinjaModel ninjaModel) {

        NinjaDTO ninjaDTO = new NinjaDTO();
        ninjaDTO.setId(ninjaDTO.getId());
        ninjaDTO.setNome(ninjaModel.getNome());
        ninjaDTO.setEmail(ninjaModel.getEmail());
        ninjaDTO.setImgUrl(ninjaModel.getImgUrl());
        ninjaDTO.setIdade(ninjaModel.getIdade());
        ninjaDTO.setRank(ninjaModel.getRank());
        ninjaDTO.setEquipamentos(ninjaModel.getEquipamentos());

        return ninjaDTO;

    }

}
