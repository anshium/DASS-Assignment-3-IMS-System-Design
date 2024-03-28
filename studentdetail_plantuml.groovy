@startuml

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
}

class Student {
    - studentID: int
    - name: string
    - batch: string
    - status: string
    - additionalDetails: string
}

StudentManager "1" --> "0..*" Student : Manages
StudentSearch ..> Student : Uses

@enduml
