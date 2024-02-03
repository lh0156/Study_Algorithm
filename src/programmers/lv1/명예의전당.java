package programmers.lv1;

import java.util.*;

/**
 * "명예의 전당"이라는 TV 프로그램에서는 매일 1명의 가수가 노래를 부르고, 시청자들의 문자 투표수로 가수에게 점수를 부여합니다.
 * 매일 출연한 가수의 점수가 지금까지 출연 가수들의 점수 중 상위 k번째 이내이면 해당 가수의 점수를 명예의 전당이라는 목록에 올려 기념합니다.
 * 즉 프로그램 시작 이후 초기에 k일까지는 모든 출연 가수의 점수가 명예의 전당에 오르게 됩니다.
 *
 * k일 다음부터는 출연 가수의 점수가 기존의 명예의 전당 목록의 k번째 순위의 가수 점수보다 더 높으면, 출연 가수의 점수가 명예의 전당에 오르게 되고 기존의 k번째 순위의 점수는 명예의 전당에서 내려오게 됩니다.
 *
 * 이 프로그램에서는 매일 "명예의 전당"의 최하위 점수를 발표합니다.
 *
 * 예를 들어, k = 3이고, 7일 동안 진행된 가수의 점수가 [10, 100, 20, 150, 1, 100, 200]이라면, 명예의 전당에서 발표된 점수는 아래의 그림과 같이 [10, 10, 10, 20, 20, 100, 100]입니다.
 *
 * 1. 리스트 소팅할까 큐를 쓸까?
 *  1.1. 그냥 리스트 쓰자
 * 2. 리스트의 사이즈를 확인한다
 *  2.1. 리스트의 사이즈가 k보다 작으면 그냥 넣고 소팅
 *  2.2. k
 */
public class 명예의전당 {

    public static int[] solution(int k, int[] score) {
        Queue<Integer> queue = new PriorityQueue<>();
        int[] result = new int[score.length];

        for(int i=0; i<score.length; ++i) {
            queue.offer(score[i]);

            if (queue.size() > k) {
                queue.poll();
            }

            result[i] = queue.peek();
        }

        return result;
    }

    public static void main(String[] args) {
        for(int i : solution(3, new int[]{10, 100, 20, 150, 1, 100, 200})) {
            System.out.println(i);
        }
    }

}
