import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;

import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {
		System.out.println(new File(FileSystems.getDefault().getPath("").toAbsolutePath().toFile(), "rfc.dat"));
		Operaciones.mostrarTodo();
		Operaciones on = new Operaciones();
		int opcion = 0;
		do {
			try {
				opcion = Integer.parseInt(JOptionPane.showInputDialog("BIENVENIDO \n¿Qué operacion desea realizar?+ "
						+ " \n1.-Obtener el RFC de una persona \n2.-Eliminar \n3.-Buscar \n4.-Mostrar Todo"));
				if (opcion == 1) {
					on.rfc();
					on.GuardarDisco();
					on.Imprimir();
				} else if (opcion == 2) {
					on.eliminar();
				} else if(opcion == 3) {
					on.Imprimir();
				} else if (opcion == 4) {
					System.out.println("------------------");
					on.mostrarTodo();
				} else {
					JOptionPane.showMessageDialog(null,
							"Parece que usted ha ingresado un numero que no está en el menú");
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null,
						"Parece que usted no ha ingresado un numero \nDigite un número por favor");
			}
			opcion = Integer
					.parseInt(JOptionPane.showInputDialog("¿Desea volver al menú principal? \n1.-SI  \n2.-SALIR"));
		} while (opcion == 1);

	}
}
