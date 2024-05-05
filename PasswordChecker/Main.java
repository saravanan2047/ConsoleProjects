package PasswordChecker;

public class Main
{
	public static void main(String[] args) 
	{
		password pw =new password();
		Login  lg =new Login( pw.getinfo() );
	}

}
