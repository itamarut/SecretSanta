package hr.tamarut.secretsanta.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Accessors(chain = true)
public class VGame {

	private Long id;

	private String name;

	private List<VUser> users = new ArrayList<>();
}
