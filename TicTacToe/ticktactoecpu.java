import java.util.Random;

public class ticktactoecpu {
	static int rnd2;
	String srr[] = { "00","01","02","10","11","12","20","21","22"};
    String cpu(char arr[][])
    {
    	cpucheck co = new cpucheck();
    	int i, j;
    	int c = 0;
    	char trr[][] = new char[3][3];
    	for(i = 0; i < 3; i++)
        {
       	 for(j = 0; j < 3; j++)
       	 {
       		 trr[i][j]=arr[i][j];
       	 }
        }
    	for(i = 0; i < 3; i++)
        {
       	 for(j = 0; j < 3; j++)
       	 {
       		 if(trr[i][j] != 'O' && trr[i][j] != 'X')
       		 {
       			 trr[i][j] = 'X';
       			boolean ans1 = co.checkH('X',trr);
       			boolean ans2 = co.checkV('X',trr);
       			boolean ans3 = co.checkD1('X',trr);
       			boolean ans4 = co.checkD2('X',trr);
       			 if(ans1 == true||ans2 == true||ans3 == true||ans4 == true)
       			 {
       				 String s = String.valueOf(i) + String.valueOf(j);
       				  c++;
   					 return s;
   				 }
       			 
       				  trr[i][j] = ' ';
       			
       		 }
       	 }
       	
        }
    	
    	if(c == 0) 
    	{
    	rnd2 = new Random().nextInt(srr.length);
    	for(i = 0; i < srr.length; i++)
        {
    		int rnd = new Random().nextInt(srr.length);
        	int t = Integer.parseInt(srr[rnd]);
    		int row = t / 10;
    		int col = t % 10;
	        if(arr[row][col] == ' ')
	       	{
	       		return srr[rnd];
	       	}
	       				
        }
    	}
    	return srr[rnd2];
    	
    }
	public static void main(String[] args)
	{

	}

}
