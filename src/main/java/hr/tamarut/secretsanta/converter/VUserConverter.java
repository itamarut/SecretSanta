package hr.tamarut.secretsanta.converter;

import hr.tamarut.secretsanta.domain.User;
import hr.tamarut.secretsanta.dto.VUser;

public class VUserConverter {

	public static User from(VUser vUser) {
		if (vUser == null) {
			return null;
		}
		return new User().setFirstName(vUser.getFirstName())
				.setLastName(vUser.getLastName());
	}

	public static VUser to(User user) {
		if (user == null) {
			return null;
		}
		return new VUser().setId(user.getId())
				.setFirstName(user.getFirstName())
				.setLastName(user.getLastName());
	}
}
