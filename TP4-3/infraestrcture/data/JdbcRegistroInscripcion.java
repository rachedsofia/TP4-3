package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import portsout.InfraestructuraException;
import portsout.RegistroInscripcion;

public class JdbcRegistroInscripcion implements RegistroInscripcion {

	private Conn connStr;
	private PreparedStatement st;

	public JdbcRegistroInscripcion(String connStr) {

		this.connStr = new Conn(connStr);
	}

	@Override
	public void inscribir(String apellido, String nombre, String telefono, String mail, Integer id_concurso)
			throws InfraestructuraException {
		try {
			Connection dbConn = this.connStr.open();

			st = dbConn.prepareStatement(
					"insert into inscriptos(apellido, nombre, telefono, mail, id_concurso) values (?,?,?,?,?)");
			st.setString(1, apellido);
			st.setString(2, nombre);
			st.setString(3, telefono);
			st.setString(4, mail);
			st.setInt(5, id_concurso);

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
