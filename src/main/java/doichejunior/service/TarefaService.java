package doichejunior.service;

import doichejunior.model.Tarefa;

public interface TarefaService {

    Tarefa findById(Long id);

    Tarefa create(Tarefa tarefaToCreate);

    void update(Long id,  Tarefa tarefa);

    void delete(Long id);

    Iterable<Tarefa> findAll();




}
