
import java.util.Scanner;

public class PolybiusMain {
	public static Player playerStats = new Player();

	public static void main(String args[]) throws InterruptedException {
		Scanner game = new Scanner(System.in);
		boolean next;
		NameAndClassSelection userInputName = new NameAndClassSelection();
		System.out.println("Basements & Bugs");
		System.out.println("Game by Nontendo");
		Thread.sleep(1500);
		System.out.println("Game Load...");
		Thread.sleep(1500);

		System.out.println("Ready Player One? (Y/N)");

		String start = game.nextLine().toUpperCase();

		if (start.equals("Y") || start.equals("YES")) {
			System.out.println("Game Start... ");
			System.out.println("Welcome, to the world of Glaciorbis!");
		} else {
			System.exit(0);
		}

		userInputName.getNameMethod();
		userInputName.getClassType();

		String stats = NameAndClassSelection.classType;
		int strength = NameAndClassSelection.strength;
		int defense = NameAndClassSelection.defense;
		int agility = NameAndClassSelection.agility;
		int magic = NameAndClassSelection.magic;
		int balance = playerStats.wallet;

		System.out.println("At any point, you can type 'stats' to view stats");
		System.out.println("");
		System.out.println("Type 'Begin' to start");

		while (true) {
			String input = game.nextLine().toUpperCase();
			switch (input) {
			case "STATS":
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
				System.out.println("Balance: $" +balance);
				System.out.println("");
				System.out.println("Inventory:");
				int lineNumber = 0;
				for (String item : playerStats.inventory) {
					if (item != "") {
						++lineNumber;
					}
					System.out.println(+lineNumber + "  ---  " + item);
				}
				break;
			case "BEGIN":
				Intro();
				break;
			default:
				System.out.println("Invalid Command");
				break;
			}
		}
	}

	public static void Intro() {
		Scanner game = new Scanner(System.in);
		System.out.println(
				"You walk into a large arch, the entrance to the Star Festival, held every 100 years. Seems like there'd be some cake around here. (Enter any key to continue)");
		while (true) {
			String wowza = game.nextLine().toUpperCase();
			if (wowza == "STATS") {
				String stats = NameAndClassSelection.classType;
				int strength = NameAndClassSelection.strength;
				int defense = NameAndClassSelection.defense;
				int agility = NameAndClassSelection.agility;
				int magic = NameAndClassSelection.magic;
				int balance = playerStats.wallet;

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
				System.out.println("Balance: $" +balance);
				System.out.println("");
				System.out.println("Inventory:");
				int lineNumber = 0;
				for (String item : playerStats.inventory) {
					if (item != "") {
						++lineNumber;
					}
					System.out.println(+lineNumber + "  ---  " + item);
				}
			}
			System.out.println(
					"You look for your friend Daisy. She said that she was somewhere around here. (Options: Explore or Call Daisy)");
			while (true) {
				String daisy = game.nextLine().toUpperCase();
				switch (daisy) {
				case "EXPLORE":
					Daisy();
					break;
				case "CALL":
					System.out.println("Daisy did not pick up. (Options: Explore)");
					String nope = game.nextLine().toUpperCase();
					if (nope.equals("EXPLORE")) {
						Daisy();
					}
					break;
				case "CALL DAISY":
					System.out.println("Daisy did not pick up. (Options: Explore)");
					String nope1 = game.nextLine().toUpperCase();
					if (nope1.equals("EXPLORE")) {
						Daisy();
					}
					break;
				case "STATS":
					String stats = NameAndClassSelection.classType;
					int strength = NameAndClassSelection.strength;
					int defense = NameAndClassSelection.defense;
					int agility = NameAndClassSelection.agility;
					int magic = NameAndClassSelection.magic;
					int balance = playerStats.wallet;

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
					System.out.println("Balance: $" +balance);
					System.out.println("");
					System.out.println("Inventory:");
					int lineNumber = 0;
					for (String item : playerStats.inventory) {
						if (item != "") {
							++lineNumber;
						}
						System.out.println(+lineNumber + "  ---  " + item);
					}
					break;
				default:
					System.out.println("Invalid Command");
					break;
				}
			}
		}
	}

	public static void Daisy() {
		Scanner game = new Scanner(System.in);
		System.out.println("As you search for Daisy, you find a Letter on the ground... (Options: Grab or Leave)");
		while (true) {
			String grab = game.nextLine().toUpperCase();
			switch (grab) {
			case "GRAB":
				System.out.println("You added the Letter to your inventory.");
				playerStats.inventory.add("Letter");
				break;
			case "LEAVE":
				System.out.println("You leave the letter on the ground, perhaps it belonged to someone else...");
				break;
			case "STATS":
				String stats = NameAndClassSelection.classType;
				int strength = NameAndClassSelection.strength;
				int defense = NameAndClassSelection.defense;
				int agility = NameAndClassSelection.agility;
				int magic = NameAndClassSelection.magic;
				int balance = playerStats.wallet;

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
				System.out.println("Balance: $" +balance);
				System.out.println("");
				System.out.println("Inventory:");
				int lineNumber = 0;
				for (String item : playerStats.inventory) {
					if (item != "") {
						++lineNumber;
					}
					System.out.println(+lineNumber + "  ---  " + item);
				}
				break;
			default:
				System.out.println("Invalid Command");
				break;
			}
			System.out.println(
					"You reach the middle of the carnival, it splits into 3 branches, which way would you like to go? (Forward, Left, Right)");
			while (true) {
				String direction = game.nextLine().toUpperCase();
				switch (direction) {
				case "LEFT":
					System.out.println("You see an old man off to the side of the branch, he seems a bit sketchy... talk to him anyway? (Y/N)");
					while (true) {
						String sketchy = game.nextLine().toUpperCase();
						switch (sketchy) {
						case "Y":
							System.out.println("As you approach, he notices you and motions for you to walk towards him");
							System.out.println("Old Man: Hey there, kid. I've got some cake. Would you like some? It only costs $15");
							System.out.println("Buy the cake? (Y/N)");
							while (true) {
								String cake = game.nextLine().toUpperCase();
								switch (cake) {
								case "Y":
								}
							}
						}
					}
				}
			}
		}
	}
}