package programmers.lv1;

/**
 * 네오는 평소 프로도가 비상금을 숨겨놓는 장소를 알려줄 비밀지도를 손에 넣었다.
 * 그런데 이 비밀지도는 숫자로 암호화되어 있어 위치를 확인하기 위해서는 암호를 해독해야 한다.
 * 다행히 지도 암호를 해독할 방법을 적어놓은 메모도 함께 발견했다.
 *
 * 지도는 한 변의 길이가 n인 정사각형 배열 형태로,
 * 각 칸은 "공백"(" ") 또는 "벽"("#") 두 종류로 이루어져 있다.
 *
 * 전체 지도는 두 장의 지도를 겹쳐서 얻을 수 있다.
 * 각각 "지도 1"과 "지도 2"라고 하자.
 *
 * 지도 1 또는 지도 2 중 어느 하나라도 벽인 부분은 전체 지도에서도 벽이다.
 * 지도 1과 지도 2에서 모두 공백인 부분은 전체 지도에서도 공백이다.
 *
 * "지도 1"과 "지도 2"는 각각 정수 배열로 암호화되어 있다.
 * 암호화된 배열은 지도의 각 가로줄에서 벽 부분을 1, 공백 부분을 0으로 부호화했을 때
 * 얻어지는 이진수에 해당하는 값의 배열이다.
 *
 *
 * [입력 예제]
 * 매개변수	값
 * n	    5
 * arr1	    [9, 20, 28, 18, 11]
 * arr2	    [30, 1, 21, 17, 28]
 *
 * 출력	    ["#####","# # #", "### #", "# ##", "#####"]
 *
 * 매개변수	값
 * n	6
 * arr1	[46, 33, 33 ,22, 31, 50]
 * arr2	[27 ,56, 19, 14, 14, 10]
 * 출력	["######", "### #", "## ##", " #### ", " #####", "### # "]
 *
 * [풀이]
 * 1. 숫자를 이진법으로 변경
 *  1.1. 이진법으로 변경하는 건 직접 할까?
 * 2. answer에 그에 해당하는 값을 할당
 * 3. arr2도 동일하게 진행해서 덮어 씀
 */
public class 비밀지도 {

    public String changeBinary(int num, int length) {
        String answer = "";

        while (num > 0) {
            if (num % 2 == 1) {
                answer = "#" + answer;
            } else {
                answer = " " + answer;
            }

            num = num / 2;
        }

        int diff = length - answer.length();

        if (diff > 0) {
            for(int i=0; i<diff; ++i) {
                answer = " " + answer;
            }
        }


        return answer;
    }

    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[arr1.length];

        for (int i=0; i<arr1.length; ++i) {
            String s = changeBinary(arr1[i], arr1.length);
            answer[i] = s;
        }

        for (int i=0; i<arr2.length; ++i) {
            String s = changeBinary(arr2[i], arr1.length);

            StringBuilder sb = new StringBuilder(answer[i]);


            for(int j=0; j<sb.length(); ++j) {
                if (sb.charAt(j) == ' ' && s.charAt(j) == '#') {
                    sb.setCharAt(j, '#');
                }
            }

            answer[i] = sb.toString();
        }
        return answer;
    }

    public static void main(String[] args) {
        비밀지도 solution = new 비밀지도();


        for (String s : solution.solution(5, new int[]{9, 20, 28, 18, 11}, new int[]{30, 1, 21, 17, 28})) {
            System.out.println(s);
        }
    }

}
