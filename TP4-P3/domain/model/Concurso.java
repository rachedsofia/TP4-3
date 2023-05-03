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

	public int getId() {
		return this.id;
	}

//	public String getNombre() {
//		return this.nombre;
//	}

	public LocalDate getInicioInscripcion() {
		return this.fechaInicioInscripcion;
	}

	public LocalDate getCierreInscripcion() {
		return this.fechaCierreInscripcion;
	}

	private void verificar(String cadena) {
		Objects.requireNonNull(cadena);

		if (cadena.isEmpty() || cadena.isBlank()) {
			throw new RuntimeException("No se puede crear el concurso dado que hay datos en blanco");
		}
	}
}
