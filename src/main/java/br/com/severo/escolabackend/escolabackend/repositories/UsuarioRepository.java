package br.com.severo.escolabackend.escolabackend.repositories;

import br.com.severo.escolabackend.escolabackend.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByEmail(String email);

}
