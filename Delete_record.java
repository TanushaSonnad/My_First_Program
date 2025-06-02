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
