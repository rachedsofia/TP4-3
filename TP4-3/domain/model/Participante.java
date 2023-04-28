package model;

import java.util.Objects;

import portsin.DominioException;

public class Participante {

	private String nombre;
	private String apellido;
	private Integer dni;
	private Telefono telefono;
	private Mail mail;
	private Integer idConcurso;

	public Participante(String apellido, String nombre, String dni, String telefono, String mail, String idConcurso) {

		Objects.requireNonNull(apellido);
		Objects.requireNonNull(nombre);
		Objects.requireNonNull(dni);
		Objects.requireNonNull(idConcurso);

		if (apellido.isEmpty())
			throw new DominioException("Apellido no puede ser vacio");
		if (nombre.isEmpty())
			throw new DominioException("Nombre no puede ser vacio");
		if (dni.isEmpty())
			throw new DominioException("DNI no puede ser vacio");
		if (idConcurso.isEmpty())
			throw new DominioException("Debe pertenecer a un cocurso");

		this.apellido = apellido;
		this.nombre = nombre;
		this.dni = Integer.parseInt(dni);
		this.telefono = new Telefono(telefono);
		this.mail = new Mail(mail);
		this.idConcurso = Integer.parseInt(idConcurso);
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public Integer getDni() {
		return dni;
	}

	public String getTelefono() {
		return telefono.telefono();
	}

	public String getMail() {
		return mail.getMail();
	}

	public Integer getIdConcurso() {
		return idConcurso;
	}

}
