package portsout;

public interface RegistroInscripcion {
	public void inscribir(String apellido, String nombre, String telefono, String mail, Integer id_concurso)
			throws InfraestructuraException;
}
