public class cpucheck {
	static boolean v, d1 ,d2;
	boolean checkD2(char ch, char arr[][])
	{
		int i, j;
		int count = 0;
		for(i = 2; i > 0 ; i--)
        {
			for(j = 0; j < 2 ; j++)
			{
				if(arr[i][j] == arr[i - 1][j+1])
	       		{
	       			if(arr[i][j] != ' ')
	       			{
	       			 count++;
	       			}
	       		}
			}
				
       	}
       	if(count==2)
   		{
   			return true;
   		}
       	return false;
        
	}
	boolean checkD1(char ch, char arr[][])
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
   			return true;
   		}
       	return false;
        
	}
	boolean checkV(char ch, char arr[][])
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
   			return true;
   		}
       	count = 0;
        }
		return false;
	}
	boolean checkH(char ch, char arr[][])
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
            
   			return true;
   		}
       	count = 0;
        }
	    v = checkV('O', arr);
        d1 = checkD1('O', arr);
        d2 = checkD2('O', arr);
		if(v == true || d1 == true || d2 == true)
		{
			return true;
		}
		return false;
	}

}
