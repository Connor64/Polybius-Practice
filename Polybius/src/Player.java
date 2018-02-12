import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player {
	public static int health = 100;
	public static int wallet = 0;
	public int playerClass;
	Scanner game = new Scanner(System.in);
	public List<String> inventory = new ArrayList<String>();
}