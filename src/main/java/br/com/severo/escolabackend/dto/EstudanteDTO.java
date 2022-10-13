package br.com.severo.escolabackend.dto;

import br.com.severo.escolabackend.models.Estudante;
import br.com.severo.escolabackend.models.StatusMatricula;
import lombok.Data;

import java.time.LocalDate;

@Data
public class EstudanteDTO {

    private String nome;

    private Integer idade;

    private LocalDate dataMatricula;

    private StatusMatricula statusMatricula;

    public EstudanteDTO(Estudante estudante){
        this.nome = estudante.getNome();
        this.idade = estudante.getIdade();
        this.dataMatricula = estudante.getDataMatricula();
        this.statusMatricula = estudante.getStatus();

    }
}
