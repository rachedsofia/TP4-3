package model;

import java.util.Objects;

class Telefono {
	private String numero;

	public Telefono(String telefono) {
		Objects.requireNonNull(telefono);

		if (telefono.isEmpty() || telefono.isBlank()) {
			throw new RuntimeException("El campo de telefono no puede estar vacio");
		}

		if (!checkPhone(telefono)) {
			throw new RuntimeException("El teléfono debe ingresarse de la siguiente forma: NNNN-NNNNNN");
		}

		this.numero = telefono;
	}

	public String obtenerNumero() {
		return this.numero;
	}

	private boolean checkPhone(String telefono) {
		String regex = "\\d{4}-\\d{6}";
		return telefono.matches(regex);
	}
}
