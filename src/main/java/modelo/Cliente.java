package modelo;

//Clase Cliente

public class Cliente {
	//Atributos
	private String runCliente;
	private String nombreCliente;
	private String apellidoCliente;
	private int aniosCliente;
	private CategoriaEnum nombreCategoria;
	
	//Constructores
	public Cliente() {
	}
	
	public Cliente(String runCliente, String nombreCliente, String apellidoCliente, int aniosCliente,
			CategoriaEnum nombreCategoria) {
		this.runCliente = runCliente;
		this.nombreCliente = nombreCliente;
		this.apellidoCliente = apellidoCliente;
		this.aniosCliente = aniosCliente;
		this.nombreCategoria = nombreCategoria;
	}
	
	public String getRunCliente() {
		return this.runCliente;
	}
	
	public void setRunCliente(String runCliente) {
		this.runCliente = runCliente;
	}
	
	public String getNombreCliente() {
		return this.nombreCliente;
	}
	
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	
	public String getApellidoCliente() {
		return this.apellidoCliente;
	}
	
	public void setApellidoCliente(String apellidoCliente) {
		this.apellidoCliente = apellidoCliente;
	}
	
	public int getAniosCliente() {
		return this.aniosCliente;
	}
	
	public void setAniosCliente(int aniosCliente) {
		this.aniosCliente = aniosCliente;
	}
	
	public CategoriaEnum getNombreCategoria() {
		return this.nombreCategoria;
	}
	
	public void setNombreCategoria(CategoriaEnum nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}

	//Método toString
	@Override
	public String toString() {
		return "Cliente: Run=" + this.runCliente + ", Nombre=" + this.nombreCliente + ", Apellido="
				+ this.apellidoCliente + ", Años=" + this.aniosCliente + ", Estatus/Categoria=" + this.nombreCategoria + ".";
	}
	
}
