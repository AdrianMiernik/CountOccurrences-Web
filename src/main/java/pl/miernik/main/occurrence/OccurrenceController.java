package pl.miernik.main.occurrence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class OccurrenceController {
    private final OccurrenceService service;

    @Autowired
    public OccurrenceController(OccurrenceService service) {
        this.service = service;
    }


    @GetMapping("/")
    @ResponseBody
    public String welcome() {
        return ("Welcome - I am working ;) ");
    }

    @GetMapping("/input")
    public String getUserInput(Model m) {
        m.addAttribute("occurrence",new Occurrence() );
        return "form";
    }

    @PostMapping("/input")
    public String getUserInputPost(Occurrence occurrence,
                                   Model m) {
        String clearedKeyword = service.clear(occurrence.getKeyword());
        String clearedSentence = service.clear(occurrence.getSentence());
        int sentenceLength = clearedSentence.length();

        occurrence.setKeyword(clearedKeyword);
        occurrence.setSentence(clearedSentence);
        occurrence.setTotalLength(sentenceLength);
        this.service.save(occurrence);
        m.addAttribute("occurrence", occurrence);
        m.addAttribute("maps", service.map(occurrence.getKeyword(),occurrence.getSentence()));
        m.addAttribute("occurrenceLength", service.getLengthWithoutSpecial(occurrence.getKeyword(),occurrence.getSentence()));
        m.addAttribute("totalLength", occurrence.getTotalLength());
        return "details";
    }


}
