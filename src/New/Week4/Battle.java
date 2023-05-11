package New.Week4;

public class Battle implements Runnable{
    private BattleObject battleObject1;
    private BattleObject battleObject2;

    public Battle(BattleObject battleObject1,
                  BattleObject battleObject2){
        this.battleObject1 = battleObject1;
        this.battleObject2 = battleObject2;
    }

    @Override
    public void run() {
        while (!(battleObject2.isDestoryed())){
            battleObject1.attackHero(battleObject2);
        }
    }


}
