package portsin;

import portsout.InfraestructuraException;

public interface RegistroInscripto {
	public void registrar(InscriptoRecord inscripto) throws InfraestructuraException;
}
