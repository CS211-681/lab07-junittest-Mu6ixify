package ku.cs.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    @DisplayName("ทดสอบการสร้างข้อมูลนักเรียน")
    void testConstructorStudent(){
        Student s = new Student("6710405087", "Pornchanok", 70.6);
        assertEquals("6710405087", s.getId());
        assertEquals("Pornchanok", s.getName());
        assertEquals(70.6, s.getScore());
    }

    @Test
    @DisplayName("ทดสอบเปลี่ยนชื่อจาก Pornchanok เป็น Music")
    void testChangeName(){
        Student s = new Student("6710405087", "Pornchanok");
        s.changeName("Music");
        assertEquals("Music", s.getName());
    }

    @Test
    @DisplayName("ทดสอบเพิ่มคะแนน 45.15 คะแนน")
    void testAddScore(){
        Student s = new Student("6710405087", "StudentTest");
        s.addScore(45.15);
        assertEquals(45.15, s.getScore());
    }

    @Test
    @DisplayName("ทดสอบการเพิ่มคะแนน 85 คะแนน และให้ Object คำนวนเกรดออกมา")
    void testCalculateGrade(){
        Student s = new Student("6710405087", "StudentTest");
        s.addScore(85);
        assertEquals("A", s.grade());
    }

    @Test
    @DisplayName("ทดสอบว่ามี id 6710405087 รึไม่")
    void testIsId(){
        Student s = new Student("6710405087", "StudentTest");
        assertTrue(s.isId("6710405087"));
    }

    @Test
    @DisplayName("ทดสอบว่ามี ชื่อ Pornchanok")
    void testIsNameContains(){
        Student s = new Student("6710405087", "Pornchanok");
        assertTrue(s.isNameContains("Pornchanok"));
    }

    @Test
    @DisplayName("ทดสอบว่าแสดงสตริงถูกต้องรึไม่")
    void testToString(){
        Student s = new Student("6710405087", "Pornchanok", 70.6);
        assertEquals("{id: '6710405087', name: 'Pornchanok', score: 70.6}", s.toString());
    }


}