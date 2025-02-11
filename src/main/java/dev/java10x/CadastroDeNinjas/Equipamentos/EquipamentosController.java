package dev.java10x.CadastroDeNinjas.Equipamentos;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/equipamentos")
public class EquipamentosController {

    private EquipamentosService equipamentosService;

    public EquipamentosController(EquipamentosService equipamentosService) {
        this.equipamentosService = equipamentosService;
    }

    @GetMapping("/listar")
    public List<EquipamentosDTO> listarEquipamento(){
        return equipamentosService.listarEquipamentos();
    }

    @GetMapping("/listar/{id}")
    public EquipamentosDTO listarEquipamentoPorId(@PathVariable Long id) {
        return equipamentosService.listarEquipamentoPorId(id);
    }

    @PostMapping("/criar")
    public EquipamentosDTO criarEquipamento(@RequestBody EquipamentosDTO equipamento) {
        return equipamentosService.criarEquipamento(equipamento);
    }

    @PutMapping("/alterar/{id}")
    public EquipamentosDTO alterarEquipamento(@PathVariable Long id, @RequestBody EquipamentosDTO equipamentoAtualizado) {
        return equipamentosService.atualizarEquipamento(id, equipamentoAtualizado);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarEquipamentoPorId(@PathVariable Long id) {
        equipamentosService.deletarEquipamento(id);
    }

}
