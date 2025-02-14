package dev.java10x.CadastroDeNinjas.Equipamentos;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/equipamentos")
public class EquipamentosController {

    private EquipamentosService equipamentosService;

    public EquipamentosController(EquipamentosService equipamentosService) {
        this.equipamentosService = equipamentosService;
    }

    @GetMapping("/listar")
        @Operation(summary = "Lista todos os equipamentos", description = "Essa rota mostra todos os equipamentos cadastrados")
        @ApiResponses(value = {
                @ApiResponse(responseCode = "200", description = "Equipamentos foram listados com sucesso")
        })
    public ResponseEntity<List<EquipamentosDTO>> listarEquipamento(){
        return ResponseEntity.ok(equipamentosService.listarEquipamentos());
    }

    @GetMapping("/listar/{id}")
        @Operation(summary = "Lista equipamentos por Id", description = "Essa rota lista um equipamento por Id")
        @ApiResponses(value = {
                @ApiResponse(responseCode = "200", description = "Equipamento foi listado com sucesso"),
                @ApiResponse(responseCode = "404", description = "Equipamento com esse Id não foi encontrado")
        })
    public ResponseEntity<?> listarEquipamentoPorId(
            @Parameter(description = "Usuario manda o Id por caminho da requisição.")
            @PathVariable Long id) {

        EquipamentosDTO equipamento = equipamentosService.listarEquipamentoPorId(id);

        if(equipamento != null) {
            return ResponseEntity.ok(equipamento);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Nenhum equipamento com o id: " + id + " foi encontrado.");

    }

    @PostMapping("/criar")
        @Operation(summary = "Cria um equipamento", description = "Essa rota cria um novo equipamento e insere no banco de dados.")
        @ApiResponses(value = {
                @ApiResponse(responseCode = "201", description = "Equipamento criado com sucesso."),
                @ApiResponse(responseCode = "400", description = "Ocorreu um erro na criação do equipamento.")
        })
    public ResponseEntity<String> criarEquipamento(
            @Parameter(description = "Usuario manda o equipamento por JSON no corpo da requisição.")
            @RequestBody EquipamentosDTO equipamento) {
        EquipamentosDTO novoEquipamento = equipamentosService.criarEquipamento(equipamento);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Equipamento foi criado: " + novoEquipamento.getNome() + " ID: " + novoEquipamento.getId());
    }

    @PutMapping("/alterar/{id}")
        @Operation(summary = "Altera um equipamento", description = "Essa rota altera os dados de um equipamento")
        @ApiResponses(value = {
                @ApiResponse(responseCode = "200", description = "Equipamento alterado com sucesso."),
                @ApiResponse(responseCode = "404", description = "Esse equipamento não foi encontrado.")
        })
    public ResponseEntity<?> alterarEquipamento(
            @Parameter(description = "Usuario manda o Id do equipamento pelo caminho da requisição")
            @PathVariable Long id,
            @Parameter(description = "Usuario manda o Equipamento em JSON pelo corpo da requisição")
            @RequestBody EquipamentosDTO equipamentoAtualizado) {

        EquipamentosDTO equipamento = equipamentosService.atualizarEquipamento(id, equipamentoAtualizado);

        if(equipamento != null) {
            return ResponseEntity.ok("Equipamento com ID: " + id + " foi atualizado com sucesso.");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Equipamento com ID: " + id + " não existe no banco de dados.");

    }

    @DeleteMapping("/deletar/{id}")
        @Operation(summary = "Deleta um equipamento por Id", description = "Essa rota deleta um equipamento por Id")
        @ApiResponses(value = {
                @ApiResponse(responseCode = "200", description = "Equipamento foi deletado com sucesso"),
                @ApiResponse(responseCode = "404", description = "Equipamento não foi encontrado")
        })
    public ResponseEntity<String> deletarEquipamentoPorId(
            @Parameter(description = "Passa o Id do equipamento pelo caminho da requisição.")
            @PathVariable Long id) {

        if(equipamentosService.listarEquipamentoPorId(id) != null) {
            equipamentosService.deletarEquipamento(id);
            return ResponseEntity.ok("Equipamento com ID: " + id + " foi deletado com sucesso.");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Nenhum equipamento com ID: " + id + " foi encontrado.");

    }

}
