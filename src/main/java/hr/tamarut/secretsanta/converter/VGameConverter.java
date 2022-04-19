package hr.tamarut.secretsanta.converter;

import hr.tamarut.secretsanta.domain.Game;
import hr.tamarut.secretsanta.dto.VGame;

import java.util.stream.Collectors;

public class VGameConverter {

	public static Game from(VGame vGame) {
		if (vGame == null) {
			return null;
		}
		return new Game().setName(vGame.getName());
	}

	public static VGame to(Game game) {
		if (game == null) {
			return null;
		}

		VGame vGame = new VGame().setId(game.getId())
				.setName(game.getName());

		if (game.getUsers() != null) {
			vGame.setUsers(game.getUsers().stream().map(u -> VUserConverter.to(u)).collect(Collectors.toList()));
		}
		return vGame;
	}
}
