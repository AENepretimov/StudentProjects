public class Mage extends Unit {

    private Integer mp;

    public Mage(String name, Integer hp, Integer mp) {
        super(name, hp);
        this.mp = mp;
    }

    @Override
    public void attack(Unit u) {
        if (mp > 0){
            u.getDmg(20);
            mp = mp - 5;
        }
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Mana : " + mp);
    }
}
