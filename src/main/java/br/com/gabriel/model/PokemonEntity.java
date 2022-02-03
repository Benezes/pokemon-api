package br.com.gabriel.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.gabriel.dto.PokemonDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pokemon")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PokemonEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String imagefront;
	private String imageback;
	private int quantity;

	public PokemonEntity(PokemonDTO dto) {
		this.id = dto.getId();
		this.name = dto.getName();
		this.imagefront = dto.getImagefront();
		this.imageback = dto.getImageback();
		this.quantity = dto.getQuantity();
	}

	public PokemonEntity(String name, String imagefront, String imageback, int quantity) {
		this.name = name;
		this.imagefront = imagefront;
		this.imageback = imageback;
		this.quantity = quantity;
	}
}
