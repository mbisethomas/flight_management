package service;

import dao.BookDao;
import modal.Book;

public class BookService {
	BookDao bd = new BookDao();
	public int storeBookingdata(Book b) {
			return bd.storebookingdata(b);
		
	}

}
