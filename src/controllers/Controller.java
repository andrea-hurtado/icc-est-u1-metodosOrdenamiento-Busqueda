
package controllers;

import models.Person;
import views.View;

public class Controller {
    private View view;
    private Person[] persons;
    private SortingMethods sortingMethods;
    private SearchMethods searchMethods;

    public Controller(View view, SortingMethods sortingMethods, SearchMethods searchMethods) {
        this.view = view;
        this.sortingMethods = sortingMethods;
        this.searchMethods = searchMethods;
    }

    public void start() {
        System.out.println("Bienvenido!");
        System.out.println("Ingrese personas:");
        inputPersons();
        System.out.println("Ordenando personas...");
        sortPersons();
        System.out.println("Buscando persona...");
        searchPerson();
        System.out.println("Proceso finalizado.");
    }

    public void inputPersons() {
        int n = view.inputAge(); 
        persons = new Person[n];
        for (int i = 0; i < n; i++) {
            persons[i] = view.inputPerson();
        }
    }

    public void addPersons() {
        Person newPerson = view.inputPerson();
        Person[] newPersons = new Person[persons.length + 1];
        System.arraycopy(persons, 0, newPersons, 0, persons.length);
        newPersons[persons.length] = newPerson;
        persons = newPersons;
    }

    public void sortPersons() {
        if (persons == null || persons.length == 0) {
            System.out.println("No hay personas para ordenar.");
            return;
        }

        int criterion = view.selectSortingMethod();
        int method = view.selectSearchCriterion();
        if (criterion == 1) {
            switch (method) {
                case 1:
                    sortingMethods.sortByNameWithBubble(persons);
                    break;
                case 2:
                    sortingMethods.sortByNameWithSelectionDes(persons);
                    break;
                case 3:
                    sortingMethods.sortByNameWithInsertion(persons);
                    break;
            }
        } else {
            switch (method) {
                case 1:
                    sortingMethods.sortByAgeWithInsertion(persons);
                    break;
                default:
                    System.out.println("Método no disponible para edad.");
            }
        }

        view.displayPersons(persons);
    }

    public void searchPerson() {
        if (persons == null || persons.length == 0) {
            System.out.println("No hay personas para buscar.");
            return;
        }

        int criterion = view.selectSearchCriterion();
        Person result = null;

        if (criterion == 1) {
            String name = view.inputName();
            if (!searchMethods.isSortedByName(persons)) {
                System.out.println("Debe ordenar por nombre antes de buscar.");
                return;
            }
            result = searchMethods.binarySearchByName(persons, name);
        } else {
            int age = view.inputAge();
            if (!searchMethods.isSortedByAge(persons)) {
                System.out.println("Debe ordenar por edad antes de buscar.");
                return;
            }
            result = searchMethods.binarySearchByAge(persons, age);
        }

        view.displaySearchResult(result);
    }
}
