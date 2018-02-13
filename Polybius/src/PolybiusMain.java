import java.util.Scanner;

public class PolybiusMain {
	public static boolean visited = false;
	public static boolean kissed = false;
	public static boolean defeated = false;
	public static Scanner game = new Scanner(System.in);
	public static Player playerStats = new Player();
	public static void main(String args[]) throws InterruptedException {
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
				System.out.println("Balance: $" + balance);
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
				System.out.println("INVALID COMMAND");
				break;
			}
		}
	}

	private static void stats() {
		String stats = NameAndClassSelection.classType;
		int strength = NameAndClassSelection.strength;
		int defense = NameAndClassSelection.defense;
		int agility = NameAndClassSelection.agility;
		int magic = NameAndClassSelection.magic;
		int balance = playerStats.wallet;
		int health = playerStats.health;

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
		for (String item : playerStats.inventory) {
			if (item != "") {
				++lineNumber;
			}
			System.out.println(+lineNumber + "  ---  " + item);
		}
	}

	public static void Intro() {
		Scanner game = new Scanner(System.in);
		boolean go;
		System.out.println("You walk into a large arch, the entrance to the Star Festival, held every 100 years. Seems like there'd be some cake around here. (Press Enter to Continue)");
		game.nextLine();
		System.out.println("You look for your friend Daisy. She said that she was somewhere around here. (Options: Explore or Call Daisy)");
		while (go = true) {
			String daisy = game.nextLine().toUpperCase();
			switch (daisy) {
			case "EXPLORE":
				go = false;
				Daisy();
				break;
			case "CALL":
				System.out.println("Daisy did not pick up. (Options: Explore)");
				String nope = game.nextLine().toUpperCase();
				if (nope.equals("EXPLORE")) {
					go = false;
					Daisy();
				}
				break;
			case "CALL DAISY":
				System.out.println("Daisy did not pick up. (Options: Explore)");
				String nope1 = game.nextLine().toUpperCase();
				if (nope1.equals("EXPLORE")) {
					go = false;
					Daisy();
				}
				break;
			case "STATS":
				stats();
				break;
			default:
				System.out.println("INVALID COMMAND");
				break;
			}
		}
	}

	public static void Daisy() {
		boolean go;
		Scanner game = new Scanner(System.in);
		System.out.println("As you search for Daisy, you find a Letter on the ground... (Options: Grab or Leave)");
		while (go = true) {
			String grab = game.nextLine().toUpperCase();
			switch (grab) {
			case "GRAB":
				System.out.println("You added the Letter to your inventory. (Press Enter to Continue)");
				playerStats.inventory.add("Letter");
				go = false;
				carnival();
				break;
			case "LEAVE":
				System.out.println("You leave the letter on the ground, perhaps it belonged to someone else... (Press Enter to Continue");
				go = false;
				carnival();
				break;
			case "STATS":
				stats();
				break;
			default:
				System.out.println("INVALID COMMAND");
				break;
			}
		}
	}

	public static void carnival() {
		boolean booth2 = true, go = true, go2 = true, go3 = true, doki = true, atari = true, kirby = true, nintendo = true, punch = true;
		game.nextLine();
		System.out.println("You reach the middle of the carnival, it splits into 3 branches, which way would you like to go? (Forward, Left, Right)");	
		while (go == true) {
			int balance = playerStats.wallet;
			String direction = game.nextLine().toUpperCase();
			switch (direction) {
			case "LEFT":
				System.out.println("You see an old man off to the side of the branch, he seems a bit sketchy... talk to him anyway? (Y/N)");
				while (go2 == true) {
					String sketchy = game.nextLine().toUpperCase();
					switch (sketchy) {
					case "Y":
						System.out.println("As you approach, he notices you and motions for you to walk towards him");
						System.out.println("Old Man: Hey there, kid. I've got some cake. Would you like some? It only costs $15");
						System.out.println("Buy the cake? (Y/N)");
						while (go3 == true) {
							String cake = game.nextLine().toUpperCase();
							switch (cake) {
							case "Y":
								if (balance < 15) {
									System.out.println("Old Man: Oh, it looks like you can't afford it... come back to me once you've earned enough. (Press Enter to Continue)");
								} else {
									System.out.println("Old Man: Pleasure doin' business with ya. (Press Enter to Continue)");
									playerStats.inventory.add("Cake");
									playerStats.wallet = playerStats.wallet - 15;
								}
								go3 = false;
								carnival();
								break;
							case "N":
								System.out.println("Old Man: Oh... well if you change your mind, come back and talk to me. (Press Enter to Continue)");
								go3 = false;
								game.nextLine();
								System.out.println("You leave the old man's booth... (Press Enter to Continue)");
								carnival();
								break;
							case "STATS":
								stats();
								break;
							}
						}
						go2 = false;
						break;
					case "N":
						System.out.println("There is nothing of interest left down this path, you return to the center. (Press Enter to Continue)");
						go2 = false;
						carnival();
						break;
					case "STATS":
						stats();
						break;
					default:
						System.out.println("INVALID COMMAND");
						break;
					}
				}
			case "RIGHT":
				System.out.println("There are several booths lining the side. (Inquiry, Strength, Kissing, or type 'back' to go back to center)");
				while (booth2 == true) {
					String booth = game.nextLine().toUpperCase();
					switch (booth) {
					case "INQUIRY":
						if (visited == true) {
							System.out.println("Inquiry Man: You have already taken part in my game, now leave. (Press Enter to Continue)");
							game.nextLine();
							System.out.println("You return to the center of the festival to rethink your life choices... (Press Enter to Continue)");
							carnival();
						} else {
							System.out.println("A man, smiling, stands there waiting for you to approach.");
							System.out.println("Inquiry Man: Hello! Welcome to my inquiry booth. I will ask you a series of questions, if you answer them correctly, there will be a cash prize.");
							System.out.println("Begin quiz? (Y/N)");
							while(true) {
								String quiz = game.nextLine().toUpperCase();
								switch (quiz) {
								case "Y":
									System.out.println("Inquiry Man: Alright, sounds good. Remember, you must answer ALL questions correctly in order to win the prize");
									System.out.println("First Question: What game was rebranded as Super Mario Bros. 2 in America? (1 - Metroid | 2 - Doki Doki Panic | 3 - EarthBound | 4 - Rockman)");
									while (doki == true) {
										String mario = game.nextLine().toUpperCase();
										switch (mario) {
										case "1":
											System.out.println("Inquiry Man: Oof, tough luck. That's the wrong answer, Metroid saw its own release in America on August 6, 1986");
											System.out.println("You walk back to the center of the festival due to sheer stupidity... (Press Enter to Continue");
											carnival();
											break;
										case "2":
											System.out.println("Inquiry Man: Congragulations, you are (or most likely guessed) correctly!");
											System.out.println("Inquiry Man: Remember, you have completed 1 out of the 4 questions, you have 3 more to go. Next question... (Press Enter to Continue)");
											game.nextLine();
											System.out.println("Second Question: What company did Steve Jobs work for before he founded Apple? (1 - Nintendo | 2 - Honda | 3 - Sony | 4 - Atari)");
											while (atari == true) {
												String jobs = game.nextLine().toUpperCase();
												switch (jobs) {
												case "1":
													System.out.println("Inquiry Man: Incorrect, while Jobs had an appreciation for Nintendo, he never worked for the comapany");
													System.out.println("You walk back to the center of the festival due to sheer stupidity... (Press Enter to Continue");
													carnival();
													break;
												case "2":
													System.out.println("Inquiry Man: Falso, why would you ever think that Steve Jobs worked at a car company?");
													System.out.println("You walk back to the center of the festival due to sheer stupidity... (Press Enter to Continue");
													carnival();
													break;
												case "3":
													System.out.println("Inquiry Man: WRONG! Jobs created the, today rival company, to Samsung. He did not work for them.");
													System.out.println("You walk back to the center of the festival due to sheer stupidity... (Press Enter to Continue");
													carnival();
													break;
												case "4":
													System.out.println("Inquiry Man: Correcto! Jobs joined Atari in 1973 and wasn't liked much by his co-workers due to his strong odor.");
													System.out.println("Inquiry Man: You have now correctly answered 2 out of the 4 questions, you've got 2 more left to go. Next question... (Press Enter to Continue)");
													game.nextLine();
													System.out.println("Third Question: What was Kirby's original name? (1 - Popopo | 2 - Prince Fluff | 3 - Roller | 4 - Dedede");
													while (kirby == true) {
														String popopo = game.nextLine().toUpperCase();
														switch (popopo) {
														case "1":
															System.out.println("Inquiry Man: You've chosen... wisely. Popopo was the original name of Kirby, and the first game was originally called 'Twinkle Popo'");
															System.out.println("Inquiry Man: There is one question remaining, you've answered 3 correctly so far. (Press Enter to Continue)");
															game.nextLine();
															System.out.println("Fourth and Last Question: When was Nintendo founded? (1 - 1976 | 2 - 1749 | 3 - 1889 | 4 - 1980)");
															while (nintendo == true) {
																String founded = game.nextLine().toUpperCase();
																switch (founded) {
																case "1":
																	System.out.println("Inquiry Man: Way off, Nintendo was not founded in 1976.");
																	System.out.println("You walk back to the center of the festival due to sheer stupidity... (Press Enter to Continue");
																	carnival();
																	break;
																case "2":
																	System.out.println("Inquiry Man: ARE YOU KIDDING ME? Why would you ever think that Nintendo was founded in 1749?");
																	System.out.println("You walk back to the center of the festival due to sheer stupidity... (Press Enter to Continue");
																	carnival();
																	break;
																case "3":
																	System.out.println("Inquiry Man: Wow! You answered all 4 of my questions corretly. Now I have to do my part, here's $5, go wild...");
																	playerStats.wallet = playerStats.wallet +5;
																	System.out.println("$5 has been added to your balance. (Press Enter to Continue)");
																	game.nextLine();
																	System.out.println("You leave the man's booth, with a smile on your face... you totally just jipped that guy, you looked up all the answers on your phone. (Press Enter to Continue)");
																	carnival();
																	break;
																case "4":
																	System.out.println("Inquiry Man: Nope, nada, not even close. Nintendo was founded before 1980.");
																	System.out.println("You walk back to the center of the festival due to sheer stupidity... (Press Enter to Continue");
																	carnival();
																	break;
																case "STATS":
																	stats();
																	break;
																default:
																	System.out.println("INVALID COMMAND");
																	break;
																}
															}
														case "2":
															System.out.println("Inquiry Man: Incorrect, Prince Fluff was a side-character in the Kirby game, Kirby's Epic Yarn for the Wii");
															System.out.println("You walk back to the center of the festival due to sheer stupidity... (Press Enter to Continue");
															carnival();
															break;
														case "3":
															System.out.println("Inquiry Man: No, while Kirby does have a very prominent move of rolling in Kirby's Canvas Curse for the Wii U, his name was never 'Roller'");
															System.out.println("You walk back to the center of the festival due to sheer stupidity... (Press Enter to Continue");
															carnival();
															break;
														case "4":
															System.out.println("Inquiry Man: Have you EVER played a Kirby game? Dedede is the main villain of almost all Kirby games, while sometimes he is a side-character.");
															System.out.println("You walk back to the center of the festival due to sheer stupidity... (Press Enter to Continue");
															carnival();
															break;
														case "STATS":
															stats();
															break;
														default:
															System.out.println("INVALID COMMAND");
															break;
														}
													}
												}
											}
											break;
										case "3":
											System.out.println("Inquiry Man: You hecking dingus, Earthbound was an adventure game released on August 27, 1994 for the SNES, not the NES");
											System.out.println("You walk back to the center of the festival due to sheer stupidity... (Press Enter to Continue");
											carnival();
											break;
										case "4":
											System.out.println("Inquiry Man: Incorrect. Rockman, also known as MegaMan, was released on the Famicom in Japan on December 17, 1987");
											System.out.println("You walk back to the center of the festival due to sheer stupidity... (Press Enter to Continue");
											carnival();
											break;
										case "STATS":
											stats();
											break;
										default:
											System.out.println("INVALID COMMAND");
											break;
										}
									}
								case "N":
									System.out.println("Inquiry Man: Oh, okay... come back if you change your mind. (Press Enter to Continue)");
									game.nextLine();
									System.out.println("You leave the man's booth. (Press Enter to Continue)");
									game.nextLine();
									carnival();
									break;
								case "STATS":
									stats();
									break;
								default:
									System.out.println("INVALID COMMAND");
									break;
								}
							}
						}
					}
				}
			case "STRENGTH":
				if (defeated == true) {
					System.out.println("Buffita looks over at you with a piercing stare, you know better than to keep on going towards her. You turn around and go back to the center. (Press Enter to Continue");
					carnival();
				} else {
					System.out.println("You walk over to the second booth and see a punching bag and a trainer. The lady behind the counter is completely ripped, her bicep is bigger than your entire head.");
					System.out.println("Buffita: Hey! How'd you like to test your strength against this here punching bag? (Y/N)");
					while(punch == true) {
						String punching = game.nextLine().toUpperCase();
						switch (punching) {
						case "Y":
							System.out.println("Buffita: Alright, LET'S DO THIS!");
							System.out.println("You take a fighting stance against the punching bag. (Press Enter to Continue)");
							game.nextLine();
							try {
								CombatSystem.combat("Punching Bag", 10, 0);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							if (CombatSystem.enemyHealth <= 0) {
								System.out.println("Buffita: Oh, wow... you actually were able to beat my challenge... well, here's $5... go wild. (Press Enter to Continue)");
								playerStats.wallet = playerStats.wallet +5;
								game.nextLine();
								System.out.println("$5 was just added to your balance. (Press Enter to Continue)");
								game.nextLine();
								System.out.println("Buffita: Okay, now get the heck out of here. (Press Enter to Continue)");
								defeated = true;
								carnival();
								break;
							}	break;
						case "N":
							System.out.println("Buffita: Oh, well if you decide you want to take your anger out, come back. (Press Enter to Continue)");
							carnival();
							break;
						case "STATS":
							stats();
							break;
						default:	
							System.out.println("INVALID COMMAND");
							break;
						}
					}
				}


			case "KISSING":
				if (kissed == true) {
					System.out.println("As you walk toward her booth, she catches you in the corner of her eye and narrows her eyes. (Press Enter to Continue)");
					game.nextLine();
					System.out.println("Kisser: I already served you, you stuck-up, half-witted, scruffy-looking nerf herder! (Press Enter to Continue)");
					game.nextLine();
					System.out.println("She slaps you in the face and you run away from her booth, ashamed. (Press Enter to Continue)");
					carnival();
				}else {
					System.out.println("You walk up to the kissing booth slowly and see a young lady behind the counter. (Press Enter to Continue)");
					game.nextLine();
					System.out.println("Kisser: Ugh, do I have to kiss you? (Y/N)");
					while (true) {
						String kiss = game.nextLine().toUpperCase();
						switch(kiss) {
						case "Y":
							System.out.println("Kisser: Tell you what, how about I pay you $5 to not kiss me, okay? (Okay/Kiss Me Dangit)");
							while (true) {
								String kissme = game.nextLine().toUpperCase();
								switch(kissme) {
								case "OKAY":
									System.out.println("Kisser: Alright, here you go... now leave please.");
									playerStats.wallet = playerStats.wallet =5;
									System.out.println("$5 was added to your balance, but now you feel hollow inside... (Press Enter to Continue)");
									game.nextLine();
									System.out.println("You leave her booth, crying internally. (Press Enter to Continue)");
									kissed = true;
									carnival();
									break;
								case "KISS ME DANGIT":
									System.out.println("Kisser: You slimy piece of worm-ridden filth! (Press Enter to Continue)");
									game.nextLine();
									System.out.println("She takes a $5 bill, kisses it, and slaps you in the face with it. (Press Enter to Continue)");
									game.nextLine();
									playerStats.wallet = playerStats.wallet +5;
									System.out.println("$5 was added to your balance, but it doesn't heal your bruised face. (Press Enter to Continue)");
									kissed = true;
									game.nextLine();
									System.out.println("You get up and run from her booth, terrified for your life. (Press Enter to Continue)");
									carnival();
									break;
								case "STATS":
									stats();
									break;
								default:
									System.out.println("INVALID INPUT");
									break;
								}
							}
						case "N":
							System.out.println("Kisser, so am I not good enought to be kissed? Fine! Get out, leave! (Press Enter to Continue)");
							game.nextLine();
							System.out.println("You run away from her booth, confused as all heck. (Press Enter to Continue)");
							carnival();
							break;
						case "STATS":
							stats();
							break;
						default:
							System.out.println("INVALID INPUT");
							break;
						}
					}
				}
			case "BACK":
				System.out.println("You decide to head back the other way. (Press Enter to Continue)");
				carnival();
				break;
			case "STATS":
				stats();
				break;
			default:
				System.out.println("INVALID COMMAND");
				break;
			}
		}
	}
}
