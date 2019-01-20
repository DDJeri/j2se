package Character;

public interface Mortal {
	public void die();
	 
    default public void revive() {
        System.out.println("±æ”¢–€∏¥ªÓ¡À");
    }
}
