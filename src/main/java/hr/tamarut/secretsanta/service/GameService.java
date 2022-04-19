package hr.tamarut.secretsanta.service;

import hr.tamarut.secretsanta.converter.VGameConverter;
import hr.tamarut.secretsanta.domain.Game;
import hr.tamarut.secretsanta.domain.Present;
import hr.tamarut.secretsanta.domain.User;
import hr.tamarut.secretsanta.dto.VGame;
import hr.tamarut.secretsanta.dto.VUser;
import hr.tamarut.secretsanta.repository.GameRepository;
import hr.tamarut.secretsanta.repository.UserRepository;
import hr.tamarut.secretsanta.util.BadRequestException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class GameService {

	private final GameRepository gameRepository;

	private final UserRepository userRepository;

	@Transactional
	public VGame createGame(VGame vGame) {
		Game game = VGameConverter.from(vGame);
		gameRepository.save(game);
		return VGameConverter.to(game);
	}

	@Transactional
	public VGame addUserToGame(Long gameId, VUser vUser) throws BadRequestException {
		if (vUser == null || vUser.getId() == null) {
			throw new BadRequestException("User id not provided!");
		}
		Game game = gameRepository.findById(gameId).orElseThrow(() -> new BadRequestException("Game with id " + gameId + " not found!"));
		User user = userRepository.findById(vUser.getId()).orElseThrow(() -> new BadRequestException("User with id " + vUser.getId() + " not found!"));

		game.getUsers().add(user);

		return VGameConverter.to(game);
	}

	@Transactional
	public VGame startGame(Long gameId) throws BadRequestException {
		Game game = gameRepository.findById(gameId).orElseThrow(() -> new BadRequestException("Game with id " + gameId + " not found!"));
		if (game.getUsers() == null || game.getUsers().isEmpty()) {
			throw new BadRequestException("No users in the game");
		}
		if (game.getPresents() == null || game.getPresents().isEmpty()) {
			throw new BadRequestException("No presents in the game");
		}
		if (game.getPresents().size() > game.getUsers().size()) {
			throw new BadRequestException("Missing users in the game.");
		} else if (game.getUsers().size() > game.getPresents().size()) {
			throw new BadRequestException("Missing presents in the game.");
		}

		List<User> sourceUsers = new ArrayList<>(game.getUsers());
		Collections.shuffle(sourceUsers);

		List<User> targetUsers = new ArrayList<>(game.getUsers());
		Collections.shuffle(targetUsers);

		List<Present> presents = new ArrayList<>(game.getPresents());
		Collections.shuffle(presents);

		for (int i = 0; i < presents.size(); i++) {
			Present present = presents.get(i);
			present.setGivenToUser(false);
			User sourceUser = sourceUsers.get(i);
			present.setSourceUser(sourceUser);

			User targetUser;
			int j=0;
			while(true) {
				targetUser = targetUsers.get((i+j)%targetUsers.size());
				if(!sourceUser.getId().equals(targetUser.getId())) {
					targetUsers.remove(targetUser);
					break;
				}
				j++;
			}
			present.setTargetUser(targetUser);
		}
		gameRepository.save(game);

		return VGameConverter.to(game);
	}



}
