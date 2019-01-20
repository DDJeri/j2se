package Character;

import Property.Item;
import Property.LifePotion;
import Property.MagicPotion;

public abstract class Hero {
    public static String name;
    protected float hp;
    float armor; //����
    int moveSpeed; //�ƶ��ٶ�
 
    //ʵ������,���󷽷����Ǿ�̬����
    //�����ж�����ܹ�����
    public void die(){
        hp = 0;
    }
    
    public abstract void attack();
    
    public void useItem(Item i){
        i.effect();
    }
     
    //�෽������̬����
    //ͨ����Ϳ���ֱ�ӵ���
    public static void battleWin(){
        System.out.println("battle win");
    }
    
    public boolean equals(Object o){
        if(o instanceof Hero){
            Hero h = (Hero) o;
            return this.hp == h.hp;
        }
        return false;
    }
     
    public void finalize(){
        System.out.println("���Ӣ�����ڱ�����");
    }
    
 // �Ǿ�̬�ڲ��ֻ࣬��һ���ⲿ�������ڵ�ʱ�򣬲�������
    // ս���ɼ�ֻ����һ��Ӣ�۶�����ڵ�ʱ���������
    class BattleScore {
        int kill;
        int die;
        int assit;
 
        public void legendary() {
            if (kill >= 8)
                System.out.println(name + "����");
            else
                System.out.println(name + "��δ����");
        }
    }
    
  //�з���ˮ��
    static class EnemyCrystal{
        public int hp=5000;
         
        //���ˮ����Ѫ��Ϊ0��������ʤ��
        public void checkIfVictory(){
            if(hp==0){
                Hero.battleWin();
                 
                //��̬�ڲ��಻��ֱ�ӷ����ⲿ��Ķ�������
                System.out.println(name + " win this game");
            }
        }
    }
      
    public static void main(String[] args) {
    	//����������ʹ���ⲿ�ľֲ�����damage ��������Ϊfinal
        int damage = 5;
         
        //����ʹ�ñ�����AnonymousHero��ģ����������������Ի���
         
        //��ʵ�ϵ������࣬����������������һ��damage���ԣ�����ʹ�ù��췽����ʼ�������Ե�ֵ
        //��attack��ʹ�õ�damage������ʹ�õ�������ڲ�damage�������ⲿdamage
         
        //�����ⲿ���Բ���Ҫ����Ϊfinal
        //��ô��attack���޸�damage��ֵ���ͻᱻ��ʾΪ�޸����ⲿ����damage��ֵ
         
        //�����������ǲ�ͬ�ı������ǲ������޸��ⲿ����damage��
        //����Ϊ�˱�������󵼣��ⲿ��damage��������Ϊfinal,"����ȥ"�Ͳ����޸���
        class AnonymousHero extends Hero{
            int damage;
            public AnonymousHero(int damage){
                this.damage = damage;
            }
            public void attack() {
                damage = 10;
                System.out.printf("�µĽ����ֶΣ����%d���˺�",this.damage );
            }
        }
         
        Hero h = new AnonymousHero(damage);
        h.attack();
    }
}



