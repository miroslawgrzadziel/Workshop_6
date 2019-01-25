package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.entity.User;
import pl.coderslab.repository.TweetRepository;
import pl.coderslab.repository.UserRepository;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/user")
@Controller
public class UserController{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TweetRepository tweetRepository;

    @GetMapping("/all")
    public String allUsers(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "user/list";
    }

    @GetMapping("/add")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "user/add";
    }

    @GetMapping("/add/{id}")
    public String newUser(Model model, @PathVariable Long id) {
        User user = userRepository.findOne(id);
        model.addAttribute("user", user);
        return "user/add";
    }

    @PostMapping("/save")
    public String save(@Valid User user, BindingResult errors, HttpServletRequest request) {
        if (errors.hasErrors()) {
            return "user/add";
        }
        userRepository.save(user);
        return "redirect:"+request.getContextPath()+"/user/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id, HttpServletRequest request) {
        userRepository.delete(userRepository.findOne(id));
        return "redirect:"+request.getContextPath()+"/user/list";
    }

    @GetMapping("/{id}/tweets")
    public String findById(Model model, @PathVariable Long id) {
        User user = userRepository.findOne(id);
//        model.addAttribute("tweets", tweetRepository.findAllByUser(user)); //koniec czasu, nie powinienem przekazywać listy :(
        return "tweet/list";
    }

    @GetMapping("/search-tweets/{title}")
    public String searchTweets(Model model, @PathVariable String title) {
        model.addAttribute("tweets", tweetRepository.getByTitleStartingWith(title));
        return "tweet/list";
    }


}
