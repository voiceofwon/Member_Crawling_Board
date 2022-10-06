package MySQL.test_sql.Controller;

import MySQL.test_sql.Entity.Member;
import MySQL.test_sql.Form.MemberForm;
import MySQL.test_sql.Service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping(value = "/members/new")
    public String createForm(Model model){
        model.addAttribute("memberForm",new MemberForm());
        return "members/createMemberForm";
    }

    @PostMapping(value = "/members/new")
    public String create(@Valid MemberForm form, BindingResult result){
        if(result.hasErrors()){
            return "members/createMemberForm";
        }
        Member member = new Member();
        member.setS_id(form.getS_id());
        memberService.join(member);

        return "redirect:/";

    }
}
