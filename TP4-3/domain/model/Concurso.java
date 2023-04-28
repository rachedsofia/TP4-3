package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import portsin.DominioException;

public class Concurso {

	private Integer idConcurso;
	private String nombre;
	private LocalDate fechaInicioInscripcion;
	private LocalDate fechaFinInscripcion;

	public Concurso(String idConcurso, String nombre, String fechaInicioInscripcion, String fechaFinInscripcion) {

		Objects.requireNonNull(idConcurso);
		Objects.requireNonNull(nombre);
		Objects.requireNonNull(fechaInicioInscripcion);
		Objects.requireNonNull(fechaFinInscripcion);

		if (idConcurso.isEmpty())
			throw new DominioException("El concurso debe tener un identificador");
		if (nombre.isEmpty())
			throw new DominioException("El concurso debe tener un nombre");
		if (fechaInicioInscripcion.isEmpty())
			throw new DominioException("La fecha de inicio del concurso no puede estar vacia");
		if (fechaFinInscripcion.isEmpty())
			throw new DominioException("La fecha de fin del concurso no puede estar vacia");

		this.idConcurso = Integer.parseInt(idConcurso);
		this.nombre = nombre;
		this.fechaInicioInscripcion = LocalDate.parse(fechaInicioInscripcion,
				DateTimeFormatter.ofPattern("yyyy/MM/dd"));
		this.fechaFinInscripcion = LocalDate.parse(fechaFinInscripcion, DateTimeFormatter.ofPattern("yyyy/MM/dd"));

	}

	public Integer idConcurso() {
		return idConcurso;
	}

}
