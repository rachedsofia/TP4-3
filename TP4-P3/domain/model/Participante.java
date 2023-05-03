package model;

import java.util.Objects;

class Participante {
	private String nombre;
	private String apellido;
	private String dni;
	private Telefono telefono;
	private Email email;

	public Participante(String nombre, String apellido, String dni, String telefono, String email) {
		verificar(nombre);
		verificar(apellido);
		verificar(dni);

		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.telefono = new Telefono(telefono);
		this.email = new Email(email);
	}

	private void verificar(String cadena) {
		Objects.requireNonNull(cadena);

		if (cadena.isEmpty() || cadena.isBlank()) {
			throw new RuntimeException("Hay un campo vacio"); // Cambiar por una exception propia luego
		}
	}

}
