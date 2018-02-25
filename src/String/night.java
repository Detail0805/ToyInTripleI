package String;

public class night {

/*	public static void main(String[] args) {
		night.nightnight(5, 5);
	}
*/
	public static void nightnight(int v, int k) {

		for (int i = 1; i <= v; i++) {
			for (int j = 1; j <= k; j++) {
				System.out.print(i + "*" + j + "=" + i * j + " ");
				if ((i * j) < 10) {
					System.out.print(" ");
				}
			}
			System.out.println();
		}

		int i = 1;
		while (i <= v) {
			int j = 1;
			while (j <= k) {
				System.out.print(i + "*" + j + "=" + i * j + " ");
				j++;
				if ((i * j) < 10) {
					System.out.print(" ");
				}
			}
			System.out.println();
			i++;
		}

		System.out.println("================do while================");
		
		int o = 1;
		int p =1;
		do {
			 p =1;
			do {
				System.out.print(o + "*" + p + "=" + o * p + " ");
				p++;
			} while (p <= k);
			System.out.println();
			o++;
		} while (o <= v);

	}

}
