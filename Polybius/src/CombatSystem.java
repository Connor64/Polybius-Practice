import java.util.Scanner;
import java.util.Random;

public class CombatSystem {
	public static Scanner game = new Scanner(System.in);
	public static String enemy1 = "The Punching Bag";
	public static int enemy1health = 10;
	public static int punchDamage;
	public static int strength = NameAndClassSelection.strength;
	public static int defense = NameAndClassSelection.defense;
	public static int agility = NameAndClassSelection.agility;
	public static int magic = NameAndClassSelection.magic;
	public static Random damage = new Random();
	public static void combat() {

		System.out.println("You have the first move, what would you like to do? (Punch, Run, Magic)");
		while (true) {
			String attack = game.nextLine().toUpperCase();
			switch(attack) {
			case "PUNCH":
				int maxAttack = strength +2;
				int minAttack = strength -2;
				punchDamage = minAttack + damage.nextInt(maxAttack);
				System.out.println("You punched the " +enemy1+ " and dealt " +punchDamage+ " damage.");
				int enemy1newhealth = enemy1health - punchDamage;
				enemy1health = enemy1newhealth;
				System.out.println("The " +enemy1+ "'s health is now " +enemy1health+ " HP.");
				
				while (true) {
				if (enemy1health > 0) {
					System.out.println(enemy1+ " attacks... but it does nothing. (Press Enter to Continue)");
					game.nextLine();
					System.out.println("What would you like to do? (Punch, Run, Magic)");
						String attack2 = game.nextLine().toUpperCase();
						switch(attack2) {
						case "PUNCH":
							int maxAttack1 = strength +2;
							int minAttack1 = strength -2;
							punchDamage = minAttack1 + damage.nextInt(maxAttack1);
							System.out.println("You punched the " +enemy1+ "and dealt " +punchDamage+ "damage.");
							int enemy1newhealth1 = enemy1health - punchDamage;
							enemy1health = enemy1newhealth1;
							System.out.println("The " +enemy1+ "'s health is now " +enemy1health+ "HP. (Press Enter to Continue)");
				}
				break;
			}else {
				System.out.println("You have successfully defeated " +enemy1+ ". Congratulations!");
			}
				
			break;
		}
	}
}
	}
}

