public class TheCharacter
{
	private String name;
	private int str;
	private int intellect;
	private int dex;
	private int HP;
	private int maxHP;
	private int exp;
	/**TheCharacter constructor*/
	public TheCharacter(String n, int s, int i, int d, int h, int m, int e, int g)
	{
		name = n;
		str = s;
		intellect = i;
		dex = d;
		HP = h;
		maxHP = m;
		exp = e;
		//gold = g;
	}
	public String convertHexToString(String hex)//converts a hex value to a string value in decimal form
	{
		StringBuilder newString = new StringBuilder();
		StringBuilder temp = new StringBuilder();
		for( int i=0; i<hex.length()-1; i+=2 )
		{
			String output = hex.substring(i, (i + 2));//puts the hex into groups of 2
		   
		    int number = Integer.parseInt(output, 16);//converts the hex to decimal
		    newString.append((char)number);//converts the int value to a char value
		    temp.append(number);  
		}
		return newString.toString();
	}
	public TheCharacter(String theLine)//TheCharacter constructor that takes a line of hex values
	{
		String hexName = theLine.substring(0,16);
		name = convertHexToString(hexName);
		String hexStr = theLine.substring(28,30);
		str = Integer.parseInt(hexStr,16);
		String hexDex = theLine.substring(30,32);
		dex = Integer.parseInt(hexDex,16);
		String hexInt = theLine.substring(32,34);
		intellect = Integer.parseInt(hexInt,16);
		String hexHP = theLine.substring(38,40) + theLine.substring(36,38);
		HP = Integer.parseInt(hexHP,16);
		String hexMaxHP = theLine.substring(42,44) + theLine.substring(40,42);
		maxHP = Integer.parseInt(hexMaxHP,16);
		String hexExp = theLine.substring(46,48) + theLine.substring(44,46);
		exp = Integer.parseInt(hexExp,16);
	}
	public String getName()
	{
		return name;
	}
	public int getStr()
	{
		return str;
	}
	public int getInt()
	{
		return intellect;
	}
	public int getDex()
	{
		return dex;
	}
	public int getHP()
	{
		return HP;
	}
	public int getMaxHP()
	{
		return maxHP;
	}
	public int getEXP()
	{
		return exp;
	}
	public void setName(String n)
	{
		name = n;
	}
	public void setStr(int s)
	{
		str = s;
	}
	public void setInt(int i)
	{
		intellect = i;
	}
	public void setDex(int d)
	{
		dex = d;
	}
	public void setHP(int h)
	{
		HP = h;
	}
	public void setMaxHP(int m)
	{
		maxHP = m;
	}
	public void setExp(int e)
	{
		exp = e;
	}
	//returns a string of the Character stats
	public String toString()
	{
		return "Character name: " + name + "\n" +
				"str: " + str + "\n" +
				"int: " + intellect + "\n" +
				"dex: " + dex + "\n" +
				"HP: " + HP + "\n" +
				"max HP: " + maxHP + "\n" +
				"Exp: " + exp + "\n";

	}	
}