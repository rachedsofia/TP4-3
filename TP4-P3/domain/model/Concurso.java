package model;

import java.time.LocalDate;
import java.util.Objects;

class Concurso {
	private int id;
	private String nombre;
	private LocalDate fechaInicioInscripcion;
	private LocalDate fechaCierreInscripcion;

	public Concurso(int id, String nombre, String inicioInscripcion, String cierreInscripcion) {
		verificar(nombre);
		verificar(inicioInscripcion);
		verificar(cierreInscripcion);

		this.id = id;
		this.nombre = nombre;
		this.fechaInicioInscripcion = LocalDate.parse(inicioInscripcion);
		this.fechaCierreInscripcion = LocalDate.parse(cierreInscripcion);
	}

	public Concurso(String idConcurso, String nombre2, String fechaInicioInscripcion2, String fechaFinInscripcion) {
		verificar(nombre);
		verificar(fechaInicioInscripcion2);
		verificar(fechaFinInscripcion);

		this.id = id;
		this.nombre = nombre;
		this.fechaInicioInscripcion = LocalDate.parse(fechaInicioInscripcion2);
		this.fechaCierreInscripcion = LocalDate.parse(fechaFinInscripcion);
	}

	public int obtenerId() {
		return this.id;
	}

	public LocalDate obtenerInicioInscripcion() {
		return this.fechaInicioInscripcion;
	}

	public LocalDate obtenerCierreInscripcion() {
		return this.fechaCierreInscripcion;
	}

	private void verificar(String cadena) {
		Objects.requireNonNull(cadena);

		if (cadena.isEmpty() || cadena.isBlank()) {
			throw new RuntimeException("No se puede crear el concurso dado que hay datos en blanco");
		}
	}
}
