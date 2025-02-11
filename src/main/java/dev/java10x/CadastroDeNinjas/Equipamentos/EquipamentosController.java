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

    // GET -- Mandar uma requisição para mostrar os equipamentos
    @GetMapping("/listar")
    public List<EquipamentosModel> listarEquipamento(){
        return equipamentosService.listarEquipamentos();
    }

    @GetMapping("/listar/{id}")
    public EquipamentosModel listarEquipamentoPorId(@PathVariable Long id) {
        return equipamentosService.listarEquipamentoPorId(id);
    }

    // POST -- Mandar uma requisição para criar um equipamento
    @PostMapping("/criar")
    public EquipamentosModel criarEquipamento(@RequestBody EquipamentosModel equipamento) {
        return equipamentosService.criarEquipamento(equipamento);
    }

    // PUT -- Mandar uma requisição para alterar um equipamento
    @PutMapping("/alterar/{id}")
    public EquipamentosModel alterarEquipamento(@PathVariable Long id, @RequestBody EquipamentosModel equipamentoAtualizado) {
        return equipamentosService.atualizarEquipamento(id, equipamentoAtualizado);
    }

    // DELETE -- Mandar uma requisição para deletar um equipamento
    @DeleteMapping("/deletar/{id}")
    public void deletarEquipamentoPorId(@PathVariable Long id) {
        equipamentosService.deletarEquipamento(id);
    }

}
