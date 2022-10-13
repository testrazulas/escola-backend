package br.com.severo.escolabackend.controllers;

import br.com.severo.escolabackend.dto.DetalhesDaTurmaDTO;
import br.com.severo.escolabackend.dto.TurmaDTO;
import br.com.severo.escolabackend.models.Turma;
import br.com.severo.escolabackend.repositories.TurmaRepository;
import br.com.severo.escolabackend.services.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/turmas")
public class TurmasController {


    @Autowired
    private TurmaRepository turmaRepository;
    @Autowired
    private final TurmaService turmaService;

    public TurmasController(TurmaService turmaService) {
        this.turmaService = turmaService;
    }

    @GetMapping
    public Page<TurmaDTO> listarTurmas(@RequestParam (required = false) String nomeEstudante, Pageable pageable){
        if(nomeEstudante == null){
            Page<TurmaDTO> turmas = turmaService.listar(pageable);
            return turmas;
        }
        Page<TurmaDTO> turmas = turmaService.listaPorNome(nomeEstudante, pageable);
        return turmas;

    }

    @PostMapping
    public ResponseEntity<TurmaDTO> cadastrarTurma(@RequestBody @Valid TurmaDTO turmaDTO){
        turmaService.cadastrar(turmaDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(turmaDTO);
    }

   /* @GetMapping("/{id}")
    public TurmaDTO detalharTurma(@PathVariable Long id){
        TurmaDTO turmaDTO = turmaService.detalhar(id);
        return turmaDTO;
    }
    */
    @GetMapping("/{id}")
    public ResponseEntity<DetalhesDaTurmaDTO> detalharTurma(@PathVariable Long id){
        Optional<Turma> turma = turmaRepository.findById(id);
        if(turma.isPresent()){
            return ResponseEntity.ok(new DetalhesDaTurmaDTO(turma.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("{id}")
    @Transactional
    @CacheEvict(value = "listaDeTopicos", allEntries = true)
    public ResponseEntity<TurmaDTO> atualizarTurma(@PathVariable Long id, @RequestBody @Valid TurmaDTO turmaDTO){
        Optional<Turma> optional = turmaRepository.findById(id);
        if(optional.isPresent()){
            Turma turma = turmaDTO.atualizar(id, turmaRepository);
            return ResponseEntity.ok(new TurmaDTO(turma));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> removerTurma(@PathVariable Long id){
            turmaService.removerTurma(id);
            return ResponseEntity.ok().build();
        }
}
