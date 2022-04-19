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
public class VUser {

	private Long id;

	@NotNull
	@NotEmpty
	@NotBlank
	private String firstName;

	@NotNull
	@NotEmpty
	@NotBlank
	private String lastName;
}
