package vista;


import java.util.ArrayList;
//import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import modelo.CategoriaEnum;
import modelo.Cliente;
import servicio.ArchivoServicio;
import servicio.ClienteServicio;
import utilidades.Utilidad;

public class Menu {

	ClienteServicio clienteServicio = new ClienteServicio(new ArrayList<>());
		
	String fileName = "Clientes";
	String fileName1 = "DBClientes.csv";
	Scanner sc = new Scanner(System.in);

	public void iniciarMenu() {
		List<String> opcionesMenu = new ArrayList<String>();
		opcionesMenu.add("Listar Clientes");
		opcionesMenu.add("Agregar Cliente");
		opcionesMenu.add("Editar Cliente");
		opcionesMenu.add("Cargar Datos");
		opcionesMenu.add("Exportar Datos");
		opcionesMenu.add("Salir");
		Menu menu = new Menu();
		menu.seleccionOpcion(opcionesMenu);
	}

	protected int construirMenu(List<String> pOpcionesMenu) {
		List<String> opcionesMenu = pOpcionesMenu;
		int largo = opcionesMenu.size();
		for (int i = 0; i < largo; i++) {
			System.out.println((i + 1) + ". " + opcionesMenu.get(i));
		}
		int opcion = 0;
		System.out.println("Ingrese una opción:");
		try {
			opcion = sc.nextInt();
		} catch (Exception error) {
			sc.nextLine();
		}
		if (opcion < 1 || opcion >= largo + 1) {
			System.out.println("Selección no permitida");
		}
		return opcion;
	}

	public void seleccionOpcion(List<String> pOpcionesMenu) {
		boolean salir = false;
		int resultado;
		do {
			resultado = construirMenu(pOpcionesMenu);
			switch (resultado) {

			case 1:
				listarCliente();

				break;
			case 2:
				agregarCliente();
				break;
			case 3:
				editarCliente();
				break;
			case 4:	
				ArchivoServicio archivoServicio = new ArchivoServicio();
				archivoServicio.cargarDatos(fileName1);
				break;
			case 5:
				//ExportadorCsv.exportarDatos(fileName);
				break;
			case 6:
				terminarPrograma();
				break;
			default:
				System.out.println("Ingresar números del  1 al 6 solamente");		
			}
			} while (!salir);
		}

	private void terminarPrograma() {
		System.out.println("Abandonando el sistema de clientes...");
		Utilidad.timeToWait();
		System.out.println("Acaba de salir del sistema");
		Utilidad.stopAndContinue();
		System.exit(0);
	}
	
	private void listarCliente() {
		clienteServicio.listarClientes();
		//System.out.println("Pulse cualquier tecla para continuar...");
		//String espera=sc.nextLine();	
	}
	
	private void agregarCliente() {
		System.out.println( "-------------Crear Cliente-------------");
		System.out.println();
		sc.nextLine();
		System.out.println( "Ingresa RUN del Cliente:" );
		String runCli = sc.nextLine();
		System.out.println( "Ingresa Nombre del Cliente:" );
		String nombCli = sc.nextLine();
		System.out.println( "Ingresa Apellido del Cliente:" );
		String ApeCli = sc.nextLine();
		System.out.println( "Ingresa Años del Cliente:" );
		/*try {//ojo controlar año numerico
			
						
		}catch(Exception e) {
			System.out.println("Error: El año del cliente debe ser numérico");
			System.out.println();			
		}*/
		int anioCli = sc.nextInt();
		clienteServicio.agregarCliente(runCli, nombCli, ApeCli, anioCli);
		Utilidad.stopAndContinue();
	}
	
