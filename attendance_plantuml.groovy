@startuml
class User {
}

class Attendance {
    - date
    - classID
    - attendanceStatusList
    - noteRemarks
    + markAttendance(date, id, attendanceStatusList, remarks)
    + updateRemarks(date, id, remarks)
}

class StandardiseReportConvertor {
    - reportType
    - conversionSettings
    - convertedReport
    + convertReport(reportType, conversionSettings)
    + saveConvertedReport(convertedReport)
}

class ReportFilteringSystem {
    - reportType
    - filters
    - filteredReport
    + applyFilters(reportType, filters)
    + saveFilteredReport(filteredReport)
}
@enduml