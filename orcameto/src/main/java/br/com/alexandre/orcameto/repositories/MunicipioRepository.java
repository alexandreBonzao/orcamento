package br.com.alexandre.orcameto.repositories;

import br.com.alexandre.orcameto.model.Municipio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MunicipioRepository extends JpaRepository<Municipio, Integer> {
}
