class Pet {
    protected String name;   //The name of pets
    protected int age;       //The age of pets
    protected String color;  //The color of pets
    protected double weight; //The weight of pets

    public Pet(String name, int age, String color, double weight) {
        this.name = name;
        this.age = age;
        this.color = color;
        this.weight = weight;
    }

    //Output general pet noise
    public void speak() {
        System.out.println("I am a pet!");
    }

    //Obtain general records of pets
    public String toString() {
        return "Name: " + name + ", Age: " + age + ", Color: " + color + ", Weight: " + weight;
    }
}