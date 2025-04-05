package doichejunior.service.impl;


import doichejunior.model.Tarefa;
import doichejunior.model.Usuario;
import doichejunior.repository.TarefaRepository;
import doichejunior.service.TarefaService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class TarefaServiceImpl implements TarefaService {

    private final TarefaRepository tarefaRepository;

    public TarefaServiceImpl(TarefaRepository tarefaRepository) {
        super();
        this.tarefaRepository = tarefaRepository;
    }

    @Override
    public Tarefa findById(Long id) {

        Optional<Tarefa> tarefa = tarefaRepository.findById(id);

        return tarefa.orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Tarefa create(Tarefa tarefaToCreate) {
        return tarefaRepository.save(tarefaToCreate);
    }

    @Override
    public void update(Long id, Tarefa tarefa) {
        Optional<Tarefa> tarefaBd = tarefaRepository.findById(id);
        if (tarefaBd.isPresent()) {
            tarefaRepository.save(tarefa);
        }
    }

    @Override
    public void delete(Long id) {
        tarefaRepository.deleteById(id);
    }

    @Override
    public Iterable<Tarefa> findAll() {
        return tarefaRepository.findAll();
    }
}
