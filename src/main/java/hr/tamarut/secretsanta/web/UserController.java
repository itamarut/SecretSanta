package hr.tamarut.secretsanta.web;

import hr.tamarut.secretsanta.dto.VUser;
import hr.tamarut.secretsanta.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {

	private final UserService userService;

	@PostMapping
	public ResponseEntity<VUser> createUser(@Valid @RequestBody VUser vUser) {
		return ResponseEntity.ok(userService.createUser(vUser));
	}
}
