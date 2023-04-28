package portsout;

import java.util.List;

public interface LecturaDeConcursos {

	public List<ConcursoRecord> consultarConcursos() throws InfraestructuraException;

}
