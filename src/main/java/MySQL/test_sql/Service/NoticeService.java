package MySQL.test_sql.Service;

import MySQL.test_sql.DTO.NoticeDto;
import MySQL.test_sql.Entity.Member;
import MySQL.test_sql.Entity.Notice;
import MySQL.test_sql.Repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.jsoup.Connection;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;
import org.jsoup.Jsoup;
import javax.transaction.Transactional;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class NoticeService {

    private final NoticeRepository noticeRepository;

    public List<NoticeDto> searchNotices(String keyword){
        List<Notice> notices = noticeRepository.findByTitleContaining(keyword);
        List<NoticeDto> noticeDtoList = new ArrayList<>();

        if(notices.isEmpty()) return noticeDtoList;

        for(Notice notice : notices){
            noticeDtoList.add(this.convertEntityToDto(notice));
        }
        return noticeDtoList;
    }

    private NoticeDto convertEntityToDto(Notice notice){
        return NoticeDto.builder()
                .id(notice.getId())
                .title(notice.getTitle())
                .URL(notice.getURL())
                .build();
    }

    public void AjouCrawling(){
        final String ajouURL ="https://www.ajou.ac.kr/kr/ajou/notice.do?mode=list&&articleLimit=10&article.offset=0";
        Connection conn = Jsoup.connect(ajouURL);
        try {
            Document document = conn.get();
            Elements title = document.select("div.b-title-box > a");
            for (Element element : title) {
                Notice notice = new Notice();
                notice.setURL(element.attr("abs:href").substring(8));
                notice.setTitle(element.attr("title"));
                noticeRepository.save(notice);
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
