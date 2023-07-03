package jenkins_Test;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		int sum=0;
		System.out.println("Enetr the number to check");
		Scanner sc=new Scanner(System.in);
		int no=sc.nextInt();
		int temp=no;
		while(no>0) {
			int r=no%10;
			sum=sum+(r*r*r);
			no=no/10;
			
		}
if (sum==temp) {
	System.out.println(temp+ " is Armstrong number");
}
else {System.out.println(temp+ " is not Armstrong number");
}
	}
}
