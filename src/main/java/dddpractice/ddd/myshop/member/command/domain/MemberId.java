package dddpractice.ddd.myshop.member.command.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data // -> @Getter, @Setter, @ToString, @EqualsAndHashCode, @RequiredArgsConstructor
public class MemberId implements Serializable {

    @Column(name = "memberId")
    private String id;

}