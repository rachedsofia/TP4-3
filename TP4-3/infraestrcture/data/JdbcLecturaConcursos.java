package data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import portsout.ConcursoRecord;
import portsout.InfraestructuraException;
import portsout.LecturaDeConcursos;

public class JdbcLecturaConcursos implements LecturaDeConcursos {

	private Conn connStr;
	private Statement stmt;
	private ResultSet rs;

	public JdbcLecturaConcursos(String connStr) {

		this.connStr = new Conn(connStr);
	}

	@Override
	public List<ConcursoRecord> consultarConcursos() throws InfraestructuraException {

		List<ConcursoRecord> concursosDisponibles = new ArrayList<ConcursoRecord>();
		try {
			Connection dbConn = this.connStr.open();

			String consulta = "select * from concurso";
			stmt = dbConn.createStatement();

			rs = stmt.executeQuery(consulta);

			while (rs.next()) {
				ConcursoRecord nuevo = new ConcursoRecord(rs.getString("id_concurso"), rs.getString("nombre"),
						rs.getString("fecha_inicio"), rs.getString("fecha_fin"));

				concursosDisponibles.add(nuevo);
			}
		} catch (SQLException e) {
			throw new InfraestructuraException(e, "Hubo un error en la consulta a la base.");
		} finally {
			try {
				stmt.close();
				rs.close();
			} catch (SQLException e1) {
				throw new InfraestructuraException(e1,
						"No se puedieron cerrar correctamente las concexiones de la base.");
			}

		}
		return concursosDisponibles;
	}
}