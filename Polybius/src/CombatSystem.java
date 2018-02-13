import java.util.Scanner;
import java.util.Random;

public class CombatSystem {
	public static Scanner game = new Scanner(System.in);
	public static int punchDamage;
	public static int magicFireDamage;
	public static int magicIceDamage;
	public static int magicBeamDamage;
	public static int burnDamage;
	public static int ouchDamage;
	public static int strength = NameAndClassSelection.strength;
	public static int defense = NameAndClassSelection.defense;
	public static int agility = NameAndClassSelection.agility;
	public static int magic = NameAndClassSelection.magic;
	public static Random damage = new Random();
	public static boolean enemyDeath = false;
	public static int punchingBag = 1;
	public static int health = Player.health;
	public static int enemyHealth;
	static boolean fire = Player.fire;
	static boolean ice = Player.ice;
	static boolean beam = Player.beam;
	static String classType = NameAndClassSelection.classType;

	private static void stats() {
		String stats = NameAndClassSelection.classType;
		int strength = NameAndClassSelection.strength;
		int defense = NameAndClassSelection.defense;
		int agility = NameAndClassSelection.agility;
		int magic = NameAndClassSelection.magic;
		int balance = Player.wallet;
		int health = Player.health;

		System.out.println("Class Type: " + stats);
		System.out.println("	Strength: " + strength);
		System.out.println("	Defense: " + defense);
		System.out.println("	Agility: " + agility);
		if (stats == "Swordsman") {
			System.out.println("	Magic: Incapable");
		} else {
			System.out.println("	Magic: " + magic);
		}
		System.out.println("");
		System.out.println("Balance: $" + balance);
		System.out.println("");
		System.out.print("Health: " +health);
		System.out.println("");
		System.out.println("Inventory:");
		int lineNumber = 0;
		for (String item : Player.inventory) {
			if (item != "") {
				++lineNumber;
			}
			System.out.println(+lineNumber + "  ---  " + item);
		}
	}

	public static void combat(String enemyName, int enemyHealth, int enemyAttack) throws InterruptedException {

		System.out.print("You have the first move. ");
		while (!enemyDeath) {
			if (classType.equals("Swordsman")){
				while (!enemyDeath) {
					System.out.println("What would you like to do? (Punch)");
					String attack = game.nextLine().toUpperCase();
					switch(attack) {
					case "PUNCH":
						int minAttack = strength -2;
						punchDamage = (int)((Math.random()*5)+minAttack);
						System.out.println("You punched the " +enemyName+ " and dealt " +punchDamage+ " damage.");
						enemyHealth = enemyHealth - punchDamage;
						System.out.println("The " +enemyName+ "'s health is now " +enemyHealth+ " HP.");
						break;
					}
				}
			}
			System.out.println("What would you like to do? (Punch, Magic)");
			String attack = game.nextLine().toUpperCase();
			switch(attack) {
			case "PUNCH":
				int minAttack = strength -2;
				punchDamage = (int)((Math.random()*5)+minAttack);
				System.out.println("You punched the " +enemyName+ " and dealt " +punchDamage+ " damage.");
				enemyHealth = enemyHealth - punchDamage;
				System.out.println("The " +enemyName+ "'s health is now " +enemyHealth+ " HP.");
				break;
			case "MAGIC":
				/*int minAttack2 = magic -2;
				magicDamage = (int)((Math.random()*5)+minAttack2);
				System.out.println("You punched the " +enemyName+ " and dealt " +magicDamage+ " damage.");
				enemyHealth = enemyHealth - magicDamage;
				System.out.println("The " +enemyName+ "'s health is now " +enemyHealth+ " HP."); */

				System.out.print("What type of magic would you like to use?");
				if (fire == true){
					System.out.print("Fire");
				}
				if (ice == true){
					System.out.print("Ice");
				}
				if (beam == true){
					System.out.print("Beam");
				}

				boolean didPlayerSuccessfullyCompleteMagicAttack = false;
				while (!didPlayerSuccessfullyCompleteMagicAttack){
					String magicType = game.nextLine().toUpperCase();
					switch (magicType){
					case "FIRE":
						if (fire == true){
							System.out.println("You threw a fireball at " +enemyName+ " you dealt " );
							int minAttack2 = magic -2;
							System.out.println("The " +enemyName+ "'s health is now " +enemyHealth+ " HP.");
							double burn = (int) (Math.random()*100)+1;
							if (burn <= 25){
								magicFireDamage = magic / 3;
								enemyHealth = enemyHealth - magicFireDamage;
								System.out.println("You just burnt " +enemyName+ ", you did " +magicFireDamage+ " DMG. " +enemyName+ "'s health is " +enemyHealth);
							}
						}
						didPlayerSuccessfullyCompleteMagicAttack  = true;

						break;
					}
				}
			}

			if(enemyHealth <= 0){
				enemyDeath = true;
				System.out.println("Congratulations, you killed the " +enemyName+ ", good job.");
			}
			

			if (health <= 0) {
				System.out.println("Oh no! You died!");
				Thread.sleep(500);
				System.out.println("Restarting Game...");
				Thread.sleep(1500);
				System.out.println("END GAME STATISTICS:");
				stats();
				System.exit(0);
			}
			if (enemyAttack > 0 && !(enemyHealth <= 0)){
				int minOuchAttack = enemyAttack - 2;
				ouchDamage = (int)((Math.random()*5)+minOuchAttack);
				health = health - ouchDamage;
				System.out.println(enemyName+ " dealt " +ouchDamage+ ". Your health is now " +health);
			}
		}
	}
}