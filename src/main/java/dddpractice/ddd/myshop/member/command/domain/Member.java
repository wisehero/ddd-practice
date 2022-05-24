package dddpractice.ddd.myshop.member.command.domain;

import dddpractice.ddd.myshop.common.event.Events;
import dddpractice.ddd.myshop.common.jpa.EmailSetConverter;
import dddpractice.ddd.myshop.common.model.Email;
import dddpractice.ddd.myshop.common.model.EmailSet;

import javax.persistence.*;
import java.util.Random;
import java.util.Set;

@Entity
@Table(name = "member")
public class Member {

    @EmbeddedId
    private MemberId id;

    private String name;

    @Embedded
    private Password password;

    private boolean blocked; // shop으로부터 차단당했는지 여부

    @Column(name = "emails")
    @Convert(converter = EmailSetConverter.class)
    private EmailSet emails;

    public MemberId getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void initializePassword() {
        String newPassword = generateRandomPassword();
        this.password = new Password(newPassword);
        Events.raise(new PasswordChangedEvent(id.getId(), newPassword));
    }

    private String generateRandomPassword() {
        Random random = new Random();
        int number = random.nextInt();
        return Integer.toHexString(number);
    }

    public void changeEmails(Set<Email> emails) {
        this.emails = new EmailSet(emails);
    }

    public void block() {
        this.blocked = true;
        Events.raise(new MemberBlockedEvent(id.getId()));
    }

    public void unblock() {
        this.blocked = false;
        Events.raise(new MemberUnblockedEvent(id.getId()));
    }

    public void changePassword(String oldPw, String newPw) {
        if (!password.match(oldPw)) {
            throw new IdPasswordNotMatchingException();
        }
        this.password = new Password(newPw);
        Events.raise(new PasswordChangedEvent(id.getId(), newPw));
    }
}