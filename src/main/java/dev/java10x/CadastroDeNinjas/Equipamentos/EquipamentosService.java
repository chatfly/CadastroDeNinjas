package dev.java10x.CadastroDeNinjas.Equipamentos;

import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class EquipamentosService {

    private EquipamentosRepository equipamentosRepository;

    public EquipamentosService(EquipamentosRepository equipamentosRepository) {
        this.equipamentosRepository = equipamentosRepository;
    }

    public List<EquipamentosModel> listarEquipamentos() {
        return equipamentosRepository.findAll();
    }

    public EquipamentosModel listarEquipamentoPorId(Long id) {
        Optional<EquipamentosModel> equipamentoPorId = equipamentosRepository.findById(id);
        return equipamentoPorId.orElse(null);
    }

    public EquipamentosModel criarEquipamento(EquipamentosModel equipamento) {
        return equipamentosRepository.save(equipamento);
    }

    public EquipamentosModel atualizarEquipamento(Long id, EquipamentosModel equipamentoAtualizado) {
        if(equipamentosRepository.existsById(id)){
            equipamentoAtualizado.setId(id);
            return equipamentosRepository.save(equipamentoAtualizado);
        }
        return null;
    }

    public void deletarEquipamento(Long id) {
        equipamentosRepository.deleteById(id);
    }

}