	private void editarCliente() {
		int control = 0;
		
		subMenuEditar();
		int opcionEdicion = sc.nextInt();
		sc.nextLine();
		System.out.println("Ingrese RUN del Cliente a editar:");
		String runCli = sc.nextLine();
		List<Cliente> listaClientes = clienteServicio.getListaClientes();
		if (listaClientes != null) {
			for (Cliente cliente : listaClientes) {
				control = 1;
				if (cliente.getRunCliente().equals(runCli)){
					if (opcionEdicion == 1) {	//cambia estado del cliente
						subMenuEditarEstadoCliente(cliente);
						int opcionEdicion2 = sc.nextInt();
						sc.nextLine();
						if (opcionEdicion2 == 1) {							
							//clienteServicio.editarCategoria(CategoriaEnum.Inactivo);
							cliente.setNombreCategoria( ((cliente.getNombreCategoria() == CategoriaEnum.Activo) ? CategoriaEnum.Inactivo : CategoriaEnum.Activo));
							System.out.println("Estado del Cliente actualizado");
							Utilidad.stopAndContinue();
						}else {
							System.out.println("No hay cambios para el cliente");
							Utilidad.stopAndContinue();
						}					
					}else {						//cambia datos del cliente
						actualizarDatosCliente(cliente);
					}
				}else {
					//System.out.println("Cliente no existe. Imposible editar");
					//Utilidad.stopAndContinue();
					control = 0;
				}
			}
			if (control == 0) {
				System.out.println("Cliente no existe. Imposible editar");
				Utilidad.stopAndContinue();
			}
		}else {
			System.out.println("Cliente no registrado. Imposible editar");
			Utilidad.stopAndContinue();
		}	
	}
	
	private void subMenuEditar() {
		System.out.println();
		System.out.println("-------------Editar Cliente-------------");
		System.out.println("Seleccione que desea hacer:");
		System.out.println("1.-Cambiar el estado del Cliente");
		System.out.println("2.-Editar los datos ingresados del Cliente");
		System.out.println("Ingrese una opción:");
		System.out.println("----------------------------------------");
	}
	
	private void subMenuEditarEstadoCliente(Cliente cliente) {
		System.out.println();
		System.out.println("-----Actualizando estado del Cliente----");
		System.out.println("El estado actual es:" + cliente.getNombreCategoria());
		System.out.println("1.-Si desea cambiar el estado del Cliente a " + ((cliente.getNombreCategoria() == CategoriaEnum.Activo) ? CategoriaEnum.Inactivo : CategoriaEnum.Activo) );
		System.out.println("2.-Si desea mantener el estado del cliente " + cliente.getNombreCategoria());
		System.out.println();
		System.out.println("Ingrese una opción:");
		System.out.println("----------------------------------------");	
	}	
	
	private void actualizarDatosCliente(Cliente cliente) {
		System.out.println("----Actualizando datos del Cliente-----");
		System.out.println();
		System.out.println("1.-El RUN del Cliente es: " + cliente.getRunCliente());
		System.out.println("2.-El Nombre del Cliente es: " + cliente.getNombreCliente());
		System.out.println("3.-El Apellido del Cliente es: " + cliente.getApellidoCliente());
		System.out.println("4.-Los años como Cliente son: " + cliente.getAniosCliente());
		
		System.out.println("Ingrese opcion a editar de los datos del cliente: ");
		
		int opcionCliente = sc.nextInt();
		
		sc.nextLine();
		System.out.println("----------------------------------------");

		switch (opcionCliente) {
		case 1:
			System.out.println("1.-Ingrese el nuevo RUN del Cliente: ");
			String runCli = sc.nextLine();
			cliente.setRunCliente(runCli);
			System.out.println("----------------------------------------");
			System.out.println("Datos cambiados con éxito");
			break;	
		case 2:
			System.out.println("2.-Ingrese el nuevo NOMBRE del Cliente: ");
			String nombCli = sc.nextLine();
			cliente.setNombreCliente(nombCli);		
			System.out.println("----------------------------------------");
			System.out.println("Datos cambiados con éxito");
			break;
		case 3:
			System.out.println("3.-Ingrese el nuevo APELLIDO del Cliente: ");
			String apeCli = sc.nextLine();
			cliente.setApellidoCliente(apeCli);
			System.out.println("----------------------------------------");
			System.out.println("Datos cambiados con éxito");
			break;
		case 4:
			System.out.println("4.-Ingrese el nuevo AÑO del Cliente: ");
			int anioCli = sc.nextInt();
			cliente.setAniosCliente(anioCli);	
			System.out.println("----------------------------------------");
			System.out.println("Datos cambiados con éxito");
			break;
		default:
				System.out.println("Usted marco una opción incorrecta");
		}
		Utilidad.stopAndContinue();
	}
	
	private void importarDatos() {
		
	}
	
	private void exportarDatos() {
		//ojo controlar que existan clientes a exportar
	}
	
}
