package MySQL.test_sql.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter@Setter
public class Notice {

    @Id
    @GeneratedValue
    @Column(name = "notice_id")
    private Long id;

    @Column(name = "notice_title")
    private String title;

    @Column(name = "notice_url")
    private String URL;

}
