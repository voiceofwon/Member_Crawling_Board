package MySQL.test_sql.Repository;


import MySQL.test_sql.Entity.Notice;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public interface NoticeRepository extends JpaRepository<Notice,Long> {
    List<Notice> findByTitleContaining(String title);


}
