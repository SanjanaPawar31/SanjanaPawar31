import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentManagementSystem 
{
    private List<Student> students = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        StudentManagementSystem sms = new StudentManagementSystem();
        sms.start();
    }
    public void addStudent() 
    {
        try {
            System.out.print("Enter student name: ");
            String name = scanner.nextLine();
            System.out.print("Enter roll number: ");
            int rollNumber = scanner.nextInt();
            scanner.nextLine();  
            System.out.print("Enter grade: ");
            String grade = scanner.nextLine();
            System.out.print("Enter number of subjects: ");
            int numSubjects = scanner.nextInt();
            int[] subjectMarks = new int[numSubjects];
            for (int i = 0; i < numSubjects; i++) 
            {
                System.out.print("Enter marks for subject " + (i + 1) + ": ");
                int marks = scanner.nextInt();
                subjectMarks[i] = marks;
            }
            scanner.nextLine();  
            Student student = new Student(name, rollNumber, grade, subjectMarks);
            students.add(student);
            System.out.println("Student added successfully.");
        } catch (InputMismatchException e)
        {
            System.out.println("Invalid input. Please enter numeric values where required.");
            scanner.nextLine();  
        }
    }
    public void removeStudent() 
    {
        try {
            System.out.print("Enter roll number of student to remove: ");
            int rollNumber = scanner.nextInt();
            scanner.nextLine();  
            Student studentToRemove = null;
            for (Student student : students) 
            {
                if (student.getRollNumber() == rollNumber) 
                {
                    studentToRemove = student;
                    break;
                }
            }
            if (studentToRemove != null) 
            {
                students.remove(studentToRemove);
                System.out.println("Student removed successfully.");
            } 
            else
            {
                System.out.println("Student with roll number " + rollNumber + " not found.");
            }
        } catch (InputMismatchException e) 
        {
            System.out.println("Invalid input. Please enter numeric values where required.");
            scanner.nextLine();  
        }
    }
    public void searchStudent() 
    {
        try {
            System.out.print("Enter roll number of student to search: ");
            int rollNumber = scanner.nextInt();
            scanner.nextLine(); 

            for (Student student : students) 
            {
                if (student.getRollNumber() == rollNumber) 
                {
                    System.out.println(student);
                    return;
                }
            }
            System.out.println("Student with roll number " + rollNumber + " not found.");
        } catch (InputMismatchException e)
        {
            System.out.println("Invalid input. Please enter numeric values where required.");
            scanner.nextLine(); 
        }
    }
    public void displayAllStudents() 
    {
        if (students.isEmpty()) 
        {
            System.out.println("No students to display.");
        } else {
            for (Student student : students) 
            {
                System.out.println(student);
            }
        }
    }

    public void saveToFile() 
    {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("students.dat"))) 
        {
            out.writeObject(new ArrayList<>(students));
            System.out.println("Data saved to file.");
        } catch (IOException e)
        {
            System.out.println("Error saving data to file.");
            e.printStackTrace();
        }
    }
    public void loadFromFile()
    {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("students.dat")))
        {
            Object obj = in.readObject();
            if (obj instanceof ArrayList<?>)
            {
                @SuppressWarnings("unchecked")
                List<Student> loadedStudents = (ArrayList<Student>) obj;
                students = loadedStudents;
                System.out.println("Data loaded from file.");
            }
            else
            {
                System.out.println("Unexpected data format in file.");
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading data from file.");
            e.printStackTrace();
        }
    }
    public void start() 
    {
        int choice;
        do {
            System.out.println("\nStudent Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Save to File");
            System.out.println("6. Load from File");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    removeStudent();
                    break;
                case 3:
                    searchStudent();
                    break;
                case 4:
                    displayAllStudents();
                    break;
                case 5:
                    saveToFile();
                    break;
                case 6:
                    loadFromFile();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 7);
    }
}
class Student implements Serializable 
{
    private static final long serialVersionUID = 1L;
    private String name;
    private int rollNumber;
    private String grade;
    private int[] subjectMarks;
    public Student(String name, int rollNumber, String grade, int[] subjectMarks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
        this.subjectMarks = subjectMarks;
    }

    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public String getGrade() {
        return grade;
    }

    public int[] getSubjectMarks() {
        return subjectMarks;
    }

    @Override
    public String toString() 
    {
        StringBuilder sb = new StringBuilder();
        sb.append("Name: ").append(name)
          .append(", Roll Number: ").append(rollNumber)
          .append(", Grade: ").append(grade)
          .append(", Marks: ");

        for (int mark : subjectMarks) 
        {
            sb.append(mark).append(" ");
        }

        return sb.toString();
    }
}
