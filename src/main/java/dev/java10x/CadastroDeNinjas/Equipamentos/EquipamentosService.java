package dev.java10x.CadastroDeNinjas.Equipamentos;

import dev.java10x.CadastroDeNinjas.Ninjas.NinjaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EquipamentosService {

    private final NinjaRepository ninjaRepository;
    private EquipamentosRepository equipamentosRepository;
    private EquipamentosMapper equipamentosMapper;

    public EquipamentosService(EquipamentosRepository equipamentosRepository, EquipamentosMapper equipamentosMapper, NinjaRepository ninjaRepository) {
        this.equipamentosRepository = equipamentosRepository;
        this.equipamentosMapper = equipamentosMapper;
        this.ninjaRepository = ninjaRepository;
    }

    public List<EquipamentosDTO> listarEquipamentos() {
        List<EquipamentosModel> equipamentos = equipamentosRepository.findAll();
        return equipamentos.stream()
                .map(equipamentosMapper::map)
                .collect(Collectors.toList());
    }

    public EquipamentosDTO listarEquipamentoPorId(Long id) {
        Optional<EquipamentosModel> equipamentoPorId = equipamentosRepository.findById(id);
        return equipamentoPorId.map(equipamentosMapper::map).orElse(null);
    }

    public EquipamentosDTO criarEquipamento(EquipamentosDTO equipamentosDTO) {
        EquipamentosModel equipamento = equipamentosMapper.map(equipamentosDTO);
        equipamento = equipamentosRepository.save(equipamento);
        return equipamentosMapper.map(equipamento);
    }

    public EquipamentosDTO atualizarEquipamento(Long id, EquipamentosDTO equipamentosDTO) {
        Optional<EquipamentosModel> equipamentoExistente = equipamentosRepository.findById(id);
        if(equipamentoExistente.isPresent()) {
            EquipamentosModel equipamentoAtualizado = equipamentosMapper.map(equipamentosDTO);
            equipamentoAtualizado.setId(id);
            EquipamentosModel equipamentoSalvo = equipamentosRepository.save(equipamentoAtualizado);
            return equipamentosMapper.map(equipamentoSalvo);
        }
        return null;
    }

    public void deletarEquipamento(Long id) {
        equipamentosRepository.deleteById(id);
    }

}
