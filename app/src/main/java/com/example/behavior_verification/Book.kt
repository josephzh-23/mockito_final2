package test_doubles.behavior_verification

import java.time.LocalDate
import java.util.*

class Book {
    var bookId: String? = null
    var title: String? = null
    var price = 0
    var publishedDate: LocalDate? = null

    constructor() {}
    constructor(bookId: String?, title: String?, price: Int, publishedDate: LocalDate?) {
        this.bookId = bookId
        this.title = title
        this.price = price
        this.publishedDate = publishedDate
    }

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false
        val book = o as Book
        return price == book.price &&
                title == book.title &&
                publishedDate == book.publishedDate
    }

    override fun hashCode(): Int {
        return Objects.hash(title, price, publishedDate)
    }
}
