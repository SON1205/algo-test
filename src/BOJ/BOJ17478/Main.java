package BOJ.BOJ17478;

import java.util.Scanner;

public class Main {
	static int N;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		System.out.println("��� �� ��ǻ�Ͱ��а� �л��� ������ �������� ã�ư� ������.");
		
		recursion(N);
	}
	
	static void recursion(int cnt) {
		print(N - cnt);
		System.out.println("\"����Լ��� ������?\"");
		print(N - cnt);
		System.out.println("\"�� ����. �������� �� �� ����⿡ �̼��� ��� ������ ����� ������ �־���.");
		print(N - cnt);
		System.out.println("���� ������� ��� �� ���ο��� ������ ������ �߰�, ��� �����Ӱ� ����� �־���.");
		print(N - cnt);
		System.out.println("���� ���� ��κ� �ǾҴٰ� �ϳ�. �׷��� ��� ��, �� ���ο��� �� ���� ã�ƿͼ� ������.\"");
		
		if (cnt == 1) {
			print(N + 1 - cnt);
			System.out.println("\"����Լ��� ������?\"");
			print(N + 1 - cnt);
			System.out.println("\"����Լ��� �ڱ� �ڽ��� ȣ���ϴ� �Լ����\"");
			for (int i = 0; i <= N; i++) {
				print(N - i);
				System.out.println("��� �亯�Ͽ���.");
			}
			return;
		}
		
		recursion(cnt - 1);
	}
	
	static void print(int cnt) {
		for (int i = 0; i < cnt; i++) {
			System.out.print("____");
		}
	}
}
