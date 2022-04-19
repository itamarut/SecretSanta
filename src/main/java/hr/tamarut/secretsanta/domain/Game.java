package hr.tamarut.secretsanta.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
@Setter
@Getter
@Accessors(chain = true)
public class Game {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	@OneToMany(mappedBy = "game", orphanRemoval = true, cascade = CascadeType.ALL)
	private Set<Present> presents;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name = "user_game",
			joinColumns = {@JoinColumn(name = "game_id")},
			inverseJoinColumns = {@JoinColumn(name = "user_id")}
	)
	private Set<User> users;
}
