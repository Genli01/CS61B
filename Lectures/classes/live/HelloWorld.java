public class HelloWorld {

	public static void main(String[] args) {

		System.out.println("Hello World!");
		System.out.println("ahahahahah");
		Dog D1 = new Dog(100);
		D1.makeNoise();
		for (int i = 1; i < 9; i++) {
			System.out.println(fib(i));
		}
		System.out.println(fib(7));

	}

	public static int fib (int n) {
		int f0 = 0;
		int f1 = 1;


		if (n == 1) {
			return f1;
		}
		if (n == 0) {
			return f0;
		}
		else return fib(n-1) + fib (n-2);

	}

//	public static void main(String[]args) {
//		System.out.println(fib(3));
//	}
}



