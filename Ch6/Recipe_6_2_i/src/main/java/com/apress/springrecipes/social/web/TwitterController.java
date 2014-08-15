package com.apress.springrecipes.social.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by marten on 14-07-14.
 */
@Controller()
@RequestMapping("/user")
public class TwitterController {

    private final Twitter twitter;
    private final ConnectionRepository repository;

    @Autowired
    public TwitterController(Twitter twitter, ConnectionRepository repository) {
        this.twitter = twitter; this.repository=repository;
    }

    @RequestMapping(value="/twitter/profile", method= RequestMethod.GET)
    public String showTwitterprofile(Model model) {
        if (repository.findPrimaryConnection(Twitter.class) == null) {
            return "redirect:/connect/twitter";
        }
        model.addAttribute("twitterProfile", twitter.userOperations().getUserProfile());
        model.addAttribute("tweets", twitter.timelineOperations().getUserTimeline(10));
        return "twitter-info";

    }
}
