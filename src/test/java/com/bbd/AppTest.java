package com.bbd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
/**
 * Unit test for simple App.
 */
@DisplayName("University Enrollment")
public class AppTest
{
    @Mock
    Student student,
            student1,
            student2,
            student3;
    @Mock
    Course maths, programming;

    @BeforeEach
    void initializeStudents(){
        student = new Student("Ntokozo", 218123, "03/03/1993");
        student1 = new Student("Cebo", 217123, "03/03/1994");
        student2 = new Student("Makhosonke", 216123, "03/03/1995");
        student3 = new Student("Lulu", 215123, "03/03/1996");
        Course.numberOfCourses = 0;
        maths = new Course("Applied Mathematics 101", 1);
        programming = new Course("Programming 101", 28);
    }

    @Test
    void numberOfCoursesTest() {
        assertEquals(2, Course.numberOfCourses, "Three courses have been created");
    }

    @Test
    void studentGettersTest(){
        assertEquals("Ntokozo", student.getName());
        assertEquals(218123, student.getStudentNumber());
        assertEquals("03/03/1993", student.getDob());
    }

    @Test
    void studentSettersTest(){
        student.setName("Nqobizwe Ngubane");
        assertEquals("Nqobizwe Ngubane", student.getName());

        student.setStudentNumber(214008231);
        assertEquals(214008231, student.getStudentNumber());

        student.setDob("03/03/1989");
        assertEquals("03/03/1989", student.getDob());
    }

    @Test
    void enrollmentCountTest(){
        maths.enrollStudent(student);
        assertEquals(student, maths.getStudent(0));

        assertFalse(maths.enrollStudent(student2), "Course should not take more than 1 student");
    }

    @Test
    void unenrollmentTest(){
        programming.enrollStudent(student);
        programming.enrollStudent(student1);
        programming.enrollStudent(student2);
        programming.enrollStudent(student3);

        assertEquals(4, programming.getStudentCount());
        programming.unenrollStudent(student);

        assertFalse(programming.contains(student), "Student has been unenrolled");
        assertEquals(3, programming.getStudentCount());
    }

}
