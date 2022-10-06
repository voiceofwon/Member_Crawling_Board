package MySQL.test_sql;

import MySQL.test_sql.Entity.Member;
import MySQL.test_sql.Repository.MemberRepository;
import MySQL.test_sql.Service.MemberService;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;

import static org.junit.Assert.fail;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class TestSqlApplicationTests {

	@Autowired
	MemberRepository memberRepository;
	@Autowired
	MemberService memberService;

	@Test
	public void setup() throws Exception{

		Member member = new Member();
		member.setS_id(202126978L);

		Long saveId = memberService.join(member);

		Assertions.assertEquals(member, memberRepository.findOne(saveId));


	}

	@Test(expected = IllegalStateException.class)
	public void duplicate_test() throws Exception {
		Member member1 = new Member();
		member1.setS_id(202126978L);

		Member member2 = new Member();
		member2.setS_id(202126978L);

		memberService.join(member1);
		memberService.join(member2);

		fail("예외가 발생해야 한다.");
	}
	/*public void testMember() {
		Member member = new Member();
		member.setS_id(202126978L);
		Long saveId = memberRepository.save(member);

		Member findMember = memberRepository.find(saveId);

		Assertions.assertEquals(findMember.getId(),member.getId());

		Assertions.assertEquals(findMember,member);
	}*/

}
