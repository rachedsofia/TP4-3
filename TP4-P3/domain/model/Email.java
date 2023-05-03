package model;

import java.util.Objects;

class Email {
	private String email;

	public Email(String email) {
		Objects.requireNonNull(email);

		if (email.isEmpty() || email.isBlank()) {
			throw new RuntimeException("El campo de email no puede estar vacio");
		}

		if (!checkEmail(email)) {
			throw new RuntimeException("El Email debe ser válido");
		}

		this.email = email;
	}

	public String getEmail() {
		return this.email;
	}

	private boolean checkEmail(String email) {
		String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		return email.matches(regex);
	}
}
