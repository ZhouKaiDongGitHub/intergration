package cn.kzhou.webservice;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentDateSet {

    private static List<StudentVo> list;

    static {
        StudentDateSet.list = new ArrayList<StudentVo>();

        for (int i = 0; i < 10; i++) {
            StudentVo vo = new StudentVo(i, "name" + i, Math.round(100.0f),
                    "desc" + i, (i & 1) == 0);
            StudentDateSet.list.add(vo);
        }
    }

    public static List<StudentVo> getList() {
        return StudentDateSet.list;
    }
}

