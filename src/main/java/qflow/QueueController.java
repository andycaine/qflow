package qflow;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/queues")
public class QueueController {

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String newQueueForm(Model model) {
        model.addAttribute("queue", new QueueDTO());
        return "queues/new";
    }

}
