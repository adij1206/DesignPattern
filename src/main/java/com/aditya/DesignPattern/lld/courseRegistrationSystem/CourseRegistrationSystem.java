package com.aditya.DesignPattern.lld.courseRegistrationSystem;

public class CourseRegistrationSystem {

    private static CourseRegistrationSystem instance;
    private StudentService studentService;
    private CourseService courseService;
    private RegistrationService registrationService;

    private CourseRegistrationSystem() {
        this.studentService = new StudentService();
        this.courseService = new CourseService();
        this.registrationService = new RegistrationService();
    }

    public static synchronized CourseRegistrationSystem getInstance() {
        if (instance == null) {
            instance = new CourseRegistrationSystem();
        }

        return instance;
    }

    public void addStudent(Student student) {
        studentService.addStudent(student);
    }

    public Student getStudent(String id) {
        return studentService.getStudent(id);
    }

    public Registration getRegistration(String registrationId) {
        return registrationService.getRegistration(registrationId);
    }

    public void addCourse(Course course) {
        courseService.addCourse(course);
    }

    public Course getCourse(String courseCode) {
        return courseService.getCourse(courseCode);
    }

    public Course getCourseByName(String courseName) {
        return courseService.getCourseByName(courseName);
    }

    public synchronized Registration enrollStudentToCourse(String courseId, String studentId) {
        boolean seatAvailable = courseService.isSeatAvailable(courseId);

        if (!seatAvailable) {
            System.out.println("Seat Not Available for student" + studentId);
            return null;
        }

        Registration registration = registrationService.createRegistration(courseId, studentId);
        courseService.updateEnrolledStudentCount(courseId);

        return registration;
    }
}
