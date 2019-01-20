package Character;

public class ADHero extends Hero implements AD{

	int moveSpeed=400; //移动速度
	
	public int getMoveSpeed(){
        return this.moveSpeed;
    }
     
    public int getMoveSpeed2(){
        return super.moveSpeed;
    }
    
	public void attack() {
		
	}

	// 可变数量的参数
	public void attack(Hero... heros) {
		for (int i = 0; i < heros.length; i++) {
			System.out.println(name + " 攻击了 " + heros[i].name);
		}
	}
	//隐藏父类的battleWin方法
    public static void battleWin(){
        System.out.println("ad hero battle win");
    }   
	
	@Override
	public void physicAttack() {
		System.out.println("进行物理攻击");
	}


    public static void main(String[] args) {
    	ADHero h= new ADHero();
        System.out.println(h.getMoveSpeed());
        System.out.println(h.getMoveSpeed2());
    }
}
