package inflearn.정렬과이분검색과결정알고리즘;

import java.util.Arrays;

/**
 * N개의 마구간이 수직선상에 있습니다. 각 마구간은 x1, x2, x3, ......, xN의 좌표를 가지며, 마구간간에 좌표가 중복되는 일은 없습니다.
 * 현수는 C마리의 말을 가지고 있는데, 이 말들은 서로 가까이 있는 것을 좋아하지 않습니다. 각 마구간에는 한 마리의 말만 넣을 수 있고,
 * 가장 가까운 두 말의 거리가 최대가 되게 말을 마구간에 배치하고 싶습니다.
 * C마리의 말을 N개의 마구간에 배치했을 때 가장 가까운 두 말의 거리가 최대가 되는 그 최대값을 출력하는 프로그램을 작성하세요.
 *
 * 예시 입력
 * 5 3
 * 1 2 8 4 9
 *
 * 예시 출력
 * 3
 */
public class 마구간정하기결정알고리즘 {

    public static int count(int[] arr, int dist) {
        int cnt = 1;
        int ep = arr[0];
        for(int i=1; i<arr.length; ++i) {
            if (arr[i]-ep >= dist) {
                cnt++;
                ep=arr[i];
            }
        }
        return cnt;
    }

    public static int solution(int[] arr, int horse) {
        int answer = 0;
        Arrays.sort(arr);
        int lt = 1;
        int rt = arr[arr.length-1];

        while(lt <= rt) {
            int mid = (lt+rt)/2;
            if(count(arr, mid) >= horse) {
                answer = mid;
                lt = mid +1;
            } else {
                rt = mid - 1;
            }
        }
        return answer;


    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 8, 4, 9};
        int horse = 3;

        System.out.println(solution(arr, horse));
    }

}
