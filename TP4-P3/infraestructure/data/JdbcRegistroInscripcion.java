package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import portsin.InscriptoRecord;
import portsin.RegistroInscripto;
import portsout.InfraestructuraException;

public class JdbcRegistroInscripcion implements RegistroInscripto {

	private Conn connStr;
	private PreparedStatement st;

	public JdbcRegistroInscripcion(String connStr) {

		this.connStr = new Conn(connStr);
	}

	@Override
	public void registrar(InscriptoRecord inscripto) throws InfraestructuraException {
		try {
			Connection dbConn = this.connStr.open();

			st = dbConn.prepareStatement(
					"insert into inscriptos(apellido, nombre, telefono, mail, id_concurso) values (?,?,?,?,?)");
			st.setString(1, inscripto.apellido());
			st.setString(2, inscripto.nombre());
			st.setString(3, inscripto.telefono());
			st.setString(4, inscripto.email());
			st.setInt(5, inscripto.idConcurso());

		} catch (SQLException e) {
			throw new InfraestructuraException(e, "No ha podido registrarse el participante.");
		} finally {
			try {
				st.executeUpdate();
				st.close();
			} catch (SQLException e1) {
				throw new InfraestructuraException(e1,
						"No se puedieron cerrar correctamente las concexiones de la base.");
			}
		}
	}

}
