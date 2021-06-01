package vista;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import modelo.CategoriaEnum;
import modelo.Cliente;
import servicio.ArchivoServicio;
import servicio.ClienteServicio;
import servicio.ExportadorCsv;
import servicio.ExportadorTxt;
import utilidades.Utilidad;

public class Menu {

	ClienteServicio clienteServicio = new ClienteServicio(new ArrayList<>());
		
	String fileName = "Clientes";
	String fileName1 = "DBClientes.csv";
	Scanner sc = new Scanner(System.in);

	public void iniciarMenu() {	//Lista el menú principal
		List<String> opcionesMenu = new ArrayList<String>();
		opcionesMenu.add("Listar Clientes");
		opcionesMenu.add("Agregar Cliente");
		opcionesMenu.add("Editar Cliente");
		opcionesMenu.add("Cargar Datos");
		opcionesMenu.add("Exportar Datos");
		opcionesMenu.add("Salir");
		Menu menu = new Menu();
		menu.seleccionarOpcion(opcionesMenu);
	}

	protected int crearMenu(List<String> pOpcionesMenu) { //Despliega el menú ppal. en la consola y devuelve la selección del usuario
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

	public void seleccionarOpcion(List<String> pOpcionesMenu) { //selecciona la opcíon solicitada por el usuario
		boolean salir = false;
		int resultado;
		do {
			resultado = crearMenu(pOpcionesMenu);
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
				importarDatos();
				break;
			case 5:
				exportarDatos();
				break;
			case 6:
				terminarPrograma();
				break;
			default:
				System.out.println("Ingresar números del  1 al 6 solamente");		
			}
			} while (!salir);
		}

	private void terminarPrograma() {	//Salida del sistema
		System.out.println("Abandonando el sistema de clientes...");
		Utilidad.timeToWait();
		System.out.println("Acaba de salir del sistema");
		System.out.println("Somos los mejores!!! Equipo 2:  Linda, Yenny y Anibal :)");
		Utilidad.stopAndContinue();
		System.exit(0);
	}
	
	private void listarCliente() { //llama al método para listar los clientes
		clienteServicio.listarClientes();
	}
	
	private void agregarCliente() { //llama al método agregarCliente pasándo los datos a crear del cliente
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

		try {
			int anioCli = Integer.parseInt(sc.next());
			clienteServicio.agregarCliente(runCli, nombCli, ApeCli, anioCli, CategoriaEnum.ACTIVO);

		}catch(Exception e) {
			System.out.println("Error: Años del cliente debe ser numérico");
			System.out.println();           
		}

		Utilidad.stopAndContinue();
	}
	
