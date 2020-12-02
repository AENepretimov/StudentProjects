public abstract class Unit {
    private String name;
    private Integer hp;

    public Unit(String name, Integer hp){
        this.name = name;
        this.hp = hp;
    }

    public abstract void attack(Unit u);

    public void getDmg(int dmg){
        hp = hp - dmg;
    }

    public void printInfo(){

        System.out.println("===============");
        System.out.println("Name : " + name);
        System.out.println("Hp : " + hp);

    }

}
