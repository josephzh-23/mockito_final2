package test_doubles.behavior_verification

interface BookRepository {
    fun save(book: Book?)
    fun findBookById(bookId: String?): Book?
}
