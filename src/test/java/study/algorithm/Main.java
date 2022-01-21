package study.algorithm;

import java.io.IOException;
import java.io.PrintStream;
import java.util.*;

public class Main {

    static class Student {
        Long sno;
        String sname;

        Student(Long sno, String sname) {
            this.sno = sno;
            this.sname = sname;
        }

    }

    public static final int INPUT_MAX_VALUE = 10;

    public static void main(String[] args) throws IOException {

        ArrayList<Student> list = new ArrayList<>();
        HashSet<Long> sno_map = new HashSet<>();

        Scanner sc = new Scanner(System.in, "UTF-8");
        String test = "2021년 11월 3일 수요일 오전 9:55 2020011965 개똥이 님이 모두에게: 2020011965 개똥이입니다!!";

        // 종료조건 미존재로 10개의 출석입력은 무조건 받는다고 가정
//        for (int i = 0; i < INPUT_MAX_VALUE; i++) {
        while (sc.hasNext()){
            String tmp = sc.nextLine();
            String[] splitStr = tmp.split(" ");

            if(splitStr.length < 7) continue;

            Long sno = Long.parseLong(splitStr[6]);
            String sname = splitStr[7];

            // 중복된 출석체크는 최초 출석체크에 한하여 체크함.
            if (!sno_map.contains(sno))
                list.add(new Student(sno, sname));

        }

        // 정렬 - 오름차순(학번)
        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {

                if (o1.sno < o2.sno) {
                    return -1;
                } else if (o1.sno > o2.sno) {
                    return 1;
                }

                return 0;
            }
        });

        // 출력
        PrintStream out = new PrintStream(System.out, true, "UTF-8");

        for (int i = 0; i < list.size(); i++) {
            out.println(list.get(i).sno.toString()+" " + list.get(i).sname.toString());
        }

    }

}