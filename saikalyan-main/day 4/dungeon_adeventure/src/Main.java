import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Player one = new Player();
        one.interact();
        one.health = 100;
        one.name = "random";
        int n;
        Scanner s = new Scanner(System.in);
        while (one.health > 0) {
            n = s.nextInt();
            switch (n) {
                case 1:
                    Goblin gob = new Goblin();
                    gob.health = 10;
                    gob.name = "goblin";
                    one.health -= gob.health;
                    System.out.println("Player health: " + one.health);
                    gob.takeDamage();
                    break;
                case 2:
                    Dragon dra = new Dragon();
                    dra.health = 20;
                    dra.name = "dragon";
                    one.health -= dra.health;
                    System.out.println("Player health: " + one.health);
                    dra.takeDamage();
                    break;
                case 3:
                    Potion pot = new Potion();
                    pot.name = "health";
                    one.health += 10;
                    System.out.println("Player health: " + one.health);
                    break;
                case 4:
                    Weapon wep = new Weapon();
                    wep.name = "power";
                    one.health += 20;
                    System.out.println("Player health: " + one.health);
                    wep.use();
                    break;
                default:
                    System.out.println("you have choosen the wrong number");
                    one.health = 0; // End the game
                    break;
            }
        }
        System.out.println("The game is over");
        s.close();
    }
}

abstract class Creature {
    public String name;
    public int health;
    abstract public void attack();
    abstract public void takeDamage();
}

interface Interactable {
    void interact();
}

class Player extends Creature implements Interactable {
    public void interact() {
        System.out.println("Hey, what's the plan ????");
        System.out.println("Please enter the room no you want to go ");
        System.out.println(" 1 2 3 4 ");
        System.out.println("    ");

    }

    public void attack() {
        System.out.println("The player is attacking.");
    }

    @Override
    public void takeDamage() {
        System.out.println("The player has taken damage.");
    }
}

class Goblin extends Creature implements Interactable {
    @Override
    public void interact() {
        // Goblin interaction logic
    }

    @Override
    public void attack() {
        System.out.println("The goblin is attacking.");
    }

    public void takeDamage() {
        System.out.println("The goblin has taken the attack.");
    }
}

class Dragon extends Creature implements Interactable {
    @Override
    public void interact() {
        System.out.println("It's time for the dragon.");
    }

    public void attack() {
        System.out.println("The dragon is attacking.");
    }

    public void takeDamage() {
        System.out.println(" The dragon is attacking ");
    }
}

abstract class Item {
    String name;
    abstract void use();
}

class Potion extends Item {
    @Override
    void use() {
        System.out.println("The potion is used.");
    }
}

class Weapon extends Item {
    @Override
    void use() {
        System.out.println(" The weapon is added to the player inventory. ");
        System.out.println(" The player health is now increased ");
    }
}
