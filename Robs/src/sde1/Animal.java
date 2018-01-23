package sde1;

public class Animal {

	String gender;
	int age;
	int weight;
    public Animal(String gender, int age, int weight)
    {
        super();
        this.gender = gender;
        this.age = age;
        this.weight = weight;
    }
	
    public void speak(){System.out.println("speaking....");}
}
