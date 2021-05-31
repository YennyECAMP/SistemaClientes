package servicio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import modelo.CategoriaEnum;
import modelo.Cliente;

public class ArchivoServicio extends Exportador {

public List<Cliente> cargarDatos(String fileName1) {
		
		String[] listaClientes;
		ArrayList<Cliente> listado = new ArrayList<Cliente>();
		//String filePath = "src/main/java/utilidades/";//ojo borrar esta línea antes de entregar
		System.out.println(fileName1);
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
				CategoriaEnum estado = CategoriaEnum.valueOf(listaClientes[4]);				
				listado.add(new Cliente(run, nombre, apellido, aniosint, estado));
			}
			System.out.println("Cargando datos...");
			System.out.println(listado);
			lector.close();
			}
		catch(Exception e){
			System.out.println("Error" + e.getMessage());
		}
		return listado;
	}
	
	@Override
	public void Exportar(String fileName, List<Cliente> listaClientes) {
		// TODO Auto-generated method stub
		
	}

}
