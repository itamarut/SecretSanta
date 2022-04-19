package hr.tamarut.secretsanta.web;

import hr.tamarut.secretsanta.dto.VGame;
import hr.tamarut.secretsanta.dto.VUser;
import hr.tamarut.secretsanta.service.GameService;
import hr.tamarut.secretsanta.util.BadRequestException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/games")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class GameController {

	private final GameService gameService;

	@PostMapping
	public ResponseEntity<VGame> createGame(@Valid @RequestBody VGame vgame) {
		return ResponseEntity.ok(gameService.createGame(vgame));
	}

	@PostMapping("{gameId}/addUser")
	public ResponseEntity<VGame> addUser(@PathVariable(value = "gameId") Long gameId, @RequestBody VUser vUser) throws BadRequestException {
		return ResponseEntity.ok(gameService.addUserToGame(gameId, vUser));
	}

	@PutMapping("{gameId}/start")
	public ResponseEntity<VGame> startGame(@PathVariable(value = "gameId") Long gameId) throws BadRequestException {
		return ResponseEntity.ok(gameService.startGame(gameId));
	}
}
