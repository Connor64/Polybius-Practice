import java.util.Scanner;
import java.util.Random;

public class CombatSystem {
	public static Scanner game = new Scanner(System.in);
	public static int punchDamage;
	public static int magicFireDamage;
	public static int magicFireDamageAdditional;
	public static int magicIceDamage;
	public static int magicBeamDamage;
	public static int magicBeamDamageStop;
	public static int burnDamage;
	public static int iceDamage;
	public static int beamDamage;
	public static int ouchDamage;
	public static int strength = NameAndClassSelection.strength;
	public static int defense = NameAndClassSelection.defense;
	public static int agility = NameAndClassSelection.agility;
	public static int magic = NameAndClassSelection.magic;
	public static int defenseCount;
	public static Random damage = new Random();
	public static boolean enemyDeath = false;
	public static int punchingBag = 1;
	public static int health = Player.health;
	public static int enemyHealth;
	static boolean fire = Player.fire;
	static boolean ice = Player.ice;
	static boolean beam = Player.beam;
	public static boolean beamDown, iceDown;
	public static boolean fireGo, iceGo, beamGo;
	public static boolean defenseUp;
	static String classType = NameAndClassSelection.classType;

	private static void stats() {
		String stats = NameAndClassSelection.classType;
		int strength = NameAndClassSelection.strength;
		int defense = NameAndClassSelection.defense;
		int agility = NameAndClassSelection.agility;
		int magic = NameAndClassSelection.magic;
		int balance = Player.wallet;

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
					System.out.println("What would you like to do? (Attack, Defend)");
					String attackDefend = game.nextLine().toUpperCase();
					switch (attackDefend) {
					case "ATTACK":
						while (!enemyDeath) {
							System.out.println("What would you like to do? (Punch, Back)");
							String attack = game.nextLine().toUpperCase();
							switch(attack) {
							case "PUNCH":
								int minAttack = strength -2;
								punchDamage = (int)((Math.random()*5)+minAttack);
								System.out.println("You punched the " +enemyName+ " and dealt " +punchDamage+ " damage.");
								enemyHealth = enemyHealth - punchDamage;
								System.out.println("The " +enemyName+ "'s health is now " +enemyHealth+ " HP.");
								break;
							case "STATS":
								stats();
								break;
							case "BACK":
								combat(enemyName, enemyHealth, enemyAttack);
								break;
							default:
								System.out.println("INVALD COMMAND");
								break;
							}
						}
					case "DEFEND":
						System.out.println("You are suddenly protected by an energy shield, surrounding your body.");
						break;
					}
				}
			}
			System.out.println("What would you like to do? (Attack, Defend)");
			String attackDefend = game.nextLine().toUpperCase();
			switch(attackDefend){
			case "ATTACK":
				System.out.println("Punch, Magic, Back");
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
						System.out.print(" (Fire, ");
					}
					if (ice == true){
						if (fire == false) {
							System.out.println(" (Ice, ");
						} else {
							System.out.print("Ice, ");
						}
					}

					if (beam == true){
						if (fire == false && ice == false) {
							System.out.println(" (Beam)");
						}else {
							System.out.print("Beam)");
						}
					}

					boolean choice = false;
					while (!choice){
						String magicType = game.nextLine().toUpperCase();
						switch (magicType){
						case "FIRE":
							if (fire == true){
								int minAttack2 = magic -2;
								burnDamage = (int)(Math.random()*5)+minAttack2;
								System.out.println("");
								System.out.println("You threw a fireball at " +enemyName+ " you dealt " +burnDamage+ " DMG.");
								System.out.println("");
								enemyHealth = enemyHealth - burnDamage;
								System.out.println("The " +enemyName+ "'s health is now " +enemyHealth+ " HP. (Press Enter to Continue)");
								System.out.println("");
								game.nextLine();
								fireGo = true;
								double burn1 = (int) (Math.random()*100)+1;
								if (burn1 <= 25){
									magicFireDamageAdditional = magic / 2;
									enemyHealth = enemyHealth - magicFireDamage;
									if (magicFireDamageAdditional > 1 || magicFireDamageAdditional <= 0) {
										System.out.println("The " +enemyName+ " burst into flames! " +magicFireDamageAdditional+ " DMG points was dealt to it. (Press Enter to Continue)");
									} else {
										System.out.println("The " +enemyName+ "burst into flames! " +magicFireDamageAdditional+ " DMG point was dealt to it. (Press Enter to Continue)");
									}
									System.out.println("");
									game.nextLine();
									enemyHealth = enemyHealth - magicFireDamageAdditional;
									System.out.println("The " +enemyName+ "'s health is now " +enemyHealth+ " HP.");
								}

							}else {
								System.out.println("INVALID COMMAND");
							}
							choice = true;
							break;
						case "ICE":
							if (ice == true) {
								int minAttack4 = magic - 2;
								iceDamage = (int)(Math.random()*5)+minAttack4;
								System.out.println("");
								System.out.println("You used freeze ray against the " +enemyName+ "and dealt " +iceDamage+ " DMG.");
								System.out.println("");
								enemyHealth = enemyHealth - iceDamage;
								System.out.println("The " +enemyName+ "'s health is now " +enemyHealth+ " HP. (Press Enter to Continue)");
								game.nextLine();
								iceGo = true;
								double ice = (int) (Math.random()*100)+1;
								if (ice <= 25){
									iceGo = false;
									iceDown = true;
									System.out.println("You froze the enemy in place! (Press Enter to Continue)");
									game.nextLine();
								}
								choice = true;
							}
							break;
						case "BEAM":
							int minAttack3 = magic - 2;
							beamDamage = (int)(Math.random()*5)+minAttack3;
							System.out.println("");
							System.out.println("You shot a laser beam at " +enemyName+ "and dealt " +beamDamage+ " DMG.");
							System.out.println("");
							enemyHealth = enemyHealth - beamDamage;
							System.out.println("The " +enemyName+ "'s health is now " +enemyHealth+ " HP. (Press Enter to Continue)");
							game.nextLine();
							beamGo = true;
							double beam = (int) (Math.random()*100)+1;
							if (beam <= 25){
								beamGo = false;
								beamDown = true;
								System.out.println("You just decreased the " +enemyName+ "'s attack DMG! (Press Enter to Continue)");
								game.nextLine();
							}
							choice = true;
							break;
						case "STATS":
							stats();
							break;
						default:
							System.out.println("INVALID COMMAND");
							break;
						}
					}
					break;
				}
				break;
			case "DEFEND":
				defenseCount = defenseCount +1;
				if (defenseCount > 2){
					defenseCount = 0;
				}
				System.out.println("You activated the shield, the enemy will have reduced attacks now. (Press Enter to Continue)");
				game.nextLine();
				break;
			case "STATS":

				stats();
				break;
			default:
				System.out.println("INVALID COMMAND");
				break;
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
			if (enemyAttack > 0 && (enemyHealth > 0)){
				if (iceDown == true){
					System.out.println("The enemy  could not attack. (Press Enter to Continue)");
				}else{
					if(defenseUp == true){
						defense = defense/2 +5;
						int minOuchAttack = enemyAttack - 2;
						ouchDamage = (int)((Math.random()*2)+minOuchAttack);
						health = health - ouchDamage;
						System.out.println(enemyName+ " dealt " +ouchDamage+ ". Your health is now " +health+ "HP. (Press Enter to Continue)");
						game.nextLine();
					}
					if (beamDown == true) {
						int minOuchAttack = enemyAttack - 2;
						ouchDamage = (int)((Math.random()*2)+minOuchAttack);
						health = health - ouchDamage;
						System.out.println(enemyName+ " dealt " +ouchDamage+ ". Your health is now " +health+ "HP. (Press Enter to Continue)");
						game.nextLine();
					} else {
						int minOuchAttack = enemyAttack - 2;
						ouchDamage = (int)((Math.random()*5)+minOuchAttack);
						health = health - ouchDamage;
						System.out.println(enemyName+ " dealt " +ouchDamage+ ". Your health is now " +health+ "HP. (Press Enter to Continue)");
						game.nextLine();
					}
				}
			} else {
				enemyDeath = true;
				System.out.println("Congratulations, you killed the " +enemyName+ ", good job.");
			}
			beamDown = false;
			iceDown = false;
			fireGo = false;
		}
	}
}