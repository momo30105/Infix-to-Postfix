package ��������;

import static java.lang.System.out;
import java.util.LinkedList;
import java.util.Scanner;

public class aaa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		String input = scanner.next();

		int length = input.length();

		StringBuilder output = new StringBuilder(); // �s�̫�n��X���r��
		LinkedList<Character> stack = new LinkedList<>();// �s�B�⤸

		for (int a = 0; a < length; a++) {
			char now = input.charAt(a);
			int x = priority(now);
			if (a > 0) {
				if (stack.isEmpty()) { // �YStack�O�Ū�	
					if (x == 0) { //�Ʀr������X �A�B��l��istack
						output.append(now);
					} else if (x == 1) { //  '('
						stack.add(now);
					} else if (x == 2) { // + or - 
						stack.add(now);
					} else if (x == 3) { // * or /
						stack.add(now);
					}
				}
				else { //�Ystack���O�Ū�
					int y = priority(stack.getLast());
					if (x == 0) { // �Y���Ʀr
						if (y==1) { //STACK�̫�@�Ӭ�'('�h��X�Ʀr
							output.append(now);
						}else{	//STACK�̫�@�Ӥ���'(' �h��X�Ʀr�Mpop stack
							output.append(now);
							output.append(stack.getLast());
							stack.removeLast();
						}
					} else if (x == 2) { // * or /
						if (x > y) { //�{�b���u���v��stack�̫�@�Ӥj  �hpush�istack
							stack.add(now);
						} else {  //pop
							output.append(stack.getLast());
							stack.removeLast();
						}
					} else if (x == 3) { // + or -
						if (x > y) { //�{�b���u���v��stack�̫�@�Ӥj  �hpush�istack
							stack.add(now);
						} else {
							output.append(stack.getLast());
							stack.removeLast();
						}
					} else if (x == 1) {// '(' ����push
						stack.add(now);
					} else if (x == 4) {
						while (!stack.isEmpty()) { 
							if (stack.getLast() == '(') {//��pop�A����J��(���� 
								stack.removeLast();
								break;
							} else {
								output.append(stack.getLast());
								stack.removeLast();
							}
						}
					}			
				}
			} else {
				if (x == 0) {
					output.append(now);
				} else if (x == 1) {
					stack.add(now);
				}
			}
		}
		System.out.println(output);
	}
	static int priority(char c) { // �q�u���v
		if (c == '+' || c == '-') {
			return 3;
		} else if (c == '*' || c == '/') {
			return 2;
		} else if (c == '(') {
			return 1;
		} else if (c == ')') {
			return 4;
		} else {
			return 0;
		}
	}
}