	private void editarCliente() { //llama método para modificar clientes
		int control = 0;
		
		subMenuEditar();
		int opcionEdicion = sc.nextInt();
		sc.nextLine();
		System.out.println("Ingrese RUN del Cliente a editar:");
		String runCli = sc.nextLine();
		List<Cliente> listaClientes = clienteServicio.getListaClientes();
		if (listaClientes != null) {
			for (Cliente cliente : listaClientes) {				
				if (cliente.getRunCliente().equals(runCli)){
					control = 1;
					if (opcionEdicion == 1) {	//cambia estado del cliente
						subMenuEditarEstadoCliente(cliente);
						int opcionEdicion2 = sc.nextInt();
						sc.nextLine();
						if (opcionEdicion2 == 1) {							
							CategoriaEnum estado = ((cliente.getNombreCategoria() == CategoriaEnum.ACTIVO) ? CategoriaEnum.INACTIVO : CategoriaEnum.ACTIVO);							
							clienteServicio.editarCliente(cliente, "", "", "", -1,estado);
							System.out.println("Estado del Cliente actualizado");
							estado = null;
							Utilidad.stopAndContinue();
						}else {
							System.out.println("No hay cambios para el cliente");
							Utilidad.stopAndContinue();
						}					
					}else {						//cambia datos del cliente
						actualizarDatosCliente(cliente);
					}
				//}else {
					//control = 0;
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
	
	private void subMenuEditar() { //subMenú de la opción Editar datos del Cliente
		System.out.println();
		System.out.println("-------------Editar Cliente-------------");
		System.out.println("Seleccione que desea hacer:");
		System.out.println("1.-Cambiar el estado del Cliente");
		System.out.println("2.-Editar los datos ingresados del Cliente");
		System.out.println("Ingrese una opción:");
		System.out.println("----------------------------------------");
	}
	
	private void subMenuEditarEstadoCliente(Cliente cliente) { //sunMenú de la opción editar Estado del Cliente
		System.out.println();
		System.out.println("-----Actualizando estado del Cliente----");
		System.out.println("El estado actual es:" + cliente.getNombreCategoria());
		System.out.println("1.-Si desea cambiar el estado del Cliente a " + ((cliente.getNombreCategoria() == CategoriaEnum.ACTIVO) ? CategoriaEnum.INACTIVO : CategoriaEnum.ACTIVO) );
		System.out.println("2.-Si desea mantener el estado del cliente " + cliente.getNombreCategoria());
		System.out.println();
		System.out.println("Ingrese una opción:");
		System.out.println("----------------------------------------");	
	}	
	
	private void actualizarDatosCliente(Cliente cliente) { //método para actualizar Cliente
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
			clienteServicio.editarCliente(cliente, runCli, "", "", -1, null);
			System.out.println("----------------------------------------");
			System.out.println("Datos cambiados con éxito");
			runCli="";
			break;	
		case 2:
			System.out.println("2.-Ingrese el nuevo NOMBRE del Cliente: ");
			String nombCli = sc.nextLine();
			clienteServicio.editarCliente(cliente, "", nombCli, "", 0,null);		
			System.out.println("----------------------------------------");
			System.out.println("Datos cambiados con éxito");
			nombCli="";
			break;
		case 3:
			System.out.println("3.-Ingrese el nuevo APELLIDO del Cliente: ");
			String apeCli = sc.nextLine();
			clienteServicio.editarCliente(cliente, "", "", apeCli, 0,null);
			System.out.println("----------------------------------------");
			System.out.println("Datos cambiados con éxito");
			apeCli="";
			break;
		case 4:
			System.out.println("4.-Ingrese el nuevo AÑO del Cliente: ");
			int anioCli = sc.nextInt();
			
			if (anioCli>=0) {
				clienteServicio.editarCliente(cliente, "", "", "", anioCli,null);	
			}else {
				System.out.println("El año debe ser numérico");
			}
			
			System.out.println("----------------------------------------");
			System.out.println("Datos cambiados con éxito");
			anioCli=-1;
			break;
		default:
			System.out.println("Usted marco una opción incorrecta");
		}
		Utilidad.stopAndContinue();
	}
	
	private void importarDatos() { //llama al método para cargar datos
		System.out.println("---------Cargar Datos en Windows---------------");
		System.out.println();
		System.out.println("Ingresa la ruta en donde se encuentra el archivo DBClientes.csv:");
		sc.nextLine();
		String rutaDir = sc.nextLine();		

		System.out.println("----------------------------------------");
		ArchivoServicio archivoServicio = new ArchivoServicio();
		archivoServicio.cargarDatos(rutaDir + "/" + fileName1, clienteServicio);
		System.out.println("Datos cargados correctamente en la lista");
		Utilidad.stopAndContinue();
	}
	
	private void exportarDatos() { //llama al método para exportar datos
		//ojo controlar que existan clientes a exportar
		System.out.println("---------Exportar Datos-----------");
		System.out.println("Seleccione el formato a exportar:");
		System.out.println("1.-Formato csv");
		System.out.println("2.-Formato txt");
		System.out.println();
		System.out.println("Ingrese una opción para exportar:");
		sc.nextLine();
		int opcionExportar = sc.nextInt();		
		
		System.out.println();
		System.out.println("---------Exportar Datos en Windows---------------");
		
		String rutaDir;
		switch (opcionExportar) {
		case 1://csv
			System.out.println("Ingresa la ruta en donde desea exportar el archivo clientes.csv:");
			sc.nextLine();
			rutaDir = sc.nextLine();
			ExportadorCsv exportarCsv = new ExportadorCsv();
			exportarCsv.Exportar(rutaDir + "/" + "clientes.csv", clienteServicio.getListaClientes());
			break;	
		case 2://txt
			System.out.println("Ingresa la ruta en donde desea exportar el archivo clientes.txt:");
			sc.nextLine();
			rutaDir = sc.nextLine();
			ExportadorTxt exportarTxt = new ExportadorTxt();
			exportarTxt.Exportar(rutaDir + "/" + "clientes.txt", clienteServicio.getListaClientes());
			break;		
		default:
			System.out.println("Usted marco una opción incorrecta");
		}
		Utilidad.stopAndContinue();
	}
	
}
