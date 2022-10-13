package br.com.severo.escolabackend.escolabackend.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Turma {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty(message = "The titulo should not be empty.")
    private String titulo;

    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataCriacao = LocalDate.now();

    @OneToMany(mappedBy = "turma")
    private List<Estudante> estudantes = new ArrayList<>();

    @ManyToOne
    private Usuario usuario;

    private String nivel;

    public Turma(String titulo, String nivel){
        this.titulo = titulo;
        this.nivel = nivel;
    }

}
