package inflearn.greedy;

/**
 * 오늘은 새 학기 새로운 반에서 처음 시작하는 날이다. 현수네 반 학생은 N명이다. 현수는 각 학생들의 친구관계를 알고 싶다.
 *
 * 모든 학생은 1부터 N까지 번호가 부여되어 있고, 현수에게는 각각 두 명의 학생은 친구 관계가 번호로 표현된 숫자쌍이 주어진다.
 *
 * 만약 (1, 2), (2, 3), (3, 4)의 숫자쌍이 주어지면 1번 학생과 2번 학생이 친구이고, 2번 학생과 3번 학생이 친구, 3번 학생과 4번 학생이 친구이다.
 * 그리고 1번 학생과 4번 학생은 2번과 3번을 통해서 친구관계가 된다.
 * 학생의 친구관계를 나타내는 숫자쌍이 주어지면 특정 두 명이 친구인지를 판별하는 프로그램을 작성하세요.
 *
 * 두 학생이 친구이면 “YES"이고, 아니면 ”NO"를 출력한다.
 *
 * [입력 예시]
 * 1 2
 * 2 3
 * 3 4
 * 1 5
 * 6 7
 * 7 8
 * 8 9
 *
 * 3 8
 *
 * [예시 출력]
 * NO
 */
public class UnionFind알고리즘3 {

    static int[] personInfo = new int[10];

    public static void main(String[] args) {
        for(int i=0; i<personInfo.length; ++i) {
            personInfo[i] = i;
        }

        union(1, 2);
        union(2, 3);
        union(3, 4);
        union(1, 5);
        union(6, 7);
        union(7, 7);
        union(8, 9);

        if (find(3) == find(8)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    public static void union(int target, int source) {
        int targetNum = find(target);
        int sourceNum = find(source);

        if (targetNum != sourceNum) {
            personInfo[target] = sourceNum;
        }
    }

    public static int find(int target) {
        if (personInfo[target] == target) {
            return target;
        } else {
            return find(personInfo[target]);
        }
    }
}
