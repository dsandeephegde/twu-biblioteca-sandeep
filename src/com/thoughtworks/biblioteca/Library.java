//Stores the List of Books which can be checked out or returned
package com.thoughtworks.biblioteca;

import java.util.ArrayList;

public class Library {

    private ArrayList<Book> books;
    private ArrayList<Boolean> checkedOutBooks;
    private View view;

    public Library(ArrayList<Book> books, View view) {
        this.books = books;
        this.view = view;
        checkedOutBooks = new ArrayList<Boolean>();
        for (int i = 0; i < books.size(); i++) {
            checkedOutBooks.add(false);
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Book Name\t").append("Author\t").append("Year Published\n");
        for (int i = 0; i < books.size(); i++) {
            if(!checkedOutBooks.get(i)) {
                stringBuilder.append(books.get(i).toString()).append("\n");
            }
        }
        return stringBuilder.toString();
    }

    public void displayBookList() {
        view.output(toString());
    }

    public Boolean checkoutBook(String bookName) {
        for(Book book: books) {
            if(book.hasName(bookName) && !checkedOutBooks.get(books.indexOf(book))) {
                checkedOutBooks.set(books.indexOf(book), true);
                return true;
            }
        }
        return false;
    }

    public Boolean returnBook(String bookName) {
        for (Book book : books) {
            if (book.hasName(bookName) && checkedOutBooks.get(books.indexOf(book))) {
                checkedOutBooks.set(books.indexOf(book), false);
                return true;
            }
        }
        return false;
    }
}