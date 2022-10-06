package MySQL.test_sql.Entity;

import javax.persistence.*;

@Entity
public class Tag {

    @Id @GeneratedValue
    @Column(name = "Tag_id")
    private int id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;
}
