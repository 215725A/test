package jp.ac.uryukyu.ie.e215725;

/**
 * 敵クラス。
 *  String name; //敵の名前
 *  int hitPoint; //敵のHP
 *  int attack; //敵の攻撃力
 *  boolean dead; //敵の生死状態。true=死亡。
 * Created by tnal on 2016/11/13.
 */
public class Enemy {
    private String name;
    private int hitPoint;
    private int attack;
    private boolean dead;

    /**
     * コンストラクタ。名前、最大HP、攻撃力を指定する。
     * @param name モンスター名
     * @param maximumHP モンスターのHP
     * @param attack モンスターの攻撃力
     */
    public Enemy (String name, int maximumHP, int attack) {
        this.name = name;
        hitPoint = maximumHP;
        this.attack = attack;
        dead = false;
        System.out.printf("%sのHPは%d。攻撃力は%dです。\n", name, maximumHP, attack);
    }

    /**
     * Heroへ攻撃するメソッド。
     * attackに応じて乱数でダメージを算出し、hero.wounded()によりダメージ処理を実行。
     * @param hero 攻撃対象
     */
    public void attack(Hero hero){
        if (this.dead == false){
            int damage = (int)(Math.random() * attack);
            System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", name, hero.getName(), damage);
            hero.wounded(damage);
        }
    }

    /**
     * 自身へ攻撃されたときのダメージ処理をするメソッド。
     * 指定されたダメージを hitPoint から引き、死亡判定を行う。
     * @param damage 受けたダメージ
     */
    public void wounded(int damage){
        hitPoint -= damage;
        if( hitPoint < 0 ) {
            dead = true;
            System.out.printf("モンスター%sは倒れた。\n", name);
        }
    }

    /**
     * 自身の名前を取得するアクセサメソッド
     * @return モンスター名
     */
    public String getName(){
        return this.name;
    }


    //ここから下はアクセサメソッド(ゲッター)

    /**
     * 自身のHPを取得するアクセサメソッド
     * @return モンスターのHP
     */
    public int getHitPoint(){
        return this.hitPoint;
    }

    /**
     * 自身の攻撃力を取得するアクセサメソッド
     * @return モンスターの攻撃力
     */
    public int getAttack(){
        return this.attack;
    }

    /**
     * 自身の死亡判定を取得するアクセサメソッド
     * @return 死亡判定
     */
    public boolean getDead(){
        return this.dead;
    }

    //ここから下はアクセサメソッド(セッター)

    /**
     * モンスター名を設定するアクセサメソッド
     * @param inputName 入力したモンスター名
     */
    public void setName(String inputName){
        this.name = inputName;
    }

    /**
     * モンスターのHPを設定するアクセサメソッド
     * @param inputHitPoint 入力されたモンスターのHP
     */
    public void setHitPoint(int inputHitPoint){
        this.hitPoint = inputHitPoint;
    }

    /**
     * モンスターの攻撃力を設定するアクセサメソッド
     * @param inputAttack 入力されたモンスターの攻撃力
     */
    public void setAttack(int inputAttack){
        this.attack = inputAttack;
    }

    /**
     * 死亡判定を設定するアクセサメソッド
     * @param boolDead 死亡判定
     */
    public void setDead(boolean boolDead){
        this.dead = boolDead;
    }

}