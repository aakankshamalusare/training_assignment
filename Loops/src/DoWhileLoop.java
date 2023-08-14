
public class DoWhileLoop {

	public static void main(String[] args) {
		
		/*
		 * 1. Write a  program to print 1 to 25 numbers
		 */
		
		System.out.println("Numbers From 1 - 25");
		
		int i=1;
		
		do{
			
			System.out.print(i + " ");
			i++;
		}while(i<=25);
		
		
		
		/*
		 * 2.  Write a  program to print 25 to 1 numbers
		 */
		
		System.out.println("\nNumbers From 25 - 1");
		
		i=25;
		
		do{
			
			System.out.print(i + " ");
			i--;
		}while(i>0);
		
		
		/*
		 * 3. Write a program to print 1 to 100 odd numbers
		 */
		
		System.out.println("\nOdd numbers in 1 - 100");
		
		i=1;
		
		do{
			
			if(i%2!=0)
				System.out.print(i+ " ");
			
			i++;
			
		}while(i<=100);
		
		
		/*
		 * 4. Write a program to print 1 to 100 Even numbers
		 */
		
		System.out.println("\nEven numbers in 1 - 100");
		
		i=1;
		
		do{
			
			if(i%2==0)
			  System.out.print(i+ " ");
			
			i++;
			
		}while(i<=100);
		
		
		/*
		 * 5. Write a program to print sum of 1-50 odd numbers
		 */
		
		System.out.print("\nSum of 1-50 odd numbers : ");
		
		int sum = 0;
		i=1;
		
		do{
			
			if(i%2!=0)
				sum+=i;
			i++;
			
		}while(i<=50);
		
		System.out.print(sum);
		
		
		
		/*
		 * 6. Write a program to print sum of 1-50 even numbers
		 */
		
		System.out.print("\nSum of 1-50 even numbers : ");
		
		 sum = 0;
		 i=1;
		
		 do{
			
			if(i%2==0)
			    sum+=i;
			i++;
			
		}while(i<=50);
		
		System.out.print(sum);
		
		
		/*
		 * 7. Write a program to print -45 to -45 numbers
		 */
		
		System.out.println("\nNumbers from -45 - +45 : ");
		
		i=-45;
		
		do{
			
			System.out.print(i+" ");
			i++;
			
		}while(i<=45);
		
		
		/*
		 * 8. Write a program to print 50 to 100 numbers
		 */
		
		System.out.println("\nNumbers from 50 - 100 : ");
		
		i=50;
		
		do{
			
			System.out.print(i+" ");
			i++;
			
		}while(i<=100);
		
		
		/*
		 * 9. Write a program to print sum of even and odd numbers
		 */
		
		System.out.print("\nSum of even and odd numbers from 1 - 100 : ");
		
		sum =0;
		i=1;
		
		do{
			
			sum+=i;
			i++;
			
		}while(i<=100);
		
		System.out.print(sum);
		
		
		/*
		 * 10. Write a program to print even and odd numbers
		 */
	
		System.out.println("\nEven and odd numbers");
		
		i=1;
		
		do{
			
			if(i%2!=0) {
				
				System.out.println("Odd- "+i);
			}else {
				
				System.out.println("Even- "+i);
				
			}
			i++;
		}while(i<=100);
		
		
		/*
		 * 11. Write a  program to print 1 to 100 numbers
		 */
		
		System.out.println("Numbers From 1 - 100");
		
		i=1;
	
		do{
			
			System.out.print(i + " ");
			i++;
		}while(i<=100);
		
		
		
		
		/*
		 * 12.  Write a  program to print 100 to 1 numbers
		 */
		
		System.out.println("\nNumbers From 100 - 1");
		
		i=100;
		
		do{
			
			System.out.print(i + " ");
			i--;
		}while(i>0);
		
		
		/*
		 * 13. Write a program to print 30 to 50 numbers
		 */
		
		System.out.println("\nNumbers from 30 - 50 : ");
		
		i=30;
		
		do{
			
			System.out.print(i+" ");
			i++;
			
		}while(i<=50);
		
		
		/*
		 * 14. Write a program to print count of even no from 1 to 25
		 */
		
		System.out.print("\nCount of even numbers between 1-25 : ");
		
		sum=0;
		i=1;
		
		do{
			
			if(i%2==0)
				
				sum++;
			i++;
		}while(i<=25);
		
		System.out.print(sum);
		
		
		/*
		 * 15. Write a program to print count of odd no from 1 to 25
		 */
		
		System.out.print("\nCount of odd numbers between 1-25 : ");
		
		sum=0;
		i=1;
		
		do{
			
			if(i%2!=0)
				
				sum++;
			
			i++;
		}while(i<=25);
		
		System.out.print(sum);
		

	}

}
