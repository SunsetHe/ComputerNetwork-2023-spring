package New.Week4;

public class BattleObject {
    public String name;
    public float hp;
    public int attack;

    public BattleObject(String name,float hp,int attack){
        this.name = name;
        this.hp = hp;
        this.attack = attack;
    }

    public void attackHero(BattleObject bo){
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        bo.hp -= attack;
        System.out.printf(" %s 正在攻击 %s , %s 的耐久还剩 %.2f\n", name,
                bo.name,bo.name,bo.hp);
        if (bo.isDestoryed()){
            System.out.println(bo.name + "被消灭。");
        }
    }

    public boolean isDestoryed(){
        return 0 >= hp;
    }
}
