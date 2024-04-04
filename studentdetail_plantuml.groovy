@startuml
package StudentDetails {
	class StudentManager {
		- students: list<Student>
		+ addStudent(name: string, batch: string, additionalDetails: string): void
		+ updateStudent(studentID: int, attributes: dict): void
		+ removeStudent(studentID: int): void
	}

	class StudentSearch {
		- filters: list<string>

		+ searchByBatch(batch: string): list<Student>
		+ searchByName(name: string): list<Student>
		+ searchByStatus(status: string): list<Student>
		+ advancedSearch(filters: dict): list<Student>
		+ viewAllStudents(): list<Student>

	}

	class Student{
		+ studentID: int
		+ photo: Photo
		+ guardian: Guardian
		+ emergencyContact: EmergencyContact
		+ previousEducation: PreviousEducation

		+ addGuardian(guardian: Guardian): void
		+ removeGuaradian(id: Guardian.id): void
		+ addEmergencyContact(contact: EmergencyContact): void
		+ updateEmergencyContact(contact_id: EmergencyContact.id): void
		+ addPreviousEducation(eduDetails: PreviousEducation): void
		+ updateEducationDetails(): void
	}

	class Photo {
		+ size: int
		+ alt: string
		+ image: bin
		+ dateOfCreation: date
		+ resize(newSize: int): void
		+ updateAltText(newAltText: string): void
		+ changeImage(newImage: bin): void
	}

	class Guardian {
		+ id: int
		+ name: string
		+ relationship: string
		+ contactNumber: string

		+ updateName(name: string): int
		+ updateRelationship(relationship: string): int
		+ updateContactNumber(newContact: string): int
	}

	class EmergencyContact extends Guardian{
		+ description: string
		+ contactNumber: string

		+ updateContactNumber(newContact: string): int
		+ updateDescription(newDesc: string): int
	}

	class PreviousEducation {
		+ schoolName: string
		+ grade: string
		+ year: int
		
		+ updateSchoolName(schoolName: string): int
		+ updateGrade(newGrade: string): int
		+ updateYear(newYear: int): int
	}


    class StudentDatabase {
        + students: List<Student>
        + num_students: int

        + addStudent(student: Student) 
        + removeStudent(student_id: int) 
    }

    class User {
        + userID: int
        + name: string
        + bio: string

        + changeName(name: string): int
        + updateBio(bio: string): int
    }

    class AdminUser extends User {
        + adminID: int

        + updateStudentDatabase()
    }

    Student "1..*" o-- "1" Photo : uploads
	Student "1..*" o-- "1..*" Guardian: has
	Student "1..*" o-- "1" EmergencyContact: has
	Student "1..*" o-- "1..*" PreviousEducation: has
    Student "0..*" --> "1" StudentDatabase: is stored in
    StudentSearch "1" --> "1" StudentDatabase: uses
    StudentManager "1" --> "1" StudentDatabase: uses
    AdminUser "1..*" --> "1" StudentManager: uses
    AdminUser "1..*" --> "1" StudentDatabase: manages
    AdminUser "0..*" --> "1" StudentSearch: searches using
}
@enduml
