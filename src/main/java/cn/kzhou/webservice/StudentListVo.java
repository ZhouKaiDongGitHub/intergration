package cn.kzhou.webservice;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

@XmlRootElement
public class StudentListVo  implements Serializable {
    private static final long serialVersionUID = -2200047544608641662L;
    private List<StudentVo> studentList;

    public StudentListVo() {
    }

    public StudentListVo(List<StudentVo> studentList) {
        this.studentList = studentList;
    }

    public List<StudentVo> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<StudentVo> studentList) {
        this.studentList = studentList;
    }

    @Override
    public String toString() {
        return "{studentList=" + studentList + "}";
    }

}
