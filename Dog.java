class Dog extends Pet {
    private String breed;  //The breed of the dogs

    public Dog(String name, int age, String color, double weight, String breed) {
        super(name, age, color, weight);
        this.breed = breed;
    }

    //Output dog barks
    public void speak() {
        System.out.println("Woof! I am " + name + ", a " + age + " year old " + breed + " dog.");
    }

    //Obtain dog records
    public String toString() {
        return super.toString() + ", Breed: " + breed;
    }
}