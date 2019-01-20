package Character;

import Property.Item;
import Property.LifePotion;
import Property.MagicPotion;

public abstract class Hero {
    public static String name;
    protected float hp;
    float armor; //护甲
    int moveSpeed; //移动速度
 
    //实例方法,对象方法，非静态方法
    //必须有对象才能够调用
    public void die(){
        hp = 0;
    }
    
    public abstract void attack();
    
    public void useItem(Item i){
        i.effect();
    }
     
    //类方法，静态方法
    //通过类就可以直接调用
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
        System.out.println("这个英雄正在被回收");
    }
    
 // 非静态内部类，只有一个外部类对象存在的时候，才有意义
    // 战斗成绩只有在一个英雄对象存在的时候才有意义
    class BattleScore {
        int kill;
        int die;
        int assit;
 
        public void legendary() {
            if (kill >= 8)
                System.out.println(name + "超神！");
            else
                System.out.println(name + "尚未超神！");
        }
    }
    
  //敌方的水晶
    static class EnemyCrystal{
        public int hp=5000;
         
        //如果水晶的血量为0，则宣布胜利
        public void checkIfVictory(){
            if(hp==0){
                Hero.battleWin();
                 
                //静态内部类不能直接访问外部类的对象属性
                System.out.println(name + " win this game");
            }
        }
    }
      
    public static void main(String[] args) {
    	//在匿名类中使用外部的局部变量damage 必须修饰为final
        int damage = 5;
         
        //这里使用本地类AnonymousHero来模拟匿名类的隐藏属性机制
         
        //事实上的匿名类，会在匿名类里声明一个damage属性，并且使用构造方法初始化该属性的值
        //在attack中使用的damage，真正使用的是这个内部damage，而非外部damage
         
        //假设外部属性不需要声明为final
        //那么在attack中修改damage的值，就会被暗示为修改了外部变量damage的值
         
        //但是他们俩是不同的变量，是不可能修改外部变量damage的
        //所以为了避免产生误导，外部的damage必须声明为final,"看上去"就不能修改了
        class AnonymousHero extends Hero{
            int damage;
            public AnonymousHero(int damage){
                this.damage = damage;
            }
            public void attack() {
                damage = 10;
                System.out.printf("新的进攻手段，造成%d点伤害",this.damage );
            }
        }
         
        Hero h = new AnonymousHero(damage);
        h.attack();
    }
}



