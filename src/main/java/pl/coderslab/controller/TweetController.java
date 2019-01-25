package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.entity.Tweet;
import pl.coderslab.repository.TweetRepository;
import pl.coderslab.repository.UserRepository;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RequestMapping("/tweet")
@Controller
public class TweetController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TweetRepository tweetRepository;

    @GetMapping("/list")
    public String allTweets(Model model) {

        model.addAttribute("tweets", tweetRepository.findAll());
        return "tweet/list";
    }

    @GetMapping("/add")
    public String newTweet(Model model) {
        model.addAttribute("tweet", new Tweet());
        return "tweet/add";
    }

    @GetMapping("/add/{id}")
    public String newTweet(Model model, @PathVariable Long id) {
        Tweet tweet = tweetRepository.findOne(id);
        model.addAttribute("tweet", tweet);
        return "tweet/add";
    }

    @PostMapping("/save")
    public String save(@Valid Tweet tweet, BindingResult errors, HttpServletRequest request) {
        if (errors.hasErrors()) {
            return "tweet/add";
        }
        tweetRepository.save(tweet);
        return "redirect:"+request.getContextPath()+"/tweet/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id, HttpServletRequest request) {
        tweetRepository.delete(tweetRepository.findOne(id));
        return "redirect:"+request.getContextPath()+"/tweet/list";
    }
}
