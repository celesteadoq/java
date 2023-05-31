# java
my codes in java

jogo genius em java (incompleto)

package alooo;

import java.util.Random;
import java.util.Scanner;

public class Aaalo {

 public static void main(String[] args) {
		
	  int b = 3;
		int[] x;
		x = new int[5];
		int[] a;
		a = new int[5];
		preenche(a, b);
		preencher2(x);
		b += 3;
		while(verificar(x, a) == true) {
			preenche(a, b);
			preencher2(x);
			b += 3;
			
		}
	}
	public static int[] preenche(int[] a, int b) {
		Random rand = new Random();
		
		for(int i = 0; i<a.length; i++) {
			a[i] = rand.nextInt(1,b);
			System.out.print(a[i] + " - ");
		}
	
		return a;
	}
	public static int[] preencher2(int[] x) {
		Scanner sc = new Scanner(System.in);
	
		for(int i = 0; i<x.length; i++) {
			x[i] = sc.nextInt();
		}
		return x;
	}
	public static boolean verificar(int[] x, int[] a) {
		
		for(int i = 0; i<a.length; i++){
			if(x[i] == a[i]) {
				System.out.println("vc passou de nivel :D");
			}else {
				System.out.println("vc errou :c");
				System.exit(0);
			}	
		}
		return true;
	}
	

}
end code
