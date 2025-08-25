package ku.cs.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class StudentListTest {
    @Test
    @DisplayName("ทดสอบเพิ่มข้อมูลนักเรียนในลิสต์")
    void testAddNewStudent(){
        StudentList list = new StudentList();
        list.addNewStudent("6710405087", "Pornchanok", 70.6);
        list.addNewStudent("6710405000", "Music", 80.9);
        ArrayList<Student> s = list.getStudents();

        assertEquals("6710405087", s.get(0).getId());
        assertEquals("Pornchanok", s.get(0).getName());
        assertEquals(70.6, s.get(0).getScore());

        assertEquals("6710405000", s.get(1).getId());
        assertEquals("Music", s.get(1).getName());
        assertEquals(80.9, s.get(1).getScore());

    }

    @Test
    @DisplayName("ทดสอบหาข้อมูลนักเรียนจากid")
    void testFindStudentById(){
        StudentList list = new StudentList();
        list.addNewStudent("6710405087", "Pornchanok", 70.6);
        list.addNewStudent("6710405000", "Music", 80.9);

        Student s1 = list.findStudentById("6710405087");
        assertEquals("Pornchanok", s1.getName());
        assertEquals(70.6, s1.getScore());

        Student s2 = list.findStudentById("6710405000");
        assertEquals("Music", s2.getName());
        assertEquals(80.9, s2.getScore());
    }

    @Test
    @DisplayName("ทดสอบหาข้อมูลนักเรียนจากชื่อ")
    void testFilterName(){
        StudentList list = new StudentList();
        list.addNewStudent("6710405087", "Pornchanok", 70.6);
        list.addNewStudent("6710405000", "Music", 80.9);

        StudentList s1 = list.filterByName("Pornchanok");
        assertEquals("6710405087", s1.getStudents().get(0).getId());
        assertEquals(70.6, s1.getStudents().get(0).getScore());

        StudentList s2 = list.filterByName("Music");
        assertEquals("6710405000", s2.getStudents().get(0).getId());
        assertEquals(80.9, s2.getStudents().get(0).getScore());
    }

    @Test
    @DisplayName("ทดสอบให้คะแนน 10 และ 6.6 เพิ่มให้นักเรียน")
    void testGiveScoreToId(){
        StudentList list = new StudentList();
        list.addNewStudent("6710405087", "Pornchanok", 70.6);
        list.addNewStudent("6710405000", "Music", 80.9);

        list.giveScoreToId("6710405087", 10);
        Student s1 = list.findStudentById("6710405087");
        assertEquals(80.6, s1.getScore());

        list.giveScoreToId("6710405000", 6.6);
        Student s2 = list.findStudentById("6710405000");
        assertEquals(87.5, s2.getScore());

    }

    @Test
    @DisplayName("ทดสอบดูเกรดจาก id ของนักเรียน")
    void testviewGradeOfId(){
        StudentList list = new StudentList();
        list.addNewStudent("6710405087", "Pornchanok", 70.6);
        list.addNewStudent("6710405000", "Music", 80.9);

        Student s1 = list.findStudentById("6710405087");
        assertEquals("B", s1.getGrade());

        Student s2 = list.findStudentById("6710405000");
        assertEquals("A", s2.getGrade());
    }
}