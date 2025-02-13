package dev.java10x.CadastroDeNinjas.Equipamentos;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<EquipamentosDTO>> listarEquipamento(){
        return ResponseEntity.ok(equipamentosService.listarEquipamentos());
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarEquipamentoPorId(@PathVariable Long id) {

        EquipamentosDTO equipamento = equipamentosService.listarEquipamentoPorId(id);

        if(equipamento != null) {
            return ResponseEntity.ok(equipamento);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Nenhum equipamento com o id: " + id + " foi encontrado.");

    }

    @PostMapping("/criar")
    public ResponseEntity<String> criarEquipamento(@RequestBody EquipamentosDTO equipamento) {
        EquipamentosDTO novoEquipamento = equipamentosService.criarEquipamento(equipamento);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Equipamento foi criado: " + novoEquipamento.getNome() + " ID: " + novoEquipamento.getId());
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarEquipamento(@PathVariable Long id, @RequestBody EquipamentosDTO equipamentoAtualizado) {

        EquipamentosDTO equipamento = equipamentosService.atualizarEquipamento(id, equipamentoAtualizado);

        if(equipamento != null) {
            return ResponseEntity.ok("Equipamento com ID: " + id + " foi atualizado com sucesso.");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Equipamento com ID: " + id + " não existe no banco de dados.");

    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarEquipamentoPorId(@PathVariable Long id) {

        if(equipamentosService.listarEquipamentoPorId(id) != null) {
            equipamentosService.deletarEquipamento(id);
            return ResponseEntity.ok("Equipamento com ID: " + id + " foi deletado com sucesso.");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Nenhum equipamento com ID: " + id + " foi encontrado.");

    }

}
