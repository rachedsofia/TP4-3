package model;

import java.util.Objects;

import portsin.DominioException;

public class Telefono {

	private String telefono;

	public Telefono(String telefono) {

		Objects.requireNonNull(telefono);

		if (!checkPhone(telefono))
			throw new DominioException("El teléfono debe ingresarse de la siguiente forma: NNNN-NNNNNN");

		this.telefono = telefono;
	}

	public String telefono() {
		return telefono;
	}

	private boolean checkPhone(String telefono) {
		String regex = "\\d{4}-\\d{6}";
		return telefono.matches(regex);
	}

}
