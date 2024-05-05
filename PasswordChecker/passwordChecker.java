package PasswordChecker;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class passwordChecker 
{
	public static String checker(String userID)
	{
		char[] pw=userID.toCharArray();
		boolean upper=false,lower=false,digit=false,special=false;
		Set<Character> set=new HashSet<Character>(Arrays.asList('!','?','@','#','$','%','^','&','*','-','+',')','('));
		for(int i=0;i<pw.length;i++)
		{
			if(Character.isLowerCase(pw[i])) lower=true;
			else if(Character.isUpperCase(pw[i])) upper=true;
			else if(Character.isDigit(pw[i])) digit=true;
			else if(set.contains(pw[i])) special=true;
		}
		if(pw.length>8 && lower && upper && digit && special) return "Strong";
		
		else if((pw.length>6 && pw.length<=8) && lower && upper && digit && special) return "Medium";
		
		else if(pw.length<=6 && lower && upper  && digit && special) return "Weak";
		
		else return "Invalid";
		
	}

}
