class Cat extends Pet {
    private String breed;   //The breed of the cats

    public Cat(String name, int age, String color, double weight, String breed) {
        super(name, age, color, weight);
        this.breed = breed;
    }

    //Output cat barks
    public void speak() {
        System.out.println("Miaow! I am " + name + ", a " + age + " year old " + breed + " cat.");
    }

    //Obtain cat records
    public String toString() {
        return super.toString() + ", Breed: " + breed;
    }
}