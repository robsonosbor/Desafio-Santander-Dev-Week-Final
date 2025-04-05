package doichejunior.controller;

import doichejunior.model.Tarefa;
import doichejunior.model.Usuario;
import doichejunior.service.TarefaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {


    private final TarefaService tarefaService;

    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    @GetMapping
    public Iterable<Tarefa> findAll() {
        return tarefaService.findAll();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Tarefa> findById(@PathVariable Long id) {
        var tarefa = tarefaService.findById(id);
        return ResponseEntity.ok(tarefa);
    }


    @PostMapping
    public ResponseEntity<Tarefa> create(@RequestBody Tarefa tarefaToCreate) {
        var tarefaCreate = tarefaService.create(tarefaToCreate);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(tarefaCreate.getId()).toUri();
        return ResponseEntity.created(location).body(tarefaCreate);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tarefa> atualizar(@PathVariable Long id, @RequestBody Tarefa tarefa) {
        tarefaService.update(id, tarefa);
        return ResponseEntity.ok(tarefa);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        tarefaService.delete(id);
            return ResponseEntity.ok().build();
    }


}