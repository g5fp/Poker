package sde1;

public class Zoo {

	public static void main(String[] args) {

		Animal dog=new Animal("M", 12, 55);
		dog.speak();
		Animal cat=new Animal("F",5,12);
		cat.speak();
		Fish dory = new Fish("F", 18,3);
		dory.swim(); 
	}

}
