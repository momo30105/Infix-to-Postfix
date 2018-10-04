package い锣;

import static java.lang.System.out;
import java.util.LinkedList;
import java.util.Scanner;

public class aaa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		String input = scanner.next();

		int length = input.length();

		StringBuilder output = new StringBuilder(); // 程璶块﹃
		LinkedList<Character> stack = new LinkedList<>();// 笲衡じ

		for (int a = 0; a < length; a++) {
			char now = input.charAt(a);
			int x = priority(now);
			if (a > 0) {
				if (stack.isEmpty()) { // 璝Stack琌	
					if (x == 0) { //计钡块 笲衡メ秈stack
						output.append(now);
					} else if (x == 1) { //  '('
						stack.add(now);
					} else if (x == 2) { // + or - 
						stack.add(now);
					} else if (x == 3) { // * or /
						stack.add(now);
					}
				}
				else { //璝stackぃ琌
					int y = priority(stack.getLast());
					if (x == 0) { // 璝计
						if (y==1) { //STACK程'('玥块计
							output.append(now);
						}else{	//STACK程ぃ'(' 玥块计㎝pop stack
							output.append(now);
							output.append(stack.getLast());
							stack.removeLast();
						}
					} else if (x == 2) { // * or /
						if (x > y) { //瞷纔舦ゑstack程  玥push秈stack
							stack.add(now);
						} else {  //pop
							output.append(stack.getLast());
							stack.removeLast();
						}
					} else if (x == 3) { // + or -
						if (x > y) { //瞷纔舦ゑstack程  玥push秈stack
							stack.add(now);
						} else {
							output.append(stack.getLast());
							stack.removeLast();
						}
					} else if (x == 1) {// '(' 钡push
						stack.add(now);
					} else if (x == 4) {
						while (!stack.isEmpty()) { 
							if (stack.getLast() == '(') {//暗pop笿(ゎ 
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
	static int priority(char c) { // 璹纔舦
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
