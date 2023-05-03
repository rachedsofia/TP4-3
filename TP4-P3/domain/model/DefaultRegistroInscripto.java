package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import portsin.ConcursoRecordIn;
import portsin.InscribirParticipante;
import portsin.ParticipanteRecordIn;
import portsin.RegistroInscripto;
import portsout.ConcursoRecord;
import portsout.InfraestructuraException;
import portsout.LecturaDeConcursos;

public class DefaultRegistroInscripto implements InscribirParticipante {

	private List<ConcursoRecordIn> listaConcursoRecord;
	private RegistroInscripto direccion;
	private LecturaDeConcursos direccionDeConcursosAlmacenados;

	public DefaultRegistroInscripto(RegistroInscripto direccion, LecturaDeConcursos direccionDeConcursosAlmacenados) {

		Objects.requireNonNull(direccion);
		this.direccion = direccion;
		this.direccionDeConcursosAlmacenados = direccionDeConcursosAlmacenados;
		this.listaConcursoRecord = new ArrayList<ConcursoRecordIn>();
	}

	@Override
	public void saveInscription(ParticipanteRecordIn participante, ConcursoRecordIn concurso) {

		Participante nuevo = new Participante(participante.apellido(), participante.nombre(), participante.dni(),
				participante.telefono(), participante.mail(), concurso.idConcurso());

		Concurso seleccionado = new Concurso(concurso.idConcurso(), concurso.nombre(),
				concurso.fechaInicioInscripcion(), concurso.fechaFinInscripcion());

		direccion.inscribir(nuevo.getApellido(), nuevo.getNombre(), nuevo.getTelefono(), nuevo.getMail(),
				seleccionado.obtenerId());

	}

	@Override
	public List<ConcursoRecordIn> todosLosConcursos() {

		List<ConcursoRecord> disponibles = new ArrayList<ConcursoRecord>();

		try {

			disponibles = direccionDeConcursosAlmacenados.consultarConcursos();
			cargarConcursosDisponibles(disponibles);

		} catch (InfraestructuraException e) {
			throw new RuntimeException("Hubo problemas con el archivo de concursos");
		}

		return listaConcursoRecord;
	}

	private void cargarConcursosDisponibles(List<ConcursoRecord> disponibles) {

		for (ConcursoRecord record : disponibles) {
			ConcursoRecordIn concurso = new ConcursoRecordIn(String.valueOf(record.id()), record.nombre(),
					record.inicioInscripcion(), record.cierreInscripcion());
			if (validarFechasDeConcurso(concurso))
				listaConcursoRecord.add(concurso);
		}

	}

	private boolean validarFechasDeConcurso(ConcursoRecordIn concurso) {
		LocalDate fechaApertura = LocalDate.parse(concurso.fechaInicioInscripcion(),
				DateTimeFormatter.ofPattern("yyyy/MM/dd"));
		LocalDate fechaCierre = LocalDate.parse(concurso.fechaFinInscripcion(),
				DateTimeFormatter.ofPattern("yyyy/MM/dd"));
		LocalDate fechaActual = LocalDate.now();

		return (fechaActual.isAfter(fechaApertura) && fechaActual.isBefore(fechaCierre));

	}
}
