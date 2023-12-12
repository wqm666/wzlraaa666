import java.io.*;
import java.util.*;

class PetClinic {
    private String clinicName;     //Clinic Name
    private ArrayList<Pet> pets;   //Create the pet list

    public PetClinic(String clinicName) {
        this.clinicName = clinicName;
        this.pets = new ArrayList<>();
    }

    //Add pets to the pet list
    public void addPet(Pet pet) {
        pets.add(pet);
    }

    //Search and delete corresponding named pets by iterating through the pet list through a for loop
    public void removePet(String petName) {
        for (int i = 0; i < pets.size(); i++) {
            Pet pet = pets.get(i);
            if (pet.name.equals(petName)) {
                pets.remove(i);
                System.out.println("Pet " + petName + " has been deleted.");
                return;
            }
        }
        System.out.println("Pet " + petName + " not found.");
    }


    //1. Print out the name of the clinic and the total number of pets.
    //2. Create a HashMap object colorCount and use the for loop to traverse the pet list
    //3. Obtain the color of the pet by accessing the color attribute of the pet object.
    // And use the colorCount. put() method to use colors as keys and store the corresponding number of colors as values in the colorCount hash map.
    // If the color already exists in the hash map, increase its quantity by 1; Otherwise, it defaults to 0.
    //4. Use a for loop to traverse each entry in the colorCount hash map.
    // Obtain and print colors and corresponding quantities through the entry. getKey() and entry. getValue methods.
    public void printReport() {
        System.out.println("Clinic Name: " + clinicName);
        System.out.println("Total Pets: " + pets.size());

        HashMap<String, Integer> colorCount = new HashMap<>();
        for (Pet pet : pets) {
            String color = pet.color;
            colorCount.put(color, colorCount.getOrDefault(color, 0) + 1);
        }

        System.out.println("Main Colors:");
        for (Map.Entry<String, Integer> entry : colorCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    //Search for pets based on their names through a for loop
    public void searchPetByName(String name) {
        for (Pet pet : pets) {
            if (pet.name.equalsIgnoreCase(name)) {
                System.out.println(pet.toString());
                pet.speak();
                return;
            }
        }
        System.out.println("Pet with name " + name + " not found.");
    }

    //Search for pets based on their colors through a for loop
    public void searchPetByColor(String color) {
        for (Pet pet : pets) {
            if (pet.color.equalsIgnoreCase(color)) {
                System.out.println(pet.toString());
                pet.speak();
            }
        }
    }

    //Write the clinic report and the pet list into the file through a for loop, hash map and File class
    //Use try catch statements for exception handling
    //It is similar to printReport() partially
    public void saveToFile() {
        try {
            FileWriter clinicWriter = new FileWriter("ClinicsDetails.txt");
            clinicWriter.write("Clinic Name: " + clinicName + "\n");
            clinicWriter.write("Total Pets: " + pets.size() + "\n");

            HashMap<String, Integer> colorCount = new HashMap<>();
            for (Pet pet : pets) {
                String color = pet.color;
                colorCount.put(color, colorCount.getOrDefault(color, 0) + 1);
            }

            clinicWriter.write("Main Colors:" + "\n");
            for (Map.Entry<String, Integer> entry : colorCount.entrySet()) {
                clinicWriter.write(entry.getKey() + ": " + entry.getValue() + "\n");
            }

            clinicWriter.close();

            FileWriter petWriter = new FileWriter("PetDetails.txt");
            for (Pet pet : pets) {
                if (pet instanceof Dog dog) {
                    petWriter.write("Dog: " + dog.toString() + "\n");
                } else if (pet instanceof Cat cat) {
                    petWriter.write("Cat: " + cat.toString() + "\n");
                } else {
                    petWriter.write("Pet," + pet.name + "," + pet.age + "," + pet.color + "," + pet.weight + "\n");
                }
            }
            petWriter.close();

            System.out.println("Data saved to files.");
        } catch (IOException e) {
            System.out.println("Error occurred while saving data to files.");
        }
    }

    //View all recorded pets through a for loop
    public void viewAllPets() {
        System.out.println("All Registered Pets:");
        for (Pet pet : pets) {
            if (pet instanceof Dog dog) {
                System.out.println(dog.toString());
                dog.speak();
            } else if (pet instanceof Cat cat) {
                System.out.println(cat.toString());
                cat.speak();
            }

        }
    }

    //Read the pet list from the file
    //Use readLine()  in the  the BufferedReader class to read records from a file
    //Use split () in the String class to separate strings by commas, remove prefixes, and add them to the pet list
    public void loadFromFile() {
        try {
            BufferedReader clinicReader = new BufferedReader(new FileReader("ClinicsDetails.txt"));
            clinicName = clinicReader.readLine().substring(13);
            clinicReader.close();

            BufferedReader petReader = new BufferedReader(new FileReader("PetDetails.txt"));
            String line;
            while ((line = petReader.readLine()) != null) {
                String[] petData = line.split(", ");
                    String name = petData[0].substring(11);
                    int age = Integer.parseInt(petData[1].substring(5));
                    String color = petData[2].substring(7);
                    double weight = Double.parseDouble(petData[3].substring(8));
                    String breed = petData[4].substring(7);
                    if (petData[0].startsWith("Cat: ")) {
                        pets.add(new Cat(name, age, color, weight, breed));
                    } else if (petData[0].startsWith("Dog: ")) {
                        pets.add(new Dog(name, age, color, weight, breed));
                    }
                }
            petReader.close();

            System.out.println("Data loaded from files.");
        } catch (IOException e) {
            System.out.println("Error occurred while loading data from files.");
        }
    }

    //Get the list of pets in the clinic
    public List<Pet> getPets() {
        return this.pets;
    }
}