public class Warrior extends Unit {
    private Integer armor;

    public Warrior(String name, Integer hp, Integer armor) {
        super(name, hp);
        this.armor = armor;
    }

    @Override
    public void attack(Unit u) {
        u.getDmg(5);
    }

    @Override
    public void getDmg(int dmg) {
        if (armor > 0) {
            armor -= 1;
            super.getDmg(dmg / 2);
        }else {
            super.getDmg(dmg);
        }
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Armor : " + armor);
    }
}
