package proyecto.SistemaClientes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.logging.Logger;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;

import modelo.CategoriaEnum;
import modelo.Cliente;
import servicio.ClienteServicio;

//@DisplayName("Tests Clase ClienteServicio")
public class clienteServicioTest {

	@BeforeAll
	public void inicioTest() {
		
	}

	@Test
	public void agrearClienteTest() {
		ClienteServicio clienteServicio = new ClienteServicio(new ArrayList<Cliente>());		
		clienteServicio.agregarCliente("1","Pepe","Perez",5,CategoriaEnum.ACTIVO);
		assertEquals(clienteServicio.getListaClientes().get(0).getNombreCliente(), "Pepe");		
	}

    @Test
    public void agrearClienteNullTest() {
        ClienteServicio clienteServicio = new ClienteServicio(new ArrayList<Cliente>()); 
        String rut = "";
        String nombre = "";
        String apellido = "";
        int anios = 0;
        CategoriaEnum estado = null;
        
        clienteServicio.agregarCliente(rut, nombre, apellido, anios, estado);
        String nombreCliente = clienteServicio.getListaClientes().get(0).getNombreCliente();
        System.out.println(nombreCliente);
        assertNull(nombreCliente, null);    
    }
    
	/*@Test
	public void agrearClienteNullTest() {
		ClienteServicio clienteServicio = new ClienteServicio(new ArrayList<Cliente>());		
		clienteServicio.agregarCliente(null,null,null,-1,null);
		System.out.println(clienteServicio.getListaClientes().get(0).getNombreCliente());
		assertNull(clienteServicio.getListaClientes().get(0).getNombreCliente(), null);	
	}*/
}
