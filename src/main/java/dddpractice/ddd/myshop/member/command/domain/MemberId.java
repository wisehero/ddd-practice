package dddpractice.ddd.myshop.member.command.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data // -> @Getter, @Setter, @ToString, @EqualsAndHashCode, @RequiredArgsConstructor
@NoArgsConstructor
public class MemberId implements Serializable {

    @Column(name = "memberId")
    private String id;

    public MemberId(String id) {
        this.id = id;
    }
}