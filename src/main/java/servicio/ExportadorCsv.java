package servicio;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import modelo.Cliente;

public class ExportadorCsv extends Exportador {

	@Override
	public void Exportar(String fileName, List<Cliente> listaClientes) {
		File fl = new File(fileName);
		if (fl.exists()) {
			fl.delete();
		}
		try {
			PrintWriter pWriter = new PrintWriter(new FileWriter(fileName));
			listaClientes.forEach(cliente -> {
				pWriter.append(cliente.toString()).append(System.lineSeparator());
			});
			pWriter.close();
			System.out.println("Datos de clientes exportados correctamente en formato csv.");
		} catch (IOException error) {
			System.out.println("El archivo no pudo ser creado en formato .csv");
		} finally {
			System.out.println("---------------------------------------");
		}
		
	}

}
