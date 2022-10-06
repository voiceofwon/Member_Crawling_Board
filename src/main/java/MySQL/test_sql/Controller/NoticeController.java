package MySQL.test_sql.Controller;

import MySQL.test_sql.DTO.NoticeDto;
import MySQL.test_sql.Form.NoticeForm;
import MySQL.test_sql.Service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class NoticeController {

    private final NoticeService noticeService;

    @GetMapping(value = "/notices")
    public String createForm(Model model){

        model.addAttribute("noticeForm", new NoticeForm());
        noticeService.AjouCrawling();
        return "notices/noticeAll";
    }

    @GetMapping(value = "/notices/search")
    public String Search(@RequestParam(value = "keyword") String keyword, Model model){
        List<NoticeDto> notices = noticeService.searchNotices(keyword);
        model.addAttribute("noticeList", notices);

        return "notices/noticeAll";

    }

}
