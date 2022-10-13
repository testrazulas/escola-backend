package br.com.severo.escolabackend.escolabackend.dto;


import br.com.severo.escolabackend.escolabackend.models.Turma;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class DetalhesDaTurmaDTO {

    private Long id;
    private String titulo;

    private LocalDate dataCriacao;

    private String nomeNivel;

    private List<EstudanteDTO> estudantes;

    public DetalhesDaTurmaDTO(Turma turma){
        this.id = turma.getId();
        this.titulo = turma.getTitulo();
        this.dataCriacao = turma.getDataCriacao();
        this.nomeNivel = turma.getNivel();
        this.estudantes = new ArrayList<>();
        this.estudantes.addAll(turma.getEstudantes().stream().map(EstudanteDTO::new).collect(Collectors.toList()));

    }
}
