package hr.tamarut.secretsanta.service;

import hr.tamarut.secretsanta.converter.VUserConverter;
import hr.tamarut.secretsanta.domain.User;
import hr.tamarut.secretsanta.dto.VUser;
import hr.tamarut.secretsanta.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserService {

	private final UserRepository userRepository;

	@Transactional
	public VUser createUser(VUser vUser) {
		User user = VUserConverter.from(vUser);
		userRepository.save(user);

		return VUserConverter.to(user);
	}
}
