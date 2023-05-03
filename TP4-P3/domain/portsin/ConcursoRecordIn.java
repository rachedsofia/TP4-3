package portsin;

public record ConcursoRecordIn(String idConcurso, String nombre, String fechaInicioInscripcion, String fechaFinInscripcion) {

	@Override
	public String toString() {
		return nombre;
	}
	
	

}
