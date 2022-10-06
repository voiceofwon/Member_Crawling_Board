package MySQL.test_sql.Form;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter@Setter
public class MemberForm {

    @NotNull(message = "학번 입력은 필수 입니다.")
    private Long S_id;
}
