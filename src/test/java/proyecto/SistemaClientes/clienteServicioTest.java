package proyecto.SistemaClientes;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.logging.Logger;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import modelo.CategoriaEnum;
import modelo.Cliente;
import servicio.ClienteServicio;

//@DisplayName("Tests Clase ClienteServicio")
public class clienteServicioTest {
	
	private ClienteServicio clienteServicio = mock(ClienteServicio.class);
	
	@Test
	public void agrearClienteTest() {
		Cliente pepe = new Cliente("1","Pepe","Perez",5,CategoriaEnum.Activo);
		ClienteServicio clienteServicio = new ClienteServicio("1","Pepe","Perez",5);
		when(clienteServicio.agregarCliente(clienteServicio)).thenReturn("OK");
		String crearPersonaRes = clienteServicio.agregarCliente(clienteServicio);
		assertEquals("OK", crearPersonaRes);
		verify(clienteServicio).agregarCliente("1","Pepe","Perez",5);
	}

	@Test
	public void agrearClienteNullTest() {

	}
}
