package Animals;

public class Fish extends Animal implements Pet{
	
	private String name;
	public void walk() {
		System.out.println("Fish can't walk");
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void play() {
		System.out.println("Fish play");
	}
	
	public Fish() {
		super(0);
	}
	public void eat() {
		System.out.println("Fish eat");
	}
}
