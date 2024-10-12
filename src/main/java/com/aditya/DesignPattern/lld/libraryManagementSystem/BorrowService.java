package com.aditya.DesignPattern.lld.libraryManagementSystem;

import java.util.HashMap;
import java.util.Map;

public class BorrowService {

    private Map<String, Borrow> borrowMap;

    public BorrowService() {
        this.borrowMap = new HashMap<>();
    }

    public void addBorrow(Borrow borrow) {
        borrowMap.put(borrow.getBorrowId(), borrow);
    }

    public Borrow getBorrow(String borrowId) {
        return borrowMap.get(borrowId);
    }

    public Borrow getBorrowByMemberIdAndBookId(String memberId, String bookId) {
        for (Borrow borrow : borrowMap.values()) {
            if (borrow.getMemberId().equals(memberId) &&
                    borrow.getBookId().equals(bookId) &&
                    BorrowStatus.ACTIVE.equals(borrow.getBorrowStatus())) {
                return borrow;
            }
        }

        return null;
    }

    public void updateBorrowStatus(String borrowId, BorrowStatus borrowStatus) {
        Borrow borrow = borrowMap.get(borrowId);
        borrow.setBorrowStatus(borrowStatus);
    }
}
