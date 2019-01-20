package Animals;

public class Cat extends Animal implements Pet{
	public String name;
	
	Cat(String name){
		super(4);
		this.name = name;
	}
	Cat(){
		this("");
	}
	
	public void eat() {
		System.out.println("Cat eat");
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void play() {
		System.out.println("Cat play");
	}
}
