package servicio;

import java.util.List;

import modelo.Cliente;

//Clase abstracta Exportador

public abstract class Exportador {

	public abstract void Exportar(String fileName, List<Cliente> listaClientes);

}
