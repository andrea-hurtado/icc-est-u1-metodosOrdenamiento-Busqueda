
package views;

import java.util.Scanner;
import models.Person;

public class View {
    private Scanner scanner;

    public View() {
        scanner = new Scanner(System.in);
    }

    public int showMenu() {
        System.out.println("\n--- MENÚ PRINCIPAL ---");
        System.out.println("1. Ingresar personas");
        System.out.println("2. Ordenar personas");
        System.out.println("3. Buscar persona");
        System.out.println("4. Salir");
        System.out.print("Seleccione una opción: ");
        return scanner.nextInt();
    }

    public int inputAge() {
        System.out.print("Ingrese la cantidad de personas: ");
        return scanner.nextInt();
    }

    public Person inputPerson() {
        scanner.nextLine(); 
        System.out.print("Ingrese el nombre: ");
        String name = scanner.nextLine();
        System.out.print("Ingrese la edad: ");
        int age = scanner.nextInt();
        return new Person(name, age);
    }

    public int selectSortingMethod() {
        System.out.println("\nSeleccione el criterio de ordenamiento:");
        System.out.println("1. Por nombre");
        System.out.println("2. Por edad");
        System.out.print("Opción: ");
        return scanner.nextInt();
    }

    public int selectSearchCriterion() {
        System.out.println("\nSeleccione el criterio de búsqueda:");
        System.out.println("1. Por nombre");
        System.out.println("2. Por edad");
        System.out.print("Opción: ");
        return scanner.nextInt();
    }

    public void displayPersons(Person[] persons) {
        System.out.println("\n--- Lista de Personas ---");
        for (Person p : persons) {
            System.out.println(p);
        }
    }

    public void displaySearchResult(Person person) {
        if (person != null) {
            System.out.println("Persona encontrada: " + person);
        } else {
            System.out.println("Persona no encontrada.");
        }
    }

    public String inputName() {
        scanner.nextLine();
        System.out.print("Ingrese el nombre a buscar: ");
        return scanner.nextLine();
    }
}
