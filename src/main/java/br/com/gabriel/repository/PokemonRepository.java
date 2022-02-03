package br.com.gabriel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gabriel.model.PokemonEntity;

@Repository
public interface PokemonRepository extends JpaRepository<PokemonEntity, Long> {

	List<PokemonEntity> findAllByOrderByIdAsc();
}