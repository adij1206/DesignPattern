package com.aditya.DesignPattern.lld.libraryManagementSystem;

import java.util.List;

public class LibraryManagementService {

    private static final int NO_OF_MAXIMUM_BOOK = 2;

    private static LibraryManagementService instance;
    private MemberService memberService;
    private BookService bookService;
    private BorrowService borrowService;

    private LibraryManagementService() {
        this.memberService = new MemberService();
        this.bookService = new BookService();
        this.borrowService = new BorrowService();
    }

    public synchronized static LibraryManagementService getInstance() {
        if (instance == null) {
            instance = new LibraryManagementService();
        }

        return instance;
    }

    public void addMember(Member member) {
        memberService.addMember(member);
    }

    public Member getMember(String memberId) {
        return memberService.getMember(memberId);
    }

    public void addBook(Book book) {
        bookService.addBook(book);
    }

    public Book getBookById(String id) {
        return bookService.getBookById(id);
    }

    public List<Book> getBooksByAuthor(String author) {
        return bookService.getBooksByAuthor(author);
    }

    public void removeBookById(String id) {
        bookService.removeBookById(id);
    }

    public Borrow getBorrow(String borrowId) {
        return borrowService.getBorrow(borrowId);
    }

    public Borrow getBorrowByMemberIdAndBookId(String memberId, String bookId) {
        return borrowService.getBorrowByMemberIdAndBookId(memberId, bookId);
    }

    public synchronized Borrow borrowBook(String bookId, String memberId) {
        Book book = bookService.getBookById(bookId);

        if (book.getBookStatus().equals(BookStatus.BORROWED)) {
            System.out.println("Book is currently not available");
            return null;
        }

        Member member = memberService.getMember(memberId);
        if (member.getNumberOfBooksBorrowed()==NO_OF_MAXIMUM_BOOK) {
            System.out.println("No books can be borrowed");
            return null;
        }

        Borrow borrow = new Borrow(memberId, bookId);
        borrowService.addBorrow(borrow);

        bookService.updateBookStatus(bookId, BookStatus.BORROWED);
        memberService.updateNumberOfBooksBorrowed(memberId, 1);

        return borrow;
    }

    public synchronized void returnBook(String bookId, String memberId) {
        Borrow borrow = borrowService.getBorrowByMemberIdAndBookId(memberId, bookId);

        bookService.updateBookStatus(borrow.getBookId(), BookStatus.AVAILABLE);
        borrowService.updateBorrowStatus(borrow.getBorrowId(), BorrowStatus.COMPLETED);
        memberService.updateNumberOfBooksBorrowed(memberId, -1);
    }

    public List<Book> getAvailableBooks() {
        return bookService.getAvailableBooks();
    }

}
