package utilidades;

//Clase Utilidad, sus métodos son estáticos para no instanciar su clase
public class Utilidad {
	public static void stopAndContinue() {
		timeToWait();
		limpiarPantalla();
	}

	public static void limpiarPantalla() {
		for (int i = 0; i < 10; i++) {
			System.out.println("");
		}
		System.out.flush();
	}

	public static void timeToWait() {
		int timeWait = 10; // Segundos
		try {
			for (int i = 0; i < timeWait; i++) {
				Thread.sleep(150);
			}
		} catch (InterruptedException ie) {
			System.out.println("Tiempo de espera interrumpido");
		}
	}
}
