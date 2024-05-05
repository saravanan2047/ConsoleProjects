package EmailVerifier;

import java.util.Scanner;

public class EmailVerification 
{
	public static void main(String[] args) 
	{
		Scanner scan=new Scanner(System.in);
		System.out.println("Ente the email :");
		String str=scan.next();      //sarvana1235@gmail.com
		int pos=str.lastIndexOf("@");
		boolean stat=true;
		int dot=str.lastIndexOf(".");
		
		if(pos!=-1  && pos-1>0 && str.charAt(pos-1)!='.' && str.charAt(pos-1)!='@'   && !str.substring(0,pos).matches("-?\\d+(\\.\\d+)?") && !str.startsWith(".")) // checking whether email starts with dot or it only has special character or
		{
			for(int i=0;i<pos;i++)
			{
				if(str.charAt(i)>='a' && str.charAt(i)<='z' || str.charAt(i)>='A' && str.charAt(i)<='Z'
										|| str.charAt(i)>=0 && str.charAt(i)<=9  )
					stat=true;
				else if(str.charAt(i)=='.' && str.charAt(+1)=='.') stat=false;
				else if((int)str.charAt(i)>=32 && (int)str.charAt(i)<=47) stat= false;
				else
				{
					stat=false;
					break;
				}
				
			}
			if(str.substring(dot+1) instanceof String) stat=true; // checking whether the last is string 
			else stat=false;
		}
		else stat=false;
		for(int i=pos+1;i<dot;i++) // checking whether a special character is present b/w @ to .
		{
			int c=(int)str.charAt(i);
			if(c>=32 && c<=47 && Integer.parseInt(str.substring(i,i+1))>=0 && Integer.parseInt(str.substring(i,i+1))<=9) 
			{
			stat=false;
			break;
			}
		}
		if(stat)
			System.out.println("Email is valid");
		else System.out.println("Email is not valid");
	}

}
/*package com.librarymanagement.validate;

public class LibraryValidate {
    public boolean validEmail(String email){
        if(!Character.isLetter(email.charAt(0)) || !Character.isLetter(email.charAt(email.length()-1))){
            return false;
        }
        String[] arr=email.split("@");
        if(arr.length != 2){
            return false;
        }
        String first=arr[0];
        if(first.charAt(first.length()-1)=='.'){
            return false;
        }
        for(int j=0;j<first.length();j++){
            char k=first.charAt(j);

            if((Character.isLetterOrDigit(k) && Character.isLowerCase(k)) || k=='.'){

                if(j<arr[0].length()-1 && k=='.' && arr[0].charAt(j+1) =='.'){
                    return false;
                }
            }
        }
        String second=arr[1];
        int count=0;
        if(second==null){return false;}
        if(!Character.isLetter(second.charAt(0))){
            return false;
        }
        for(int i=0;i<second.length();i++){
            char k=second.charAt(i);
            if(k=='.'){
                count++;
            }
            if(Character.isLowerCase(k) || k=='.'){
                if(i<second.length()-1 && k=='.' && second.charAt(i+1) =='.'){
                    return false;
                }
            }
            else{
                return false;
            }
        }
        if(count<1 || count>2){
            return false;
        }
        return true;
    }
    public boolean validPhoneNo(long phoneNo){
        String phoneNumber=String.valueOf(phoneNo);
        if(phoneNumber.length()==10)
            return true;
        return false;
    }

}*/
