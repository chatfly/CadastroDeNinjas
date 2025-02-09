package dev.java10x.CadastroDeNinjas.Equipamentos;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/missoes")
public class EquipamentosController {

    // GET -- Mandar uma requisição para mostrar os equipamentos
    @GetMapping("/listar")
    public String listarEquipamento(){
        return "Equipamentos listados com sucesso";
    }

    // POST -- Mandar uma requisição para criar uma missão
    @PostMapping("/criar")
    public String criarEquipamento() {
        return "Equipamento criado com sucesso";
    }

    // PUT -- Mandar uma requisição para alterar uma missão
    @PutMapping("/alterar")
    public String alterarEquipamento() {
        return "Equipamento alterado com sucesso";
    }

    // DELETE -- Mandar uma requisição para deletar uma missão
    @DeleteMapping("/deletar")
    public String deletarEquipamento() {
        return "Equipamento deletado com sucesso";
    }


}
