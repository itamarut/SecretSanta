package hr.tamarut.secretsanta.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Accessors(chain = true)
public class VPresent {

	private Long id;

	@NotNull
	@NotEmpty
	@NotBlank
	private String name;

	@NotNull
	@NotEmpty
	@NotBlank
	private String description;

	@NotNull
	private VGame game;
}
