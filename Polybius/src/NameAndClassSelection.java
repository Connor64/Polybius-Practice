
import java.util.Scanner;

public class NameAndClassSelection {
	static Scanner game = new Scanner(System.in);
	static String name = "";
	static String classType;
	public static int strength, agility, magic, defense;
	Player playerOne = new Player();

	public String getNameMethod() {
		System.out.println("What is your name, adventurer?");
		name = game.nextLine();
		System.out.print("Hello, " + name);
		System.out.print(". ");
		return name;
	}

	public static String getClassType() {
		System.out.print("What class would you like to be? Classes - ");
		System.out.println("Knight, Sorcerer, Thief, or Swordsman");
		System.out.println("To see characteristics, type: 'About + Class' ");
		boolean classSelection = true;
		while (classSelection) {
			classType = game.nextLine();
			classType = classType.toUpperCase();

			switch (classType) {
			case "KNIGHT":
				classType = "Knight";
				strength = 4;
				defense = 6;
				agility = 2;
				magic = 1;
				classSelection = false;
				break;
			case "SORCERER":
				classType = "Sorcerer";
				strength = 2;
				defense = 3;
				agility = 3;
				magic = 7;
				classSelection = false;
				break;
			case "THIEF":
				classType = "Thief";
				strength = 2;
				defense = 2;
				agility = 6;
				magic = 1;
				classSelection = false;
				break;
			case "SWORDSMAN":
				classType = "Swordsman";
				strength = 6;
				defense = 4;
				agility = 4;
				magic = 0;
				classSelection = false;
				break;
			case "ABOUT KNIGHT":
				System.out.println("Knight: ");
				System.out.println("	Strength: 4");
				System.out.println("	Defense: 6");
				System.out.println("	Agility: 2");
				System.out.println("	Magic: 1");
				break;
			case "ABOUT SORCERER":
				System.out.println("Sorcerer: ");
				System.out.println("	Strength: 2");
				System.out.println("	Defense: 3");
				System.out.println("	Agility: 3");
				System.out.println("	Magic: 7");
				break;
			case "ABOUT THIEF":
				System.out.println("Thief: ");
				System.out.println("	Strength: 2");
				System.out.println("	Defense: 2");
				System.out.println("	Agility: 6");
				System.out.println("	Magic: 1");
				break;
			case "ABOUT SWORDSMAN":
				System.out.println("Swordsman ");
				System.out.println("	Strength: 6");
				System.out.println("	Defense: 4");
				System.out.println("	Agility: 4");
				System.out.println("	Magic: Incapable");
				break;
			default:
				System.out.println("INVALID RESPONSE");
				break;
			}
		}
		System.out.print("Alright, " + name);
		System.out.print(" the ");
		System.out.print(classType);
		System.out.println(" your journey begins now. ");
		return classType;
	}
}