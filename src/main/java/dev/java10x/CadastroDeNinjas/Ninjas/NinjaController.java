package dev.java10x.CadastroDeNinjas.Ninjas;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/ninjas")
public class NinjaController {

    private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @PostMapping("/criar")
        @Operation(summary = "Cria um novo ninja", description = "Essa rota cria um novo ninja e o insere no banco de dados")
        @ApiResponses(value = {
                @ApiResponse(responseCode = "201", description = "Ninja criado com sucesso."),
                @ApiResponse(responseCode = "400", description = "Erro na criação do ninja.")
        })
    public ResponseEntity<String> criarNinja(
            @Parameter(description = "Usuario manda por o ninja por JSON no corpo da requisição")
            @RequestBody NinjaDTO ninja) {
        NinjaDTO novoNinja = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja criado com sucesso: " + novoNinja.getNome() + " (ID): " + novoNinja.getId());
    }

    @GetMapping("/listar")
        @Operation(summary = "Lista todos os ninjas", description = "Essa rota retorna todos os Ninjas cadastrados atualmente")
        @ApiResponses(value = {
                @ApiResponse(responseCode = "200", description = "Ninjas foram listados com sucesso")
        })
    public ResponseEntity<List<NinjaDTO>> listarNinjas() {
        return ResponseEntity.ok(ninjaService.listarNinjas());
    }

    @GetMapping("/listar/{id}")
        @Operation(summary = "Lista o ninja por Id", description = "Essa rota lista um ninja pelo Id")
        @ApiResponses(value = {
                @ApiResponse(responseCode = "200", description = "Ninja encontrado com sucesso."),
                @ApiResponse(responseCode = "404", description = "Ninja não encontrado.")
        })
    public ResponseEntity<?> listarNinjasPorId(
            @Parameter(description = "Usuario manda o Id usando o caminho da requisição")
            @PathVariable Long id) {
        NinjaDTO ninja = ninjaService.listarNinjasPorId(id);
        if(ninja != null) {
            return ResponseEntity.ok(ninja);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Ninja com o ID: " + id + " não foi encontrado.");
    }

    @PutMapping("/alterar/{id}")
        @Operation(summary = "Altera o ninja por Id", description = "Essa rota altera um ninja pelo Id")
        @ApiResponses(value = {
                @ApiResponse(responseCode = "200", description = "Ninja foi alterado com sucesso"),
                @ApiResponse(responseCode = "404", description = "Ninja não encontrado, nenhuma alteração aconteceu.")
        })
    public ResponseEntity<?> alterarNinjaPorId(
            @Parameter(description = "Usuario manda o Id usando o caminho da requisição")
            @PathVariable Long id,
            @Parameter(description = "Usuario manda todos os dados do ninja pelo body, para assim realizar a alteração dos mesmos.")
            @RequestBody NinjaDTO ninjaAtualizado) {

        NinjaDTO ninja = ninjaService.atualizarNinja(id, ninjaAtualizado);

        if (ninja != null) {
            return ResponseEntity.ok(ninja);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Ninja com o ID: " + id + " não foi encontrado.");
    }

    @DeleteMapping("/deletar/{id}")
        @Operation(summary = "Deleta um ninja por Id", description = "Essa rota deleta um ninja cadastrado usando o Id")
        @ApiResponses( value = {
                @ApiResponse(responseCode = "200", description = "O ninja foi deletado com sucesso"),
                @ApiResponse(responseCode = "404", description = "Não foi possível encontrar um ninja com esse Id")
        })
    public ResponseEntity<String> deletarNinjaPorId(
            @Parameter(description = "Usuario manda o Id usando o caminho da requisição")
            @PathVariable Long id) {

        if (ninjaService.listarNinjasPorId(id) != null) {
            ninjaService.deletarNinja(id);
            return ResponseEntity.ok("Ninja com o ID: " + id + " deletado com sucesso.");
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Ninja com o ID: " + id + " não foi encontrado.");

    }

}
