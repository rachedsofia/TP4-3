package portsin;

import portsout.InfraestructuraException;

public interface RegistroInscripto {
	public void registrar(InscriptoRecord inscripto) throws InfraestructuraException;

	public void inscribir(String apellido, String nombre, String telefono, String mail, int obtenerId);
}
