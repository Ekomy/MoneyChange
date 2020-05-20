import java.util.*;

public class Change {
	public static void main(String[] args) {
		
	Scanner scan = new Scanner(System.in).useLocale(Locale.US);;
	boolean showMustGoOn=true;
	
	while(showMustGoOn)
		{
		System.out.println("Enter the Price");
		double price = scan.nextDouble();
		System.out.println("Enter the money you have");
		double money= scan.nextDouble();
		compare(price,money);
		
		System.out.println("\nExit press : 0 (if you wanna stay just press any number)");
		int controler = scan.nextInt();
		
		if(controler==0) {
			showMustGoOn=false;
			System.out.println("Have a nice day!!!");
		}
			
	}
	
	scan.close();
	}

	private static void compare(double price, double money) {
		
		price = calcAlg(price);
		money = calcAlg(money);
		
		if(price>money){
			System.out.println("Not enough money offered.");
		}
		else if(price==money) {
			System.out.println("Exact amount.");

		}
		else {
			
			coinAlgorithm(money-price);
		}
		
	}

	private static double calcAlg(double number) {
		
		number = number*100;
		number=number+0.0001;
		/* the reason i have this nonsense adding
		 * just because when i say mult 27.01*100
		 * it does 26.99998 so i fixed with very simple way
		 * (just for example it never mult with 100 correctly)
		 */
		if(number%5==0) {
			return number;
		}
		else if(number%5<3) {
			number = number-(number%5);
			return number;
		}
		else if(number%5>=3) {
			number = number+(5-(number%5));
			return number;
		}
		return number;
		
	}

	private static void coinAlgorithm(double number) {
		
		int[] dolar = new int[]{0,2000,1000,500,200,100};
		int[] cent = new int[]{0,50,20,10,5};
		int number2 = (int) number;
		for(int i=1; i<dolar.length;i++) {
			if(number2/dolar[i]!=0) {
			System.out.print("$"+dolar[i]/100 + "*"+ number2/dolar[i] +"  ");
			number2=number2%dolar[i];
			}
		}
		for(int i=1; i<cent.length;i++) {
			if(number2/cent[i]!=0) {
			System.out.print("c"+cent[i] + "*"+ number2/cent[i] +"  ");
			number2=number2%cent[i];
		}
		}
	}

	
}
