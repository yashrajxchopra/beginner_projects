import java.util.Scanner;

public class tictactoe {
	int i, j;
	static char arr[][] = new char [3][3];
	boolean v, d1 ,d2;
	boolean checkD2(char ch)
	{
		int i, j;
		int count = 0;
		for(i = 2; i > 0 ; i--)
        {
			for(j = 0; j < 2 ; j++)
			{
				if(arr[i][j] == arr[i - 1][j+1])
	       		{
	       			if(arr[i][j] != ' '&& arr[i][j] == ch)
	       			{
	       			 count++;
	       			}
	       		}
			}
				
       	}
       	if(count==2)
   		{
       		gamestate(arr);
       		System.out.println("d2");
   			return true;
   		}
       	return false;
        
	}
	boolean checkD1(char ch)
	{
		int i;
		int count = 0;
		for(i = 0; i < 2 ; i++)
        {
       		if(arr[i][i] == arr[i + 1][i+1])
       		{
       			if(arr[i][i] != ' ')
       			{
       			count++;
       			}
       		}
       	 }
       	if(count == 2)
   		{
       		gamestate(arr);
       		System.out.println("d1");
   			return true;
   		}
       	return false;
        
	}
	boolean checkV(char ch)
	{
		int i,j;
		int count = 0;
		for(j = 0; j <= 2; j++)
        {
       	 for(i = 0; i < 2; i++)
       	 {
       		if(arr[i][j] == arr[i + 1][j])
       		{
       			if(arr[i][j] != ' ')
       			{
       			count++;
       			}
       		}
       		
       	 }
       	if(count == 2)
   		{
       		gamestate(arr);
       		System.out.println("v");
   			return true;
   		}
       	count = 0;
        }
		return false;
	}
	boolean checkH(char ch)
	{
		int i,j;
		int count = 0;
		for(i = 0; i <= 2; i++)
        {
       	 for(j = 0; j < 2; j++)
       	 {
       		if(arr[i][j] == arr[i][j + 1])
       		{
       			if(arr[i][j] != ' ')
       			{
       			count++;
       			}
       		}
       		
       	 }
       	if(count == 2)
   		{
       		gamestate(arr);
       		System.out.println("h");
   			return true;
   		}
       	count = 0;
        }
		v = checkV(ch);
        d1 = checkD1(ch);
        d2 = checkD2(ch);
		if(v == true || d1 == true || d2 == true)
		{
			return true;
		}
		return false;
	}
	void input(int x, int in)
	{
		Scanner sc = new Scanner(System.in);
		char ch = ' ';
		String p ="";
		if(x == 0 || x % 2 == 0 )
		{
			ch = 'X';
			p = "1P";
		}
		if(x % 2 != 0)
		{
			ch = 'O';
		    p = "2P";
		}
		String move = " ";
		System.out.println("Enter location at which you want to place your move " +p +"(" +ch+ ")" +" :");
		if(in == 1)
		{
		  move = sc.next();
		}
		else
		{
			ticktactocpu obb = new ticktactocpu();
			if(x == 0 || x % 2 == 0)
			{
				move = sc.next();
			}
			else if(x % 2 != 0)
			{
			   move = obb.cpu(arr);
			}
		}
		int t = Integer.parseInt(move);
		int row = t / 10;
		int col = t % 10;
		if(move.equals("00")||move.equals("01")||move.equals("02")||move.equals("10")||move.equals("11")||move.equals("12")||move.equals("20")||move.equals("21")||move.equals("22"))
		{
			if(arr[row][col] == 'X' || arr[row][col] == 'O')
			{
				System.out.println("Invalid move: Try Again");
				input(x, in);
			}
			else if(arr[row][col] != 'X' || arr[row][col] != 'O')
			{
		    arr[row][col] = ch;
		    boolean stat = checkH(ch);
		    if(stat == true)
		    {
		    	System.out.println("Winner is " +ch);
		    	System.exit(0);
		    }
			gamestate(arr);
			}
		}
		else
		{
			System.out.println("Invalid move: Try Again");
			input(x, in);
		}
		
		
	}
	void gamestate(char arr[][])
	{
		System.out.println("  0   1   2");
		int c = 0;
		for(i = 0; i < 3; i++)
        {
			System.out.print(c++);
       	 for(j = 0; j < 3; j++)
       	 {
       		 System.out.print(" " +arr[i][j] + " ");
       		 if(j < 2)
       		 {
       			 System.out.print("|");
       		 }
       	 }
       	 
       	 
       	 if(i == 0 || i == 1)
       	 {
       		 System.out.println();
       		 System.out.println(" -----------");
       	 }
       	 else
       	 {
       	    System.out.println();
       	 }
       	 
        }
	}

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
         tictacto go = new tictacto();
         int i, j;
         for(i = 0; i < 3; i++)
         { 
        	 for(j = 0; j < 3; j++)
        	 {
        		 arr[i][j] = ' ';
        	 }
         }
         go.gamestate(arr);
         System.out.println("Enter playing mode: (1) Vs 2 Player");
         System.out.println("                    (2) Vs Computer");
         int in = sc.nextInt();
         if(in != 1 && in != 2)
         {
        	 System.out.println("Invalid choice.");
        	 System.exit(0);
         }
         for(i = 0 ; i < 9; i++)
         {
        	go.input(i, in);
         }
         if(i > 8)
         {
        	 System.out.println("DRAW");
         }
         
         
	}

}
