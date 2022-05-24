package dddpractice.ddd.myshop.member.command.domain;

import dddpractice.ddd.myshop.common.event.Event;

public class MemberBlockedEvent extends Event {
    private String memberId;

    public MemberBlockedEvent(String memberId) {
        this.memberId = memberId;
    }

    public String getMemberId() {
        return memberId;
    }
}