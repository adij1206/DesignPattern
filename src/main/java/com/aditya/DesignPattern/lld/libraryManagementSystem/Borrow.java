package com.aditya.DesignPattern.lld.libraryManagementSystem;

import lombok.Data;

import java.util.UUID;

@Data
public class Borrow {

    private String borrowId;
    private String memberId;
    private String bookId;
    private Long borrowDate;
    private BorrowStatus borrowStatus;

    public Borrow(String memberId, String bookId) {
        this.borrowId = UUID.randomUUID().toString();
        this.memberId = memberId;
        this.bookId = bookId;
        this.borrowDate = System.currentTimeMillis();
        this.borrowStatus = BorrowStatus.ACTIVE;
    }
}