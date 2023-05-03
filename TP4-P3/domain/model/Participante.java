package model;

import java.util.Objects;

class Participante {
	private String nombre;
	private String apellido;
	private String dni;
	private Telefono telefono;
	private Email email;
	private Integer idConcurso;

	public Participante(String apellido, String nombre, String dni, String telefono, String idConcurso, String mail) {
		verificar(nombre);
		verificar(apellido);
		verificar(dni);
		verificar(idConcurso);

		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.telefono = new Telefono(telefono);
		this.idConcurso = Integer.parseInt(idConcurso);
		this.email = new Email(mail);

	}

	private void verificar(String cadena) {
		Objects.requireNonNull(cadena);

		if (cadena.isEmpty() || cadena.isBlank()) {
			throw new RuntimeException("Hay un campo vacio");
		}
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getDni() {
		return dni;
	}

	public String getTelefono() {
		return telefono.obtenerNumero();
	}

	public String getMail() {
		return email.obtenerEmail();
	}

	public Integer getIdConcurso() {
		return idConcurso;
	}

}
