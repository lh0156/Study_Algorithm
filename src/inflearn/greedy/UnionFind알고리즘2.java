package inflearn.greedy;

/**
 * 설명
 *
 * 오늘은 새 학기 새로운 반에서 처음 시작하는 날이다. 현수네 반 학생은 N명이다. 현수는 각 학생들의 친구관계를 알고 싶다.
 * 모든 학생은 1부터 N까지 번호가 부여되어 있고, 현수에게는 각각 두 명의 학생은 친구 관계가 번호로 표현된 숫자쌍이 주어진다.
 * 만약 (1, 2), (2, 3), (3, 4)의 숫자쌍이 주어지면 1번 학생과 2번 학생이 친구이고, 2번 학생과 3번 학생이 친구, 3번 학생과 4번 학생이 친구이다.
 * 그리고 1번 학생과 4번 학생은 2번과 3번을 통해서 친구관계가 된다.
 * 학생의 친구관계를 나타내는 숫자쌍이 주어지면 특정 두 명이 친구인지를 판별하는 프로그램을 작성하세요.
 * 두 학생이 친구이면 “YES"이고, 아니면 ”NO"를 출력한다.
 *
 *
 * 입력
 * 첫 번째 줄에 반 학생수인 자연수 N(1<=N<=1,000)과 숫자쌍의 개수인 M(1<=M<=3,000)이 주어지고,
 *
 * 다음 M개의 줄에 걸쳐 숫자쌍이 주어진다.
 * 마지막 줄에는 두 학생이 친구인지 확인하는 숫자쌍이 주어진다.
 *
 * 출력
 * 첫 번째 줄에 “YES"또는 "NO"를 출력한다.
 *
 * 1 2
 * 2 3
 * 3 4
 * 1 5
 * 6 7
 * 7 8
 * 8 9
 * 3 8
 */
public class UnionFind알고리즘2 {

    static int[] unionArr = new int[10];

    public static void main(String[] args) {
        UnionFind알고리즘2 solution = new UnionFind알고리즘2();
        solution.unionArrInit();
        solution.union(1, 2);
        solution.union(2, 3);
        solution.union(3, 4);
        solution.union(1, 5);
        solution.union(6, 7);
        solution.union(7, 8);
        solution.union(8, 9);

        if (solution.find(3) == solution.find(8)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    private void unionArrInit() {
        for(int i=0; i<unionArr.length; ++i) {
            unionArr[i] = i;
        }
    }

    private void union(int target, int source) {
        int targetFindNum = find(target);
        int sourceFindNum = find(source);

        if (targetFindNum != sourceFindNum) {
            unionArr[targetFindNum] = sourceFindNum;
        }
    }

    private int find(int target) {
        if (unionArr[target] == target) {
            return target;
        } else {
            return find(unionArr[target]);
        }
    }

}
