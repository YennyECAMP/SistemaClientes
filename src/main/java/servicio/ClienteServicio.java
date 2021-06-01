package servicio;

import java.util.ArrayList;
import java.util.List;

import modelo.CategoriaEnum;
import modelo.Cliente;
import utilidades.Utilidad;

//Clase ClienteServicio
public class ClienteServicio {
	
	//Atributos
	private List<Cliente> listaClientes;

	//Constructor
	public ClienteServicio() {
	}
	
	public ClienteServicio(List<Cliente> listaClientes) {
		this.listaClientes = new ArrayList<>();
	}

	//Métodos getters y setters
	public List<Cliente> getListaClientes() {
		return this.listaClientes;
	}

	public void setListaClientes(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}

	//Métodos particulares de la clase
	
	public void listarClientes() {
		//Método para listar en consola los clientes registrados
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
			}			
		} else {
			System.out.println( "No se han podido listar los clientes, aún no hay carga datos" );
		}
		Utilidad.stopAndContinue();		
	}
	
	public void agregarCliente(String runCliente, String nombreCliente, String apellidoCliente, int aniosCliente, CategoriaEnum estado) {
		//Método para ingresar nuevos clientes. la categoría será Activo al crearlo
		
		//if(!runCliente.isEmpty() && !apellidoCliente.isEmpty() && aniosCliente >=0 && estado != null) { //se condiciona que losc ampos no vengan null
			/*if(listaClientes.contains(runCliente)) {
				System.out.println("El cliente Existe");
			}*/
			Cliente cliente = new Cliente(runCliente, nombreCliente, apellidoCliente, aniosCliente, estado); //Se instancia y crea el cliente.
			if (listaClientes != null) {
				listaClientes.add(cliente);
				System.out.println("Registro insertado, " + cliente.toString());
			} else {
				System.out.println( "El Cliente el cual usted está agregando viene nulo");
			}
		/*}else {
			System.out.println( "Debe asignarle valores a todos los datos del Cliente ");
		}*/
	}

	public void editarCliente(Cliente cliente, String runCliente, String nombreCliente, String apellidoCliente, int aniosCliente, CategoriaEnum estado) {
		//método para editar datos del cliente
		
		if (!runCliente.isEmpty()) cliente.setRunCliente(runCliente);
		if (!nombreCliente.isEmpty()) cliente.setNombreCliente(nombreCliente);
		if (!apellidoCliente.isEmpty())cliente.setApellidoCliente(apellidoCliente);
		if (aniosCliente >= 0) cliente.setAniosCliente(aniosCliente);
		if (estado != null) cliente.setNombreCategoria(estado);
	}	


}
