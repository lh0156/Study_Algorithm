package inflearn.스텍과큐;

import java.util.Scanner;
import java.util.Stack;

/**
 * 1. 올바른 괄호
 * 설명
 *
 * 괄호가 입력되면 올바른 괄호이면 “YES", 올바르지 않으면 ”NO"를 출력합니다.
 *
 * (())() 이것은 괄호의 쌍이 올바르게 위치하는 거지만, (()()))은 올바른 괄호가 아니다.
 *
 *
 * 입력
 * 첫 번째 줄에 괄호 문자열이 입력됩니다. 문자열의 최대 길이는 30이다.
 *
 *
 * 출력
 * 첫 번째 줄에 YES, NO를 출력한다.
 */
public class 올바른괄호2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String word = scan.nextLine();

        Stack<Character> stack = new Stack<>();

        for(int i=0; i<word.length(); ++i) {
            if (word.charAt(i) == '(') {
                stack.push('(');
            } else {
                if (stack.pop() != '(') {
                    System.out.println("NO");
                    return;
                }
            }
        }

        if (stack.isEmpty()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }


    }
}
