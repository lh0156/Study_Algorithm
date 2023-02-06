package baekjoon.b203_dataconstruct;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 접미사
 *
 * [문제]
 * 접미사 배열은 문자열 S의 모든 접미사를 사전순으로 정렬해 놓은 배열이다.
 *
 * baekjoon의 접미사는 baekjoon, aekjoon, ekjoon, kjoon, joon, oon, on, n 으로 총 8가지가 있고
 * 이를 사전순으로 정렬하면, aekjoon, baekjoon, ekjoon, joon, kjoon, n, on, oon이 된다.
 *
 * 문자열 S가 주어졌을 때, 모든 접미사를 사전순으로 정렬한 다음 출력하는 프로그램을 작성하시오.
 *
 * [입력]
 * baekjoon
 *
 * [결과]
 * aekjoon
 * baekjoon
 * ekjoon
 * joon
 * kjoon
 * n
 * on
 * oon
 */
public class Q11656 {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();
        String[] arr = new String[input.length()];

        for(int i=0; i<arr.length; ++i) {

            arr[i] = input.substring(i);

        }

        Arrays.sort(arr);

        for (String s : arr) {

            System.out.println(s);
        }

    }


}
