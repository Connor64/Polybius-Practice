import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player {
	public static int health = 1000;
	public static int xp = 0;
	public static int wallet = 0;
	public int playerClass;
	public static boolean fire = true;
	public static boolean ice = true;
	public static boolean beam = true;
	Scanner game = new Scanner(System.in);
	public static List<String> inventory = new ArrayList<String>();
}