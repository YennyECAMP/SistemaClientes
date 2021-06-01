package servicio;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import modelo.Cliente;

//Clase ExportadorTxt exporta a .txt hereda de Exportador
public class ExportadorTxt extends Exportador{

	@Override
	public void Exportar(String fileName, List<Cliente> listaClientes) {
		if (listaClientes == null) {
			System.out.println("La lista está vacía...");
		} else {	
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
				System.out.println("Datos de clientes exportados correctamente en formato txt.");
			} catch (IOException error) {
				System.out.println("El archivo no pudo ser creado en formato .txt");
			} finally {
				System.out.println("---------------------------------------");
			}	
		}
		
	}

}
