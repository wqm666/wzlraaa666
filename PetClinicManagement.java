import java.util.*;

public class PetClinicManagement {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        PetClinic clinic = new PetClinic("Paddington Pet Clinic");
        //Read the pet list from the file
        clinic.loadFromFile();

        //The program starts running
        while (true) {
            //print the start screen
            System.out.println("--- Welcome to Paddington Clinic ---");
            System.out.println("--- Pet Clinic Management System ---");
            System.out.println("1. Add a pet");
            System.out.println("2. Remove a pet");
            System.out.println("3. Print clinic report");
            System.out.println("4. Search pet by name");
            System.out.println("5. Search pet by color");
            System.out.println("6. Save data to files");
            System.out.println("7. View all pets");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            int choice = scan.nextInt();
            scan.nextLine();

            //Obtain user input and select actions
            switch (choice) {
                case 1 -> {
                    System.out.print("Enter pet type (Cat/Dog): ");
                    String type = scan.nextLine();
                    System.out.print("Enter pet name: ");
                    String name = scan.nextLine();
                    System.out.print("Enter pet age: ");
                    int age = scan.nextInt();
                    scan.nextLine();
                    System.out.print("Enter pet color: ");
                    String color = scan.nextLine();
                    System.out.print("Enter pet weight: ");
                    double weight = scan.nextDouble();
                    scan.nextLine();
                    System.out.print("Enter pet breed: ");
                    String breed = scan.nextLine();
                    if (type.equalsIgnoreCase("Cat")) {
                        clinic.addPet(new Cat(name, age, color, weight, breed));
                    } else if (type.equalsIgnoreCase("Dog")) {
                        clinic.addPet(new Dog(name, age, color, weight, breed));
                    } else {
                        System.out.println("Invalid pet type.");
                    }
                }
                case 2 -> {
                    System.out.println("Enter pet name to remove:");
                    String petName = scan.nextLine();
                    clinic.removePet(petName);
                }
                case 3 -> clinic.printReport();
                case 4 -> {
                    System.out.print("Enter pet name to search: ");
                    String searchName = scan.nextLine();
                    clinic.searchPetByName(searchName);
                }
                case 5 -> {
                    System.out.print("Enter pet color to search: ");
                    String searchColor = scan.nextLine();
                    clinic.searchPetByColor(searchColor);
                }
                case 6 -> clinic.saveToFile();
                case 7 -> clinic.viewAllPets();
                case 8 -> {
                    clinic.saveToFile();
                    System.out.println("Exiting program...");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}