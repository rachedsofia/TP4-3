package data;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Objects;

import portsin.InscriptoRecord;
import portsin.RegistroInscripto;
import portsout.InfraestructuraException;

public class EnDiscoRegistroInscripcion implements RegistroInscripto {
	private String ruta;

	public EnDiscoRegistroInscripcion(String ruta) {
		Objects.requireNonNull(ruta);

		this.ruta = ruta;
	}

	@Override
	public void registrar(InscriptoRecord inscripto) throws InfraestructuraException {

		String nuevaInscripcion = inscripto.apellido() + ", " + inscripto.nombre() + ", " + inscripto.telefono() + ", "
				+ inscripto.email() + ", " + inscripto.idConcurso();

		try {
			Files.write(Paths.get(ruta), nuevaInscripcion.getBytes(), StandardOpenOption.APPEND);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}
