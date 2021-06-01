package servicio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import modelo.CategoriaEnum;
import modelo.Cliente;

//Clase ArchivoServicio hereda de Exportador
public class ArchivoServicio extends Exportador {

public void cargarDatos(String fileName1, ClienteServicio clienteServicio) {
		//método para importar datos desde el archivo .csv
		String[] listaClientes;
		ArrayList<Cliente> listado = new ArrayList<Cliente>();		
		
		File fichero = new File(fileName1); 
		String dato;
		
		try {
			BufferedReader lector = new BufferedReader(new FileReader(fichero));
			while((dato = lector.readLine()) != null){
				listaClientes = dato.split(",");
				String run = listaClientes[0];
				String nombre = listaClientes[1];
				String apellido = listaClientes[2];
				String anioschar = listaClientes[3];
				int aniosint = Character.getNumericValue(anioschar.charAt(0));
				CategoriaEnum estado = CategoriaEnum.valueOf(listaClientes[4].toUpperCase());		
				
				clienteServicio.agregarCliente(run, nombre, apellido, aniosint, estado); 
				
				listado.add(new Cliente(run, nombre, apellido, aniosint, estado));
			}
			System.out.println("Cargando datos...");
			lector.close();
			}
		catch(Exception e){
			System.out.println("Error" + e.getMessage());
		}

	}
	
	@Override
	public void Exportar(String fileName, List<Cliente> listaClientes) {
		// TODO Auto-generated method stub
		
	}

}
