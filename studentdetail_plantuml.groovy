@startuml
class User{

}
class StudentManager {
    - students: list<Student>
    + addStudent(name, batch, status,additionalDetails)
    + updateStudent(studentID,name,status,additionalDetails )
    + removeStudent(studentID)
}

class StudentSearch {
    - filters
    + searchByBatch(batch)
    + searchByName(name)
    + searchByStatus(status)
    + advancedSearch(filters)
}

class Student {
    - studentID
    - name
    - batch
    - status
    - additionalDetails
}
@enduml