package portsin;

import java.util.List;

public interface InscribirParticipante {
	
	public void saveInscription(ParticipanteRecordIn participante, ConcursoRecordIn concurso);
	public List<ConcursoRecordIn> todosLosConcursos();
}
