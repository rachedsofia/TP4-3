package portsout;

import java.util.List;

public interface Lectura {
	public List<ConcursoRecord> leer();
	public List<ConcursoRecord> devolverConcursosVigentes();
}
