package Character;

public class ADHero extends Hero implements AD{

	int moveSpeed=400; //�ƶ��ٶ�
	
	public int getMoveSpeed(){
        return this.moveSpeed;
    }
     
    public int getMoveSpeed2(){
        return super.moveSpeed;
    }
    
	public void attack() {
		
	}

	// �ɱ������Ĳ���
	public void attack(Hero... heros) {
		for (int i = 0; i < heros.length; i++) {
			System.out.println(name + " ������ " + heros[i].name);
		}
	}
	//���ظ����battleWin����
    public static void battleWin(){
        System.out.println("ad hero battle win");
    }   
	
	@Override
	public void physicAttack() {
		System.out.println("����������");
	}


    public static void main(String[] args) {
    	ADHero h= new ADHero();
        System.out.println(h.getMoveSpeed());
        System.out.println(h.getMoveSpeed2());
    }
}
