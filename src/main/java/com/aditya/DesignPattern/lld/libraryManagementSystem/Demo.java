package com.aditya.DesignPattern.lld.libraryManagementSystem;

public class Demo {

    public static void main(String[] args) {
        Member member = new Member("Aditya");
        Member member2 = new Member("Adi");

        Book book1 = new Book("Book1", "Author1", "2024", "1234", BookStatus.AVAILABLE);
        Book book2 = new Book("Book2", "Author1", "2024", "1244", BookStatus.AVAILABLE);
        Book book3 = new Book("Book3", "Author2", "2024", "1264", BookStatus.AVAILABLE);
        Book book4 = new Book("Book4", "Author2", "2024", "1274", BookStatus.AVAILABLE);
        Book book5 = new Book("Book5", "Author1", "2024", "1284", BookStatus.AVAILABLE);

        LibraryManagementService libraryManagementService = LibraryManagementService.getInstance();

        libraryManagementService.addMember(member);
        libraryManagementService.addMember(member2);

        libraryManagementService.addBook(book1);
        libraryManagementService.addBook(book2);
        libraryManagementService.addBook(book3);
        libraryManagementService.addBook(book4);
        libraryManagementService.addBook(book5);

        System.out.println(libraryManagementService.getAvailableBooks());
        System.out.println(libraryManagementService.getBooksByAuthor("Author1"));

        Borrow borrow = libraryManagementService.borrowBook(book1.getId(), member.getMemberId());
        System.out.println("Borrowed book: " + borrow);


        Borrow borrow1 = libraryManagementService.borrowBook(book1.getId(), member2.getMemberId());
        System.out.println("Borrowed book: " + borrow1);


        Borrow borrow2 = libraryManagementService.borrowBook(book3.getId(), member2.getMemberId());
        System.out.println("Borrowed book: " + borrow2);

        Borrow borrow3 = libraryManagementService.borrowBook(book2.getId(), member.getMemberId());
        System.out.println("Borrowed book: " + borrow3);

        Borrow borrow4 = libraryManagementService.borrowBook(book4.getId(), member.getMemberId());
        System.out.println("Borrowed book: " + borrow4);

        System.out.println(libraryManagementService.getMember(member.getMemberId()));

        libraryManagementService.returnBook(book1.getId(), member.getMemberId());
        System.out.println(libraryManagementService.getMember(member.getMemberId()));
    }
}
