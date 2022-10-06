package MySQL.test_sql.Entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private long id;

    @OneToMany(mappedBy = "member")
    private List<Tag> Tags = new ArrayList<Tag>();

    @Column(name = "S_id")
    private Long S_id;

    public Long getS_id() {
        return S_id;
    }

    public void setS_id(Long S_id) {
        this.S_id = S_id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }


}
