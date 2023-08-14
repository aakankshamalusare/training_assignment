
public class DoWhileLoopSeries {

	public static void main(String[] args) {
		
		/*
		 * 1.Generate the Series : 2,4,6,8,10,12,14,16,18,20
		 */
		
		 System.out.print("Series: ");
		 
		 int i= 1;

		 do{
			 
			 System.out.print(2*i+" ");
			 i++;
		
		 }while(i<=10);
		 
		/*
		 * 2.Generate the Series : 9,18,27,36,45,54,63,72,81,90
		 */
			
		System.out.print("\nSeries: ");
		
		i=1;

		 do{
				 
			System.out.print(9*i+" ");
			i++;
		 
		 }while(i<=10);	 
		 
		
		/*
		 * 3.Generate the Series : 1,-2,3,-4,5,-6,7,-8,9,-10
		 */
				
		System.out.print("\nSeries: ");
		
		i=1;

		do{
			
			if(i%2!=0)
			
				System.out.print(i+" ");
			else
				System.out.print("-"+i+" ");
			
			i++;
		
		}while(i<=10);
		
		
		
		/*
		 * 4.Generate the Series : 5,10,15,20,25,30,35,40,45,50
		 */
			
		System.out.print("\nSeries: ");

		i=1;
		
		do{
				 
			System.out.print(5*i+" ");
			i++;
		
		}while(i<=10);
			
		 
		 
		 /*
		  * 5.Generate the Series : 1,10,100,1000
		  */
				
		System.out.print("\nSeries: ");

		i=1;
		
		do{
					 
			System.out.print(i+" ");
			i*=10;
			
		}while(i<=1000);	 
		 
		 
		 /*
		  * 6.Generate the Series : 1,3,6,10,15,21,28,36,45
		  */
				
		System.out.print("\nSeries: ");

		int a = 0;
		i=1;
		
		do{
			
			System.out.print((a+i)+" ");
			a = a+i;
			i++;
			
		}while(i<=9);	
		
		
		/*
		 * 7.Generate the Series : 8,16,24,32,40,48,56,64,72,80
		 */
			
		System.out.print("\nSeries: ");

		i=1;
		
		do{
				 
			System.out.print(8*i+" ");
			i++;
		
		}while(i<=10);	 
		 
		 
		 /*
		  * 8.Generate the Series : 0,1,1,2,3,5,8,13,21
		  */
		 
		 a=0;
		 i=1;
		 int b = 1,c=0;
				
		System.out.print("\nSeries: ");

		do{
					
			System.out.print(a+" ");
			c=a+b;
			a=b;
			b=c;
			
			i++;
			 
		}while(i<=9);	 
			 
		 /*
		  * 9.Generate the Series : 1,4,9,16,25,36,49,64,72,81
		  */
				
		System.out.print("\nSeries: ");
		
		i=1;

		do{
					
			System.out.print(i*i+" ");
			i++;
			 
		} while(i<=10);
		 
		/*
		 * 10.Generate the Series : 3,6,9,12,15,18,21,24,27,30
		 */
			
		System.out.print("\nSeries: ");
		
		i=1;

		do{
				 
			System.out.print(3*i+" ");
			i++;
			 
		 }while(i<=10);		 
			
		 
		 /*
		  * 11.Generate the Series : 7,14,21,28,35,42,49,56,63,70
		  */
				
			
		 System.out.print("\nSeries: ");
		 
		 i=1;

		do{
					 
				
			 System.out.print(7*i+" ");
			 i++;
				 
		 }while(i<=10); 	 
			
		 /*
		  * 12.Generate the Series : 4,8,12,16,20,24,28,32,36,40
		  */
				
			
		 System.out.print("\nSeries: ");
		 
		 i=1;

		 do{
					 
				
			 System.out.print(4*i+" ");
			 i++;
				 
		 }while(i<=10);		 
		 
		 /*
		  * 13.Generate the Series :10,20,30,40,50,60,70,80,90,100
		  */
				
			
		 System.out.print("\nSeries: ");
		 
		 i=1;

		 do{
					 
				
			 System.out.print(10*i+" ");
			 i++;
				 
		 }while(i<=10);			
		 
		 
		 /*
		  * 14.Generate the Series : 1,2,3,4,5,4,3,2,1
		  */
				
			
		 System.out.print("\nSeries: ");
		 
		 a=0;
		 i=1;

		do{
					 
			if(i<=5)
				a++;
			else
				a--;
			 
			System.out.print(a+" ");
			i++;
				 
		 }while(i<10);		
		 
		 
		 /*
		  * 15.Generate the Series : 6,12,18,24,30,36,42,48,54,60
		  */
				
			
		 System.out.print("\nSeries: ");
		 
		 i=1;

		do{
					 
				
			 System.out.print(6*i+" ");
			 i++;
				 
		 } while(i<=10);

	}

}
