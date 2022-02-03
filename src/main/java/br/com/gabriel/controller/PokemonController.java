package br.com.gabriel.controller;

import java.net.URI;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.gabriel.dto.PokemonDTO;
import br.com.gabriel.service.PokemonService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/pokemons")
public class PokemonController {

	@Autowired
	private PokemonService pokemonService;

	@GetMapping
	public ResponseEntity<List<PokemonDTO>> findAll() {
		return ResponseEntity.ok(pokemonService.findAllPokemons());
	}

	@PostMapping
	public ResponseEntity<PokemonDTO> create(@RequestBody PokemonDTO dto) {
		dto = pokemonService.create(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<PokemonDTO> update(@PathVariable Long id, @RequestBody Map<String, Object> payload) {
		return ResponseEntity.ok(pokemonService.update(id, (int) payload.get("quantity")));
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		pokemonService.delete(id);
		return ResponseEntity.noContent().build();
	}

}
