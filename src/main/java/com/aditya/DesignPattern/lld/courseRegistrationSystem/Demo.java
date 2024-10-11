package com.aditya.DesignPattern.lld.courseRegistrationSystem;

public class Demo {

    /**
     * <p>The course registration system should allow students to register for courses and view their registered courses.</p>
     * <p>Each course should have a course code, name, instructor, and maximum enrollment capacity.</p>
     * <p>Students should be able to search for courses based on course code or name.</p>
     * <p>The system should prevent students from registering for courses that have reached their maximum enrollment capacity.</p>
     * <p>The system should handle concurrent registration requests from multiple students.</p>
     * <p>The system should ensure data consistency and prevent race conditions.</p>
     * <p>The system should be extensible to accommodate future enhancements and new features.</p>
     */

    public static void main(String[] args) {
        Student student1 = new Student("Aditya");
        Student student2 = new Student("Adi");
        Student student3 = new Student("Paras");

        System.out.println(student1);
        System.out.println(student2);
        System.out.println(student3);

        Course course = new Course("101", "Maths", "Instructor1", 2);
        Course course1 = new Course("102", "English", "Instructor1", 3);

        CourseRegistrationSystem courseRegistrationSystem = CourseRegistrationSystem.getInstance();

        courseRegistrationSystem.addCourse(course);
        courseRegistrationSystem.addCourse(course1);

        courseRegistrationSystem.addStudent(student1);
        courseRegistrationSystem.addStudent(student2);
        courseRegistrationSystem.addStudent(student3);

        System.out.println("Course : " + courseRegistrationSystem.getCourseByName("English"));
        System.out.println("Course : " + courseRegistrationSystem.getCourse(course.getCourseCode()));

//        Registration registration = courseRegistrationSystem.enrollStudentToCourse(
//                course.getCourseCode(), student1.getId());
//        Registration registration1 = courseRegistrationSystem.enrollStudentToCourse(
//                course.getCourseCode(), student2.getId());
//        Registration registration2 = courseRegistrationSystem.enrollStudentToCourse(
//                course.getCourseCode(), student3.getId());

        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                courseRegistrationSystem.enrollStudentToCourse(
                        course.getCourseCode(), student1.getId());
            }
        });


        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                courseRegistrationSystem.enrollStudentToCourse(
                        course.getCourseCode(), student2.getId());
            }
        });


        Thread thread3 = new Thread(new Runnable() {
            public void run() {
                courseRegistrationSystem.enrollStudentToCourse(
                        course.getCourseCode(), student3.getId());
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
