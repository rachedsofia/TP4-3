package model;

import java.util.Objects;

import portsin.InscriptoRecord;
import portsin.RegistroInscripto;
import portsout.Lectura;
import portsout.Registro;

public class DefaultRegistroInscripto implements RegistroInscripto {
	private Lectura lectura;
	private Registro registro;

	public DefaultRegistroInscripto(Lectura lectura, Registro registro) {
		Objects.requireNonNull(lectura);
		Objects.requireNonNull(registro);

		this.lectura = lectura;
		this.registro = registro;
	}

	@Override
	public void registrar(InscriptoRecord inscripto) {
		// TODO Auto-generated method stub

	}

}
