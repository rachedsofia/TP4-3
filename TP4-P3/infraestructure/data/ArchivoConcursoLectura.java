package data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import portsout.ConcursoRecord;
import portsout.Lectura;

public class ArchivoConcursoLectura implements Lectura {
	private String archivo;

	public ArchivoConcursoLectura(String nombreArchivo) {
		Objects.requireNonNull(nombreArchivo);

		if (nombreArchivo.isEmpty() || nombreArchivo.isBlank()) {
			throw new RuntimeException("El nombre del archivo no puede estar vacio");
		}

		this.archivo = nombreArchivo;
	}

	@Override
	public List<ConcursoRecord> leer() {
		List<ConcursoRecord> lista = new ArrayList<>();

		try {
			BufferedReader bufferReader = new BufferedReader(new FileReader(this.archivo));

			String cadena;

			while ((cadena = bufferReader.readLine()) != null) {
				String[] atributos = cadena.split(",");

				int id = Integer.parseInt(atributos[0]);
				String nombre = atributos[1];
				String fechaInicioInscripcion = atributos[2];
				String fechaCierreInscripcion = atributos[3];

				ConcursoRecord concurso = new ConcursoRecord(id, nombre, fechaInicioInscripcion,
						fechaCierreInscripcion);
				lista.add(concurso);
			}

			bufferReader.close();

		} catch (IOException e) {

		}

		return lista;

	}

	@Override
	public List<ConcursoRecord> devolverConcursosVigentes() {
		List<ConcursoRecord> listaConcursos = this.leer();

		List<ConcursoRecord> listaConcursosVigentes = new ArrayList<>();
		LocalDate fechaDeHoy = LocalDate.now();

		for (ConcursoRecord concursoRecord : listaConcursos) {
			if (fechaDeHoy.isAfter(LocalDate.parse(concursoRecord.inicioInscripcion()))) {

			}
		}

		return listaConcursosVigentes;
	}

}
