package hr.tamarut.secretsanta.converter;

import hr.tamarut.secretsanta.domain.Present;
import hr.tamarut.secretsanta.dto.VPresent;

public class VPresentConverter {

	public static Present from(VPresent vPresent) {
		if (vPresent == null) {
			return null;
		}
		return new Present().setName(vPresent.getName())
				.setDescription(vPresent.getDescription());
	}

	public static VPresent to(Present present) {
		if (present == null) {
			return null;
		}
		return new VPresent().setId(present.getId())
				.setName(present.getName())
				.setDescription(present.getDescription())
				.setGame(VGameConverter.to(present.getGame()));
	}
}
