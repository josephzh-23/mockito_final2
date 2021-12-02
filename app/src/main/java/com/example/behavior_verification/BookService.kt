package test_doubles.behavior_verification

class BookService(private val bookRepository: BookRepository) {
    fun addBook(book: Book) {
        if (book.price <= 500) {
            return
        }
        bookRepository.save(book)
    }

    fun addBook(bookRequest: BookRequest) {
        if (bookRequest.price <= 500) {
            return
        }
        val book = Book()
        book.title = bookRequest.title
        book.price = bookRequest.price
        book.publishedDate = bookRequest.publishedDate
        bookRepository.save(book)
    }

    fun updatePrice(bookId: String?, updatedPrice: Int) {

        if(bookId ==null){
            return
        }
        val book = bookRepository.findBookById(bookId)
        book?.price = updatedPrice
        bookRepository.save(book)
    }
}
