package br.com.severo.escolabackend.escolabackend.dto;

import br.com.severo.escolabackend.escolabackend.models.Turma;
import br.com.severo.escolabackend.escolabackend.repositories.TurmaRepository;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class TurmaDTO {

    private Long id;
    @NotEmpty(message = "The titulo should not be empty.")
    private String titulo;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataCriacao;

    @NotBlank
    private String nomeNivel;

    public TurmaDTO(Turma turma){
        this.id = turma.getId();
        this.titulo = turma.getTitulo();
        this.dataCriacao = turma.getDataCriacao();
        this.nomeNivel = turma.getNivel();
    }

    public static Page<TurmaDTO> converter(Page<Turma> turmas) {
        return turmas.map(TurmaDTO::new);
    }

    public Turma converterDTO(TurmaRepository turmaRepository) {
        return new Turma(titulo, nomeNivel);
    }

    public Turma atualizar(Long id, TurmaRepository turmaRepository) {
        Turma turma = turmaRepository.getReferenceById(id);
        turma.setTitulo(this.titulo);
        turma.setNivel(this.nomeNivel);
        return turma;
    }
}
