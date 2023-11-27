import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Alice", 25));
        students.add(new Student(2, "Bob", 23));
        students.add(new Student(3, "Charlie", 21));

        StudentManagement management = new StudentManagement();

        management.displayStudents(students, Student::getName);

        Predicate<Student> isStudentNameLengthEqualToFive = s -> s.getName().length() == 5;
        management.displayStudentsByFilter(students, isStudentNameLengthEqualToFive, Student::getName);

        Function<Student, String> returnStudentName = Student::getName;
        System.out.println(management.returnStudentsNames(students, returnStudentName));

        Supplier<Student> createStudent = () -> new Student(4, "David", 20);
        Student student = management.createStudent(createStudent);
        students.add(student);

        Comparator<Student> compareStudentsById = Comparator.comparingInt(Student::getId);
        management.sortStudentsById(students, compareStudentsById);

        management.convertToStream(students).forEach(Student::getName);
    }
}