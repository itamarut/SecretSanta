package hr.tamarut.secretsanta.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity
@Table
@Setter
@Getter
@Accessors(chain = true)
public class Present {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private String description;

	@ManyToOne
	private Game game;

	@ManyToOne
	private User sourceUser;

	@ManyToOne
	private User targetUser;

	private Boolean givenToUser;
}
