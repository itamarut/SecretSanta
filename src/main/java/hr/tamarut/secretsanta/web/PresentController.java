package hr.tamarut.secretsanta.web;

import hr.tamarut.secretsanta.dto.VGame;
import hr.tamarut.secretsanta.dto.VPresent;
import hr.tamarut.secretsanta.service.PresentService;
import hr.tamarut.secretsanta.util.BadRequestException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/presents")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PresentController {

	private final PresentService presentService;

	@PostMapping
	public ResponseEntity<VPresent> createPresent(@Valid @RequestBody VPresent vPresent) throws BadRequestException {
		return ResponseEntity.ok(presentService.createPresent(vPresent));
	}

}
