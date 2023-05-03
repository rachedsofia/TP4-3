package data;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

import portsout.Registro;

public class ArchivoRegistro implements Registro {
	private File archivo;
	private FileWriter escritura;
	private PrintWriter linea;

	public ArchivoRegistro(String nombreArchivo) {
		Objects.requireNonNull(nombreArchivo);

		if (nombreArchivo.isEmpty() || nombreArchivo.isBlank()) {
			throw new RuntimeException("El nombre ingresado del archivo esta vacio");
		}

		this.archivo = new File(nombreArchivo);
	}

	@Override
	public void registrar(String cadena) {
		if (this.archivo.exists()) {
			try {
				this.escritura = new FileWriter(archivo, true);
				this.linea = new PrintWriter(this.escritura);
				this.linea.println(cadena);
				this.escritura.close();
				this.linea.close();
			} catch (IOException e) {
			}
		} else {
			try {
				this.archivo.createNewFile();
				this.escritura = new FileWriter(archivo, true);
				this.linea = new PrintWriter(this.escritura);
				this.linea.println(cadena);
				this.escritura.close();
				this.linea.close();
			} catch (IOException e) {
			}
		}

	}

}
