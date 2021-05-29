package servicio;

import java.util.ArrayList;
import modelo.CategoriaEnum;
import modelo.Cliente;
import utilidades.Utilidad;

public class ClienteServicio {
	//Atributos
	private ArrayList<Cliente> listaClientes;

	//Constructor
	public ClienteServicio() {
	}
	
	public ClienteServicio(ArrayList<Cliente> listaClientes) {
		this.listaClientes = new ArrayList<>();
	}

	//Métodos getters y setters
	public ArrayList<Cliente> getListaClientes() {
		return this.listaClientes;
	}

	public void setListaClientes(ArrayList<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}

	//Métodos particulares de la clase
	public void listarClientes() {
		int control = 0;
		if (listaClientes != null) {
			for (Cliente cliente : listaClientes) {
				control = 1;
				System.out.println( "-------------Datos del Cliente-------------" );
				System.out.println( "Run del Cliente: " + cliente.getRunCliente());
				System.out.println( "Nombre del Cliente: " + cliente.getNombreCliente());
				System.out.println( "Apellido del Cliente: " + cliente.getApellidoCliente());
				System.out.println( "Años del Cliente: " + cliente.getAniosCliente());
				System.out.println( "Categoría del Cliente: " + cliente.getNombreCategoria());					
				System.out.println( "-------------------------------------------" );
			}
			if (control == 0) {
				System.out.println("No hay clientes a listar");
				//Utilidad.stopAndContinue();
			}			
		} else {
			System.out.println( "No se han podido listar los clientes, aún no hay carga datos" );
		}
		Utilidad.stopAndContinue();		
	}
	
	public void agregarCliente(String runCliente, String nombreCliente, String apellidoCliente, int aniosCliente) {
		//Se instancia y crea el cliente, la categoría será Activo al crearlo
		Cliente cliente = new Cliente(runCliente, nombreCliente, apellidoCliente, aniosCliente, CategoriaEnum.Activo);
		if (listaClientes != null) {
			listaClientes.add(cliente);
			System.out.println("Registro insertado " + cliente.toString());
		} else {
			System.out.println( "El Cliente el cual usted está agregando viene nulo");
		}
	}
	
	public void editarCliente(String runCliente, String nombreCliente, String apellidoCliente, int aniosCliente, CategoriaEnum nombreCategoria) {
		

	}
	
	/*public void editarCategoria(CategoriaEnum nombreCategoria) {
		

	}*/	


}
