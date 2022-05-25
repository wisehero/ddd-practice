package dddpractice.ddd.myshop.member.command.application;

import dddpractice.ddd.myshop.member.command.domain.Member;
import dddpractice.ddd.myshop.member.command.domain.MemberId;
import dddpractice.ddd.myshop.member.command.domain.MemberRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BlockMemberService {

    private MemberRepository memberRepository;

    public BlockMemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @PreAuthorize("hasRole('Admin')") //권한 검사
    @Transactional
    public void block(String memberId) {
        Member member = memberRepository.findById(new MemberId(memberId))
                .orElseThrow(() -> new NoMemberException());

        member.block();
    }
}