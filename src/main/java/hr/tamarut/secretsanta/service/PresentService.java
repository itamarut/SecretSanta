package hr.tamarut.secretsanta.service;

import hr.tamarut.secretsanta.converter.VPresentConverter;
import hr.tamarut.secretsanta.domain.Game;
import hr.tamarut.secretsanta.domain.Present;
import hr.tamarut.secretsanta.dto.VPresent;
import hr.tamarut.secretsanta.repository.GameRepository;
import hr.tamarut.secretsanta.repository.PresentRepository;
import hr.tamarut.secretsanta.util.BadRequestException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PresentService {

	private final PresentRepository presentRepository;

	private final GameRepository gameRepository;

	@Transactional
	public VPresent createPresent(VPresent vPresent) throws BadRequestException {
		Present present = VPresentConverter.from(vPresent);

		Game game = gameRepository.findById(vPresent.getGame().getId()).orElseThrow(() -> new BadRequestException("Game with id " + vPresent.getGame().getId() + " not found!"));
		present.setGame(game);

		presentRepository.save(present);
		return VPresentConverter.to(present);
	}
}
