package MySQL.test_sql.Repository;

import MySQL.test_sql.Entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    @PersistenceContext
    private final EntityManager em;

    public Long save(Member member){
        em.persist(member);
        return member.getId();
    }

    public Member find(Long id){
        return em.find(Member.class,id);
    }

    public List<Member> findBySid(Long S_id){
        return (List<Member>) em.createQuery("select m from Member m where m.S_id = :S_id", Member.class)
                .setParameter("S_id",S_id)
                .getResultList();
    }

    public List<Member> findAll(){
        return em.createQuery("select m from Member m",Member.class)
                .getResultList();
    }

    public Member findOne(Long id){
        return em.find(Member.class,id);
    }

}
