import java.util.*;
public class StudentDetailArrayList {
    public static void main(String[] args) {
        List<Student> li = new ArrayList<>();
        try {
            li.add(new Student("A", 1, 20));
            li.add(new Student("A", 1, 50));
            li.add(new Student("A", 1, 40));
            li.add(new Student("A", 1, 30));

        } catch (InvalidMarksException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Student Details:");
        for (Student s : li) {
            System.out.println(s);
        }
    }
    static class Student {
        String name;
        int rollNo;
        int marks;
        Student(String name, int rollNo, int marks)
                throws InvalidMarksException {
            if (marks < 0 || marks > 40) {
                throw new InvalidMarksException(
                    "Invalid Marks: " + marks
                    + ". Marks must be between 0 and 40."
                );
            }
            this.name = name;
            this.rollNo = rollNo;
            this.marks = marks;
        }
        @Override
        public String toString() {
            return "Name: " + name
                    + ", Roll No: " + rollNo
                    + ", Marks: " + marks;
        }
    }
    static class InvalidMarksException extends Exception {

        InvalidMarksException(String message) {
            super(message);
        }
    }
}