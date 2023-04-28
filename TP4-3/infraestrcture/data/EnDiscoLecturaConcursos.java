package data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import portsout.ConcursoRecord;
import portsout.InfraestructuraException;
import portsout.LecturaDeConcursos;

public class EnDiscoLecturaConcursos implements LecturaDeConcursos {

	private FileReader lector;
	private BufferedReader buffer;
	private String rutaArchivo;

	public EnDiscoLecturaConcursos(String rutaArchivo) {

		Objects.requireNonNull(rutaArchivo);

		this.rutaArchivo = rutaArchivo;

	}

	@Override
	public List<ConcursoRecord> consultarConcursos() throws InfraestructuraException {

		List<ConcursoRecord> concursosDisponibles = new ArrayList<ConcursoRecord>();
		try {
			File archivo = new File(rutaArchivo);
			lector = new FileReader(archivo);
			buffer = new BufferedReader(lector);
			String linea;

			while ((linea = buffer.readLine()) != null) {
				String[] partes = linea.split("\\, ");

				concursosDisponibles.add(new ConcursoRecord(partes[0], partes[1], partes[2], partes[3]));
			}
		} catch (IOException e) {
			throw new InfraestructuraException(e, "Hubo un error al abrir el archivo de concursos.");
		} finally {

			try {
				buffer.close();
				lector.close();
			} catch (IOException e) {
				throw new InfraestructuraException(e, "Error al cerrar el archivo de concursos");
			}

		}

		return concursosDisponibles;
	}
}
