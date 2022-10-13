package br.com.severo.escolabackend.services;

import br.com.severo.escolabackend.dto.DetalhesDaTurmaDTO;
import br.com.severo.escolabackend.dto.TurmaDTO;
import br.com.severo.escolabackend.models.Turma;
import br.com.severo.escolabackend.repositories.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class TurmaService {

    @Autowired
    private TurmaRepository turmaRepository;

    public TurmaService(TurmaRepository turmaRepository) {
        this.turmaRepository = turmaRepository;
    }
    @Cacheable(value = "listaDeTopicos")
    public Page<TurmaDTO> listar(Pageable pageable){
        Page<Turma> turmas = turmaRepository.findAll(pageable);
        return TurmaDTO.converter(turmas);
    }

    @Cacheable(value = "listaDeTopicos")
    public Page<TurmaDTO> listaPorNome(String nomeEstudante, Pageable pageable){
        Page<Turma> turmas = turmaRepository.findByEstudantesNome(nomeEstudante, pageable);
        return TurmaDTO.converter(turmas);
    }

    @Transactional
    @CacheEvict(value = "listaDeTopicos", allEntries = true)
    public Turma cadastrar(@RequestBody TurmaDTO turmaDTO){
        Turma turma = turmaDTO.converterDTO(turmaRepository);
        turmaRepository.save(turma);
        return turma;
    }

    public TurmaDTO detalhar(Long id){
       Turma turma = turmaRepository.getReferenceById(id);
       return new TurmaDTO(turma);
    }

    public DetalhesDaTurmaDTO detalharTurma(@PathVariable Long id){
        Optional<Turma> turma = turmaRepository.findById(id);
        return new DetalhesDaTurmaDTO(turma.get());
    }

    @Transactional
    public TurmaDTO atualizar(Long id, TurmaDTO turmaDTO){
       Turma turma = turmaDTO.atualizar(id, turmaRepository);
       return new TurmaDTO(turma);
    }

    @Transactional
    @CacheEvict(value = "listaDeTopicos", allEntries = true)
    public TurmaDTO removerTurma(@PathVariable Long id){
        turmaRepository.deleteById(id);
        return null;
    }
}
