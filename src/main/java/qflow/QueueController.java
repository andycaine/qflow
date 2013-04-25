package qflow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/queues")
public class QueueController {

    public static final String NEW_VIEW = "queues/new";

    private final QueueServiceFacade queueServiceFacade;

    @Autowired
    public QueueController(QueueServiceFacade queueServiceFacade) {
        this.queueServiceFacade = queueServiceFacade;
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String newQueue(Model model) {
        model.addAttribute("queue", new QueueDTO());
        return NEW_VIEW;
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String createQueue(@ModelAttribute QueueDTO queue, Errors errors) {
        if (errors.hasErrors()) {
            return NEW_VIEW;
        }
        queueServiceFacade.createQueue(queue);
        return "redirect:/queues";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String listQueues(Model model) {
        
        return "queues/list";
    }

}
