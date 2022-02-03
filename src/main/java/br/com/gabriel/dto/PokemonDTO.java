package br.com.gabriel.dto;

import java.io.Serializable;

import br.com.gabriel.model.PokemonEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PokemonDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private String imagefront;
	private String imageback;
	private int quantity;

	public PokemonDTO(PokemonEntity entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.imagefront = entity.getImagefront();
		this.imageback = entity.getImageback();
		this.quantity = entity.getQuantity();
	}
}
