import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;
import java.io.FileInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.*;
import java.lang.Object;
public class main
{
	public static void main(String[] args) throws IOException
	{
		Scanner reader = new Scanner(System.in);
		Boolean looping = true;
		String oldFile = readTheFile();
		String inHex = convertToHex(oldFile);//converts contents of file into a string in hex
		ArrayList<TheCharacter> characters = new ArrayList<>();
		int weirdOffsetThing = 0;
		for (int i=0;i<16;i++)
		{
			//creates theCharacter objects for each character, however there was a small issue that I could not figure  
			//out regarding the offsets shifting
			if(i==1)
				weirdOffsetThing=2;
			characters.add(new TheCharacter(inHex.substring((i*64)+weirdOffsetThing,((i+1)*64)+weirdOffsetThing)));
		}
		while(looping)//keeps looping until 'q' is pressed to quit
		{
			String newValueHex;
			options();//options function
			System.out.print("Please enter a key: ");
			String option = reader.next();
			if(option.equals("q"))
			{
				System.out.println("hope you had fun cheating this game");
				looping = false;
			}
			else if(option.equals("z"))//show stats
			{
				for (int i=0;i<16;i++) {
					System.out.println(characters.get(i).toString());
				}
			}
			else if(option.equals("c"))//changes a character stat
			{
				boolean validName = true;
				System.out.print("Please enter the name ('player' if it is your avatar) of the character you "
								 + "would like to change (in lowercase): ");
				String name = reader.next();
				int characterOffset=0;
				//sets the character offset based off of the character name
				if(name.equals("player")) 
					characterOffset = 0;				
				else if(name.equals("shamino"))
					characterOffset=32;
				else if(name.equals("iolo"))
					characterOffset=64;
				else if(name.equals("mariah"))
					characterOffset=96;
				else if(name.equals("geoffrey"))
					characterOffset=128;
				else if(name.equals("jaana"))
					characterOffset=160;
				else if(name.equals("julia"))
					characterOffset=192;
				else if(name.equals("dupre"))
					characterOffset=224;
				else if(name.equals("katrina"))
					characterOffset=256;
				else if(name.equals("sentri"))
					characterOffset=288;
				else if(name.equals("gwenno"))
					characterOffset=320;
				else if(name.equals("johne"))
					characterOffset=352;
				else if(name.equals("gorn"))
					characterOffset=384;
				else if(name.equals("macharacterOffsetwell"))
					characterOffset=416;
				else if(name.equals("toshi"))
					characterOffset=448;
				else if(name.equals("saduj"))
					characterOffset=480;
				else
				{
					System.out.println("Sorry, that was not a valid input :(");
					validName=false;
				}
				if (validName=true)
				{
					System.out.print("To change the strength enter s." + "\n" +
									   "To change the intellect enter i." + "\n" + 
									   "To change the dex enter d." + "\n"
									   + "To change the HP enter h." + "\n"
									   + "To change the Max HP enter m." + "\n"
									   + "To change the experience enter e." + "\n"
									   + "Enter the key of the character stat you would like to change: ");
					int statOffset = 0;
					String statToChange = reader.next();//reads in the proposed stat to be changed
					//finds the offset of the stat that needs to be changed relative to the characterOffset
					if (statToChange.equals("s"))
						statOffset = characterOffset + 28;					
					else if (statToChange.equals("i"))
						statOffset = characterOffset + 32;					
					else if (statToChange.equals("d"))
						statOffset = characterOffset + 30;					
					else if (statToChange.equals("h")) 
						statOffset = characterOffset + 36;					
					else if (statToChange.equals("m")) 						
						statOffset = characterOffset + 40;		
					else if (statToChange.equals("e")) 
						statOffset = characterOffset + 44;					
					else
					{
						System.out.println("Sorry, that was not a valid input :(");
						continue;
					}
					System.out.print("Enter what you would like to change that stat to: ");
					int newStatValue = reader.nextInt();
					//if the proposed stat change is outside the bounds
					if ((newStatValue > 99 &&(statToChange.equals("i") || statToChange.equals("s") || 
						statToChange.equals("d"))) || (newStatValue > 999 &&(statToChange.equals("h") || 
						statToChange.equals("m"))) || newStatValue > 9999 &&  statToChange.equals("e")) {
						System.out.println("Sorry, that was not a valid input. Value was too high :(");
						continue;
					}//for the intellect,strength, and dexterity stat changes
					else if (statToChange.equals("i") || statToChange.equals("s") || statToChange.equals("d")){
						newValueHex = Integer.toHexString(newStatValue);
						inHex = inHex.substring(0,statOffset) + newValueHex + inHex.substring(statOffset+2);
					}//for the hp, max hp, and exp stat changes
					else if (statToChange.equals("h") || statToChange.equals("m") || statToChange.equals("e")) {
						newValueHex = Integer.toHexString(newStatValue);
						inHex = inHex.substring(0,statOffset) + newValueHex.substring(2) + newValueHex.substring(0,2) 
								+ inHex.substring(statOffset+4);
					}
				}
			
			}
			else if(option.equals("i"))//changes the value of the items
			{
				System.out.print("To change the amount of keys enter: k" + "\n" +
						"To change the amount of keys enter: k" + "\n" +
						"To change the amount of skull keys enter: s" + "\n" +
						"To change the amount of gems enter: g." + "\n" +
						"To change the amount of Black Badges enter: b" + "\n" +
						"To change the amount of Magic Carpets enter: m" + "\n" +
						"To change the amount of Magic Axes enter: a" + "\n" +
						"Enter the key of the item you would like to change: ");
				int itemOffset = 0;//the location of the item that needs to be changed
				String statToChange = reader.next();
				if (statToChange.equals("k")) 
					itemOffset = 1037;				
				else if (statToChange.equals("s"))
					itemOffset = 1047;					
				else if (statToChange.equals("g")) 
					itemOffset = 1039;				
				else if (statToChange.equals("b")) 
					itemOffset = 1073;				
				else if (statToChange.equals("m")) 						
					itemOffset = 1045;		
				else if (statToChange.equals("a"))  
					itemOffset = 1153;	
				else
				{
					System.out.println("Sorry, that was not a valid input :(");
					continue;
				}
				System.out.print("Enter how many of the item you would like: ");
				int newItemValue = reader.nextInt();//what the new value of the item will be
				newValueHex = Integer.toHexString(newItemValue);
				inHex = inHex.substring(0,itemOffset) + newValueHex + inHex.substring(itemOffset+2);
		
			}
			else if(option.equals("g"))//changes how much gold the player has
			{
				System.out.print("Enter how much gold you should have: ");
				int gold = reader.nextInt();
				newValueHex = Integer.toHexString(gold);
				inHex = inHex.substring(0,1032) + newValueHex.substring(2) + newValueHex.substring(0,2) 
				+ inHex.substring(1036);
			}
			else
			{
				System.out.println("Sorry, that was not a valid input :(");
			}
		}
		String stuff = convertFromHex(inHex);
		writeTheFile(stuff);
	}
	public static void options()//prints out the options for the user
	{
		System.out.println("Welcome to Ultima V game changer" + "\n" +
						   "You will be prompted to type in lower case keys in order to select what you want to do"
						   + "\n" + "To view a all characters' stats, enter: z" + "\n"
						   + "To change the value of a specific character stat, enter: c" + "\n"
						   + "To change the value of how many of a specific item you have, enter: i" + "\n"
						   + "To change how much gold you have, enter: g" + "\n"
						   + "To quit, enter: q" + "\n");
	}
	public static void writeTheFile(String str) throws IOException//writes the string to the SAVED.gam file
	{
		try (OutputStream outputStream = new FileOutputStream("E:\\School\\Lab2\\Ultima_5\\SAVED.gam")) 
		{
			char[] ch=str.toCharArray();
			for (int i =0; i<ch.length;i++) 
				outputStream.write((int) ch[i]);
		}catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	public static String readTheFile() throws IOException//reads the file and returns a string of the contents of it
	{
		String theString = "";
		try (InputStream inputStream = new FileInputStream("E:\\School\\Lab2\\Ultima_5\\SAVED.gam")) 
		{
			int byteRead;
			while ((byteRead = inputStream.read()) != -1) 
				theString += (char) byteRead;
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return theString.toString();
	}	
	public static String convertToHex(String oldText)//converts the contents of the file to hex
	{
        StringBuilder hex = new StringBuilder();
        StringBuilder result = new StringBuilder();
        char[] ch=oldText.toCharArray();
        for (int i = 0; i <ch.length;i++)
        	hex.append(String.format("%02X", (int) ch[i]));
        result.append(hex);
        return result.toString();
    }
	public static String convertFromHex(String oldHex)//converts from hex to the original format of the file
	{
		String str = "";
	    for(int i=0;i<oldHex.length();i+=2)
	    {
	        String s = oldHex.substring(i, (i + 2));
	        int decimal = Integer.parseInt(s, 16);
	        str = str + (char) decimal;
	    }       
	    return str;
    }
}
