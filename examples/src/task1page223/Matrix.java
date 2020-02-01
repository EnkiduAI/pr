package task1page223;

import java.util.Arrays;
import java.util.Scanner;

public class Matrix implements Arithmetic{
	public int array[][];

	public Matrix() {
		Scanner sc = new Scanner(System.in);
		int n, m;
		
		System.out.print("������� ���������� ����� � �������: ");
		n = sc.nextInt(); 
		
		System.out.print("������� ���������� �������� � �������: ");
		m = sc.nextInt();
		
		array = new int[n][m];
		
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[i].length; j++) {
				//array[i][j] = 1;
				array[i][j] = (int)(Math.random() * (100 - 1 + 1) + 1);
			}
		}
	}
	
	
	
	
	@Override
	public String toString() {
		System.out.println("\n---------------���������� �������------------------------");
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j] + "\t");
			}
			System.out.println("\n\n");
		}
		
		
		return "";
	}




	@Override
	public void summa(Arithmetic ob) {
		System.out.println("����������� ����� summa");
		if(this.getClass().equals(ob.getClass()) == false) {
			System.out.println("������� ��������� � ������ �������, ����������� ����������");
			return;
		}
		Matrix m = (Matrix)ob;
		
		if(this.array.length != m.array.length || this.array[0].length != m.array[0].length) {
			System.out.println("������� �������� �� ���������, ����������� ����������");
			return;
		}
		
		
		System.out.println("\n---------------��������� �������------------------------");
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[i].length; j++) {
				System.out.print((this.array[i][j] + m.array[i][j]) + "\t");
			}
			System.out.println("\n\n");
		}
	}

	@Override
	public void compare(Arithmetic ob) {
		System.out.println("����������� ����� compare");
		if(this.getClass().equals(ob.getClass()) == false) {
			System.out.println("������� ��������� � ������ �������, ����������� ����������");
			return;
		}
		Matrix m = (Matrix)ob;
		
		if(this.array.length != m.array.length || this.array[0].length != m.array[0].length) {
			System.out.println("������� �������� �� ���������, �������� ����������");
			return;
		}
		
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[i].length; j++) {
				if(array[i][j] != m.array[i][j]) {
					System.out.println("������� ������");
					return;
				}
			}
		}
		
		System.out.println("������ ����������");
	}
	
	public void metod1() {
		System.out.println("����������� ����� metod1");
		Scanner sc = new Scanner(System.in);
		int i, j;
		
		do {
			System.out.println("������� i �� 0 �� " + (array.length-1) + ": ");
			i = sc.nextInt();
		}while(i < 0 || i > array.length-1);
		
		do {
			System.out.println("������� j �� 0 �� " + (array[0].length-1) + ": ");
			j = sc.nextInt();
		}while(j < 0 || j > array[0].length-1);
		
		System.out.println("array[" + i + "][" + j + "] = " + array[i][j]);
	}
	
	public void metod2() {
		System.out.println("����������� ����� metod2");
		Scanner sc = new Scanner(System.in);
		int k;
		System.out.print("������� ������ ���������������: ");
		k = sc.nextInt();
		
		System.out.println("\n---------------���������� ����������������� �������------------------------");
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j] * k + "\t");
			}
			System.out.println("\n\n");
		}
		
	}
	
}
