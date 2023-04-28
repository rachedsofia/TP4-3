package data;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Objects;

import portsout.RegistroInscripcion;

public class EnDiscoRegistroInscripcion implements RegistroInscripcion {
	private String ruta;

	public EnDiscoRegistroInscripcion(String ruta) {
		Objects.requireNonNull(ruta);

		this.ruta = ruta;
	}

	@Override
	public void inscribir(String apellido, String nombre, String telefono, String mail, Integer id_concurso) {

		String nuevaInscripcion = apellido + ", " + nombre + ", " + telefono + ", " + mail + ", " + id_concurso;

		try {
			Files.write(Paths.get(ruta), nuevaInscripcion.getBytes(), StandardOpenOption.APPEND);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}
