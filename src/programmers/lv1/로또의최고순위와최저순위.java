package programmers.lv1;

import java.util.HashMap;
import java.util.Map;

/**
 * 로또 6/45(이하 '로또'로 표기)는 1부터 45까지의 숫자 중 6개를 찍어서 맞히는 대표적인 복권입니다. 아래는 로또의 순위를 정하는 방식입니다.
 *
 * 순위	당첨 내용
 * 1	6개 번호가 모두 일치
 * 2	5개 번호가 일치
 * 3	4개 번호가 일치
 * 4	3개 번호가 일치
 * 5	2개 번호가 일치
 * 6(낙첨)	그 외
 *
 * 로또를 구매한 민우는 당첨 번호 발표일을 학수고대하고 있었습니다.
 * 하지만, 민우의 동생이 로또에 낙서를 하여, 일부 번호를 알아볼 수 없게 되었습니다.
 * 당첨 번호 발표 후, 민우는 자신이 구매했던 로또로 당첨이 가능했던 최고 순위와 최저 순위를 알아보고 싶어 졌습니다.
 *
 * 알아볼 수 없는 번호를 0으로 표기하기로 하고, 민우가 구매한 로또 번호 6개가 44, 1, 0, 0, 31 25라고 가정해보겠습니다.
 * 당첨 번호 6개가 31, 10, 45, 1, 6, 19라면, 당첨 가능한 최고 순위와 최저 순위의 한 예는 아래와 같습니다.
 *
 * 당첨 번호	31	10	45	1	6	19	결과
 * 최고 순위 번호	31	0→10	44	1	0→6	25	4개 번호 일치, 3등
 * 최저 순위 번호	31	0→11	44	1	0→7	25	2개 번호 일치, 5등
 * 순서와 상관없이, 구매한 로또에 당첨 번호와 일치하는 번호가 있으면 맞힌 걸로 인정됩니다.
 * 알아볼 수 없는 두 개의 번호를 각각 10, 6이라고 가정하면 3등에 당첨될 수 있습니다.
 * 3등을 만드는 다른 방법들도 존재합니다. 하지만, 2등 이상으로 만드는 것은 불가능합니다.
 * 알아볼 수 없는 두 개의 번호를 각각 11, 7이라고 가정하면 5등에 당첨될 수 있습니다.
 * 5등을 만드는 다른 방법들도 존재합니다. 하지만, 6등(낙첨)으로 만드는 것은 불가능합니다.
 * 민우가 구매한 로또 번호를 담은 배열 lottos, 당첨 번호를 담은 배열 win_nums가 매개변수로 주어집니다. 이때, 당첨 가능한 최고 순위와 최저 순위를 차례대로 배열에 담아서 return 하도록 solution 함수를 완성해주세요.
 *
 * [풀이]
 * 1. win_nums과 lottos의 동일 숫자와 0을 구한다.
 * 2. 순위 결정 (7-당첨 내용이 순위이다)
 * 2.1. 0이 0개이면 동일 숫자만 당첨 내용으로 치환
 * 2.2. 아니면 동일 숫자 + 0갯수 / 동일 숫자 로 치환
 */
public class 로또의최고순위와최저순위 {

    public int[] solution(int[] lottos, int[] win_nums) {
        Map<Integer, Boolean> map = new HashMap<>();
        int zeroCount = 0;
        int equalCount = 0;

        for(int lotto : lottos) {
            if(lotto == 0) {
                zeroCount++;
                continue;
            }

            map.put(lotto, true);
        }

        for(int win_num : win_nums) {
            if (map.containsKey(win_num)) {
                equalCount++;
            }
        }

        int minNum = 7 - (zeroCount + equalCount);
        int maxNum = 7 - (equalCount);

        if(minNum > 6) minNum = 6;
        if(maxNum > 6) maxNum = 6;

        return new int[]{minNum, maxNum};
    }

    public static void main(String[] args) {
        로또의최고순위와최저순위 solution = new 로또의최고순위와최저순위();
        for(int i : solution.solution(new int[]{44, 1, 0, 0, 31, 25}, new int[]{31, 10, 45, 1, 6, 19})) {
            System.out.println(i);
        }
    }
}
