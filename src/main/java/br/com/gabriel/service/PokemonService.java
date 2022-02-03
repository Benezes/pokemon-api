package br.com.gabriel.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gabriel.dto.PokemonDTO;
import br.com.gabriel.model.PokemonEntity;
import br.com.gabriel.repository.PokemonRepository;

@Service
public class PokemonService {

	@Autowired
	private PokemonRepository pokemonRepository;

	public List<PokemonDTO> findAllPokemons() {
		return pokemonRepository.findAllByOrderByIdAsc().stream().map(PokemonDTO::new).collect(Collectors.toList());
	}

	public PokemonDTO create(PokemonDTO pokemonDto) {
		return new PokemonDTO(pokemonRepository.save(new PokemonEntity(pokemonDto)));
	}

	public PokemonDTO update(Long id, int quantity) {
		return pokemonRepository //
				.findById(id) //
				.map(existingPokemon -> {
					existingPokemon.setQuantity(quantity);
					return new PokemonDTO(pokemonRepository.save(existingPokemon));
				}) //
				.orElseThrow(null);
	}

	public void delete(Long id) {
		pokemonRepository.deleteById(id);
	}
}
