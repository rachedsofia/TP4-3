package main;

import data.JdbcLecturaConcursos;
import data.JdbcRegistroInscripcion;
import model.DefaultInscribirParticipante;
import ui.InscribirEnConcursoView;

public class Main {
	public static void main(String[] args) {

		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					new InscribirEnConcursoView(new DefaultInscribirParticipante(
							new JdbcRegistroInscripcion("jdbc:mysql://localhost:3306/tpleyers"),
							new JdbcLecturaConcursos("jdbc:mysql://localhost:3306/tpleyers")));

				} catch (Exception e) {
					throw new RuntimeException(e);
				}
			}
		});

	}
}