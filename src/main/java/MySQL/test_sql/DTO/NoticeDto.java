package MySQL.test_sql.DTO;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter@Builder
public class NoticeDto {

    private long id;
    private String title;
    private String URL;
}
