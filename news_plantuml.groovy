@startuml
class News {
    - id: int
    - title: string
    - content: string
    - date: string
    - comments: List<Comment>
    + readNews(id)
    + updateNews(id, title, content, date)
    + updateNews(id, content, date)
    + deleteNews(title)
    + createNews(title, content, date)
}

class Comment {
    - id: int
    - content: string
    - date: string
    - author: string
    - status: string
    + addComment(content, author, date, id)
    + deleteComment(id)
}
@enduml