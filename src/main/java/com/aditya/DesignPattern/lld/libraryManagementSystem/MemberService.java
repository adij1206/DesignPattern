package com.aditya.DesignPattern.lld.libraryManagementSystem;

import java.util.HashMap;
import java.util.Map;

public class MemberService {

    private Map<String, Member> memberMap;

    public MemberService() {
        this.memberMap = new HashMap<>();
    }

    public void addMember(Member member) {
        memberMap.put(member.getMemberId(), member);
    }

    public Member getMember(String memberId) {
        return memberMap.get(memberId);
    }

    public void updateNumberOfBooksBorrowed(String memberId, int numberOfBooksBorrowed) {
        Member member = memberMap.get(memberId);
        member.setNumberOfBooksBorrowed(member.getNumberOfBooksBorrowed() + numberOfBooksBorrowed);
    }
}
