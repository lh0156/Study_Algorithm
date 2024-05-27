package inflearn.투포인터;

/**
 * 0과 1로 구성된 길이가 N인 수열이 주어집니다. 여러분은 이 수열에서 최대 k번을 0을 1로 변경할 수 있습니다. 여러분이 최대 k번의 변경을 통해 이 수열에서 1로만 구성된 최대 길이의 연속부분수열을 찾는 프로그램을 작성하세요.
 *
 * 만약 길이가 길이가 14인 다음과 같은 수열이 주어지고 k=2라면
 *
 * 1 1 0 0 1 1 0 1 1 0 1 1 0 1
 *
 * 여러분이 만들 수 있는 1이 연속된 연속부분수열은
 * 이며 그 길이는 8입니다.
 *
 * 입력
 * 첫 번째 줄에 수열의 길이인 자연수 N(5<=N<100,000)이 주어집니다.
 * 두 번째 줄에 N길이의 0과 1로 구성된 수열이 주어집니다.
 *
 * 출력
 * 첫 줄에 최대 길이를 출력하세요.
 *
 * [풀이]
 * 1. 두개의 포인터를 생성한다.
 *  1.1. lt, rt
 * 2. 0번 인덱스부터 lt를 선언해서 돌고, rt는 그 다음부터 갯수를 세알려 나간다.
 * 3. 0을 3번 만나게 되면 lt와 rt를 다시 리셋해준다.
 *
 */
public class 최대길이연속부분수열2 {

    static int[] arr = new int[]{1, 1, 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1};
    public static void main(String[] args) {

        int resultSum = 0;

        int lt = 0;
        int zeroCount = 0;

        for(int rt=0; rt<arr.length; ++rt) {
            if (arr[rt] == 0) {
                zeroCount++;
            }

            while (zeroCount > 2) {
                if (arr[lt] == 0) zeroCount--;
                lt++;
            }

            resultSum = Math.max(resultSum, rt-lt+1);
        }
        System.out.println(resultSum);

    }
}
