import java.util.Scanner;
import java.util.Random;

public class CombatSystem {
	public static Scanner game = new Scanner(System.in);
	public static int punchDamage;
	public static int strength = NameAndClassSelection.strength;
	public static int defense = NameAndClassSelection.defense;
	public static int agility = NameAndClassSelection.agility;
	public static int magic = NameAndClassSelection.magic;
	public static Random damage = new Random();
	public static boolean enemyDeath = false;
	public static int punchingBag = 1;
	public static int health = Player.health;
	
	public static void combat(String enemyName, int enemyHealth, int enemyAttack) {

		System.out.print("You have the first move. ");
		while (!enemyDeath) {
			System.out.println("What would you like to do? (Punch, Run, Magic)");
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
			if(enemyHealth < 0){
				enemyDeath = true;
				System.out.println("Congratulations, you killed the " +enemyName+ ", good job.");
			}
			if (enemyAttack > 0){
				System.out.println(enemyName+ " dealt " +enemyAttack+ ". Your health is now " +health);
			}
		}
	}
}