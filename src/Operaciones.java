
import javax.swing.JOptionPane;
import java.io.*;
import java.nio.file.FileSystems;
import java.util.RandomAccess;

public class Operaciones {
	private String nombre[];
	private String Usuario;
	private String fecha1[];
	static RandomAccessFile a, aux;
	static Datos2 ob = new Datos2("  ", "  ", "  ", "  ", 0, 0, 0, "  ", "  ", " ");

	private final static File WORK_DIRECTORY = FileSystems.getDefault().getPath("").toAbsolutePath().toFile();
	private final static File DEFAULT_FILE = new File(WORK_DIRECTORY, "rfc.dat");

	public void rfc() {
		ob.setNomCom(JOptionPane.showInputDialog("Ingresa tu nombre completo empezando por apellidos"));
		// acumul+=".- "+ob.getNomCom()+"\n";
		nombre = ob.getNomCom().split(" ");
		if (nombre.length == 2) {
			ob.setApeP(nombre[0]);
			ob.setNomb(nombre[2]);
		}

		if (nombre.length == 3) {
			ob.setApeP(nombre[0]);
			ob.setApeM(nombre[1]);
			ob.setNomb(nombre[2]);
		} else if (nombre.length == 4 && nombre[2].trim().equalsIgnoreCase("maria")
				|| nombre.length == 4 && nombre[2].trim().equalsIgnoreCase("jose")) {
			ob.setApeP(nombre[0]);
			ob.setApeM(nombre[1]);
			ob.setX(nombre[2]);
			ob.setNomb(nombre[3]);
		} else if (nombre.length == 4) {
			ob.setApeP(nombre[0]);
			ob.setApeM(nombre[1]);
			ob.setX(nombre[3]);
			ob.setNomb(nombre[2]);
		} else if (nombre.length == 5) {
			ob.setApeP(nombre[0]);
			ob.setApeM(nombre[1]);
			ob.setY(nombre[2]);
			ob.setX(nombre[3]);
			ob.setNomb(nombre[4]);
		}
		int contador = 0;
		String vo = "";
		int j = 1;
		do {
			switch (ob.getApeP().charAt(j)) {
			case 'a':
				vo = "a";
				contador++;
				break;
			case 'e':
				vo = "e";
				contador++;
				break;
			case 'i':
				vo = "i";
				contador++;
				break;
			case 'o':
				vo = "o";
				contador++;
				break;
			case 'u':
				vo = "u";
				contador++;
				break;
			default:
				j++;
			}

		} while (contador != 1);
		ob.setRfc(ob.getApeP().trim().substring(0, 1));
		ob.setRfc(ob.getRfc().concat(vo));

		boolean ban = false;
		do {
			try {
				ob.setAño(Integer.parseInt(JOptionPane.showInputDialog("Ingresa tu año de nacimiento con numero")));
				if (ob.getAño() > 1890 && ob.getDia() < 2020) {
					ban = true;
				} else {
					JOptionPane.showMessageDialog(null, "Ese año aún no llega ");
					ban = false;
				}

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Error, usted no ha ingresado un número");
				ban = false;
			}
		} while (ban == false);
		do {
			try {
				ob.setMes(Integer.parseInt(JOptionPane.showInputDialog("Ingresa tu mes de nacimiento con numero")));
				if (ob.getMes() > 0 && ob.getMes() < 13) {
					ban = true;
				} else {
					JOptionPane.showMessageDialog(null, "Error, un año solo tiene 12 meses");
					ban = false;
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Error, usted no ha ingresado un número");
				ban = false;
			}
		} while (ban == false);
		do {
			try {
				ob.setDia(Integer.parseInt(JOptionPane.showInputDialog("Ingresa tu dia de nacimiento con número")));
				if (ob.getDia() > 0 && ob.getDia() < 31) {
					ban = true;
				} else {
					ban = false;
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Error, usted no ha ingresado un número");
				ban = false;
			}
		} while (ban == false);
		String di = String.valueOf(ob.getDia());
		String me = String.valueOf(ob.getMes());
		String añ = String.valueOf(ob.getAño());

		ob.setRfc(ob.getRfc() + ob.getApeM().substring(0, 1));
		ob.setRfc(ob.getRfc() + ob.getNomb().substring(0, 1));
		ob.setRfc(ob.getRfc() + añ.substring(1, 3));
		ob.setRfc(ob.getRfc() + me);
		ob.setRfc(ob.getRfc() + di);
		System.out.println(" El RFC de esta persona es: " + ob.getRfc().toUpperCase() + "\n");
	}

	public static void GuardarDisco() {
		try {
			a = new RandomAccessFile(DEFAULT_FILE, "rws");// abrir el archivo
			// nombre documento y tipo read and write
			a.seek(a.length());// posicionar el apuntadorque existe dentro de un archivo
			a.writeBytes(ob.getRfc() + "\n");// Guardaren el archivo, se le pone Write y adelante el tipo de dato
												// de la variable
			a.writeBytes(ob.getNomb() + "\n\n");// Lleva uno por cada variable

			a.close();// Cerrar archivo
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Error, Archivo no existente");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "ERROR 1");

		}
	}

	//
	public static void Imprimir() {
		String nombre, dir;
		String tel;
		boolean flag = false;
		String search = JOptionPane.showInputDialog("Ingrese el rfc a buscar");
		try {
			a = new RandomAccessFile(DEFAULT_FILE, "rws");// abrir el archivo

			BufferedReader reader = new BufferedReader(new FileReader(DEFAULT_FILE));

			String currentLine;

			while ((currentLine = reader.readLine()) != null) {
				if (currentLine.trim().equalsIgnoreCase(search)) {
					System.out.println("ENCONTRADO");
					System.out.println("Nombre: " + currentLine);
					flag = true;
				}

				if (flag) {
					System.out.println("RFC" + currentLine);
				}
			}

			/*
			 * nombre = a.readLine(); while (nombre != null) {
			 * 
			 * if()
			 * 
			 * if(auxFlag) dir = a.readLine();// lo saca del dispositivo interno y lo lleva
			 * a la ram, lo tienes que poner en // una variable tel = a.readLine();
			 * JOptionPane.showMessageDialog(null, "Nombre: " + ob.getNomCom());
			 * JOptionPane.showMessageDialog(null, "Rfc: " + ob.getRfc());
			 * 
			 * }
			 */
			a.close();
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Error");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "ERROR 2");
		}
	}

	/*
	 * public static void Buscar() { String Nombre1 = " "; try { aux = new
	 * RandomAccessFile("C:\\Prueba\\rfcnuevo.dat", "rw"); while ((Nombre1 =
	 * aux.readLine()) != null) { id = Integer.parseInt(Usuario.readLine()); if (ids
	 * == id) { JOptionPane.showMessageDialog(null, "USUARIO CORRECTO"); break; } }
	 * aux.close(); } catch (FileNotFoundException e) {
	 * JOptionPane.showMessageDialog(null, "ERROR", "ERROR",
	 * JOptionPane.ERROR_MESSAGE); } catch (IOException e) {
	 * JOptionPane.showMessageDialog(null, "ERROR DE E/S", "ERROR",
	 * JOptionPane.ERROR_MESSAGE); } }
	 */

	public static void eliminar() {
		String rfc = JOptionPane.showInputDialog("Ingrese RFC a eliminar: ");
		boolean removeFile = false;
		boolean succesfull = false;
		
		try {
			File fileOriginal = DEFAULT_FILE;
			File fileCopy = new File(WORK_DIRECTORY, "temporal.dat");

			BufferedReader reader = new BufferedReader(new FileReader(fileOriginal));
			BufferedWriter writer = new BufferedWriter(new FileWriter(fileCopy));
			reader.lines().forEach(System.out::println);
			String currentLine;

			while ((currentLine = reader.readLine()) != null) {
				if (!currentLine.trim().equalsIgnoreCase(rfc)) {
					System.out.println("Diferente");
					
					writer.write(currentLine + System.getProperty("line.separator"));
				} else
					System.out.println("Eliminado...");
			}

			writer.close();
			reader.close();
			reader = null;
			writer = null;
			System.out.println(fileOriginal);
			if (!fileOriginal.exists())
			if (!fileOriginal.exists() && !fileOriginal.canWrite()) {
				fileOriginal.delete();
				if (fileCopy.renameTo(fileOriginal)) {
					System.out.println("Successfull Rename");
				} else
					System.out.println("Error Rename");
			} else
				System.out.println("No se puede eliminar el archivo");
			System.out.println("---------Copia--------");
			mostrarTodo(fileCopy);
		} catch (IOException e) {
			System.out.println("Error" + e);
		}
	}

	public static void mostrarTodo(File file) {
		// File file = new File("C:\\\\Prueba\\\\rfc.dat");

		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));

			String currentLine;

			while ((currentLine = reader.readLine()) != null) {
				System.out.println("Datos: " + currentLine);
			}
		} catch (Exception e) {
			System.err.print(e);
		}

	}

	public static void mostrarTodo() {
		mostrarTodo(DEFAULT_FILE);
	}

}
