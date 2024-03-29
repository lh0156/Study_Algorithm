package programmers.lv1;

/**
 * 카카오톡 게임별의 하반기 신규 서비스로 다트 게임을 출시하기로 했다. 다트 게임은 다트판에 다트를 세 차례 던져 그 점수의 합계로 실력을 겨루는 게임으로, 모두가 간단히 즐길 수 있다.
 * 갓 입사한 무지는 코딩 실력을 인정받아 게임의 핵심 부분인 점수 계산 로직을 맡게 되었다. 다트 게임의 점수 계산 로직은 아래와 같다.
 *
 * 다트 게임은 총 3번의 기회로 구성된다.
 * 각 기회마다 얻을 수 있는 점수는 0점에서 10점까지이다.
 * 점수와 함께 Single(S), Double(D), Triple(T) 영역이 존재하고 각 영역 당첨 시 점수에서 1제곱, 2제곱, 3제곱 (점수1 , 점수2 , 점수3 )으로 계산된다.
 *
 * 옵션으로 스타상(*) , 아차상(#)이 존재하며 스타상(*) 당첨 시 해당 점수와 바로 전에 얻은 점수를 각 2배로 만든다. 아차상(#) 당첨 시 해당 점수는 마이너스된다.
 *
 * 스타상(*)은 첫 번째 기회에서도 나올 수 있다. 이 경우 첫 번째 스타상(*)의 점수만 2배가 된다. (예제 4번 참고)
 * 스타상(*)의 효과는 다른 스타상(*)의 효과와 중첩될 수 있다. 이 경우 중첩된 스타상(*) 점수는 4배가 된다. (예제 4번 참고)
 * 스타상(*)의 효과는 아차상(#)의 효과와 중첩될 수 있다. 이 경우 중첩된 아차상(#)의 점수는 -2배가 된다. (예제 5번 참고)
 * Single(S), Double(D), Triple(T)은 점수마다 하나씩 존재한다.
 * 스타상(*), 아차상(#)은 점수마다 둘 중 하나만 존재할 수 있으며, 존재하지 않을 수도 있다.
 * 0~10의 정수와 문자 S, D, T, *, #로 구성된 문자열이 입력될 시 총점수를 반환하는 함수를 작성하라.
 *
 * 1. 규칙은 숫자, 알파벳, 특문 순이다.
 * 2. for문을 돌면서 연산이 이루어져야 하는 트리거는 숫자가 나왔을때다.
 *  2.1. 숫자가 나왔을 때
 *      2.1.1. prevNum을 result에 더해준다.
 *      2.1.2. curNum을 prevNum에 저장한다.
 *      2.1.3. 해당 숫자를 curNum에 저장한다.
 *  2.2. 알파벳이 나왔을 때
 *      2.2.1. curNum에 알파벳을 곱해준다.
 *  2.3. 특수문자가 나왔을 때
 *      2.3.1. 만약 i가 2라면 curNum에 연산을 해준다.
 *      2.3.2. 아니면 curNum, prevNum에 연산을 해준다.
 * 3. 끝나고 prevNum와 curNum을 result에 더해준다.
 */
public class 다트게임 {

    public static int solution(String s) {
        int result = 0;
        int prevNum = 0;
        int curNum = 0;

        for(int i=0; i<s.length(); ++i) {
            char c = s.charAt(i);
            // 2.1. 숫자가 나왔을 때
            // 10일 때
            if (isNum(c)) {
                // 2.1.1. prevNum을 result에 더해준다.
                result += prevNum;
                // 2.1.2. curNum을 prevNum에 저장한다.
                prevNum = curNum;
                // 2.1.3. 해당 숫자를 curNum에 저장한다.
                if (c == 49 && s.charAt(i+1) == 48) {
                    curNum = 10;
                    i = i+1;
                } else {
                    curNum = c - 48;
                }
            // 2.2. 알파벳이 나왔을 때
            } else if (isAlphabetic(c)) {
                // 2.2.1. curNum에 알파벳을 곱해준다.
                if (c == 'S') {
                    curNum = (int) Math.pow(curNum, 1);
                } else if (c == 'D') {
                    curNum = (int) Math.pow(curNum, 2);
                } else {
                    curNum = (int) Math.pow(curNum, 3);
                }

            // 2.3. 특수문자가 나왔을 때
            } else {
                curNum = optionCalculator(curNum, c);

                if (c == '*' && i != 2) {
                    prevNum = optionCalculator(prevNum, c);
                }
            }
        }

        result = result + prevNum + curNum;
        return result;
    }

    public static int optionCalculator(int num, char c) {
        if (c == '*') {
            return num * 2;
        } else {
            return num * -1;
        }
    }

    private static boolean isAlphabetic(char c) {
        return Character.isAlphabetic(c);
    }

    private static boolean isNum(char c) {
        return Character.isDigit(c);
    }

    public static void main(String[] args) {
        System.out.println(solution("1S2D*3T"));
    }
}
