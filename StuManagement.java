import java.util.*;

class Student {
	String name;
	String usn;
	int marks;

	Student(String name, String usn, int marks) {
		this.name = name;
		this.usn = usn;
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "Name: " + name + ", USN: " + usn + ", Marks: " + marks;
	}
}

public class StuManagement {
	static Scanner scanner = new Scanner(System.in);
	static List<Student> studentList = new ArrayList<>();

	public static void main(String[] args) {
		while (true) {
			System.out.println("\n--- Student Record System ---");
			System.out.println("1. Add Student");
			System.out.println("2. Display All Students");
			System.out.println("3. Delete Student by USN");
			System.out.println("4. Exit");
			System.out.print("Choose option: ");

			int choice = scanner.nextInt();
			scanner.nextLine(); // consume newline

			switch (choice) {
			case 1:
				addStudent();
				break;
			case 2:
				displayStudents();
				break;
			case 3:
				deleteStudent();
				break;
			case 4:
				System.out.println("Exiting...");
				return;
			default:
				System.out.println("Invalid choice. Try again.");
			}
		}
	}

	static void addStudent() {
		System.out.print("Enter Name: ");
		String name = scanner.nextLine();

		System.out.print("Enter USN: ");
		String usn = scanner.nextLine();

		// Check for duplicate USN
		for (Student s : studentList) {
			if (s.usn.equalsIgnoreCase(usn)) {
				System.out.println("USN already exists. Student not added.");
				return;
			}
		}

		System.out.print("Enter Marks (0-20): ");
		int marks = scanner.nextInt();
		scanner.nextLine(); // consume newline

		if (marks < 0 || marks > 20 ){
			System.out.println("Invalid marks. Must be between 0 and 100.");
			return;
		}

		Student student = new Student(name, usn, marks);
		studentList.add(student);
		System.out.println("Student added successfully.");
	}

	static void displayStudents() {
		if (studentList.isEmpty()) {
			System.out.println("No student records found.");
		} else {
			System.out.println("Student Records:");
			for (Student student : studentList) {
				System.out.println(student);
			}
		}
	}

	static void deleteStudent() {
		System.out.print("Enter USN to delete: ");
		String usn = scanner.nextLine();

		boolean found = false;

		Iterator<Student> iterator = studentList.iterator();
		while (iterator.hasNext()) {
			Student s = iterator.next();
			if (s.usn.equalsIgnoreCase(usn)) {
				iterator.remove();
				System.out.println("Student with USN " + usn + " deleted.");
				found = true;
				break;
			}
		}

		if (!found) {
			System.out.println("No student found with that USN.");
		}
	}
}