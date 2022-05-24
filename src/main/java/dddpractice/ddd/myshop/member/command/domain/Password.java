package dddpractice.ddd.myshop.member.command.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Password {

    @Column(name = "password")
    private String value;

    public boolean match(String password) {
        return this.value.equals(password);
    }
}