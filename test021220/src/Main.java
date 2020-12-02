public class Main {

    public static void main(String[] args) {
        /*Unit u1 = new Unit("Valera", 100);

        u1.printInfo();*/

        Warrior w1 = new Warrior("Kolya", 120, 10);
        w1.printInfo();

        Mage m1 = new Mage("Kesha", 80, 20);
        m1.printInfo();

        m1.attack(w1);
        w1.printInfo();



    }
}
