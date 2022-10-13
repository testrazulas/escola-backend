package br.com.severo.escolabackend.repositories;

import br.com.severo.escolabackend.models.Turma;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Long> {
    Page<Turma> findByEstudantesNome(String nomeEstudante, Pageable pageable);

}
