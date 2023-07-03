package jenkins_Test;



public class Test {
	public static void main(String[] args) {
		int no=123456789;
		int count=0;
		int r;
		while(no>0) {
			no=no/10;
			count++;
		}
		System.out.println(count);

	}
}
