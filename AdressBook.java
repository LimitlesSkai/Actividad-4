package Guia_Telefonica;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

public class AdressBook {
	
	public static Scanner Keyboard = new Scanner(System.in);
	public static Scanner Scan = new Scanner(System.in);
	
	static void save(HashMap<String, String> Guia_Telefonos) {
		try (CSVPrinter csvPrinter = new CSVPrinter(new FileWriter("Guia Telefonica.csv"), CSVFormat.DEFAULT)) {
		    csvPrinter.printRecord("{Numero}", "{Nombre}");
		    for (String i : Guia_Telefonos.keySet()) {
		    	csvPrinter.printRecord("{" + i + "}", "{"+ Guia_Telefonos.get(i) + "}");
				}
		    csvPrinter.close();
		} catch (IOException e) {
		    e.printStackTrace();
		}
	}
	static void list(HashMap<String, String> Guia_Telefonos) {
		for (String i : Guia_Telefonos.keySet()) {
			  System.out.println("{" + i + "}" + "{" + Guia_Telefonos.get(i) + "}");
			}
	}
	static void create(HashMap<String, String> Guia_Telefonos) {
		System.out.println("Introduzca el numero telefonico a agregar:");
		String numero = Scan.nextLine();
		System.out.println("Introduzca el nombre asociado al numero:");
		String nombre = Scan.nextLine();
		Guia_Telefonos.put(numero, nombre);
	}
	static void delete(HashMap<String, String> Guia_Telefonos) {
		System.out.println("Introduzca el numero telefonico a eliminar");
		String Numero = Scan.nextLine();
		Guia_Telefonos.remove(Numero);
	}
	public static int Menu(){
		int seleccion;
		System.out.println("Seleccione la operacionn a realizar:");
		System.out.println("------------------------------------");
		System.out.println("1: Mostrar la lista de contactos.");
		System.out.println("2: Crear un nuevo contacto.");
		System.out.println("3: Borrar un contacto existente.");
		System.out.println("4: Cerrar aplicacion.");
		
		seleccion = Keyboard.nextInt();
		return seleccion;
		}

	
	public static void main(String[] args) {
		
		HashMap<String, String> Guia_Telefonos = new HashMap<String, String>();

		int Eleccion_Usuario;
		do {
			Eleccion_Usuario = Menu();
			switch(Eleccion_Usuario) {
			case 1:
				list(Guia_Telefonos);
				break;
			case 2: 
				create(Guia_Telefonos);
				save(Guia_Telefonos);
				break;
			case 3:
				delete(Guia_Telefonos);
				break;
			case 4:
				System.out.println("Muchas gracias y que pase un lindo dia.");
				break;
			default:
				System.out.println("Por favor seleccione una opcion con los numeros 1, 2, 3 o 4.");
				break;
			}
		}
		while(Eleccion_Usuario!=4);
	}
}