package com.apress.springrecipes.social.config;

import com.apress.springrecipes.social.StaticUserIdSource;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.social.UserIdSource;
import org.springframework.social.config.annotation.EnableSocial;
import org.springframework.social.config.annotation.SocialConfigurerAdapter;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.web.ReconnectFilter;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.OAuth2Operations;
import org.springframework.social.oauth2.OAuth2Template;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.impl.TwitterTemplate;

/**
 * Created by marten on 14-07-14.
 */
@Configuration
@EnableSocial
@PropertySource("classpath:/application.properties")
public class SocialConfig extends SocialConfigurerAdapter {

    @Bean
    @Scope(value = "request", proxyMode = ScopedProxyMode.INTERFACES)
    public Twitter twitterTemplate(ConnectionRepository repository, Environment env) {
        OAuth2Operations operations = new OAuth2Template(
                env.getRequiredProperty("spring.social.twitter.appId"),
                env.getRequiredProperty("spring.social.twitter.appSecret"),
                "",
                "https://api.twitter.com/oauth/access_token");
        AccessGrant accessGrant = operations.authenticateClient();
        return new TwitterTemplate(accessGrant.getAccessToken());
    }

    @Bean
    public ReconnectFilter reconnectFilter(UsersConnectionRepository usersConnectionRepository, UserIdSource userIdSource) {
        return new ReconnectFilter(usersConnectionRepository, userIdSource);
    }


    @Override
    public UserIdSource getUserIdSource() {
        return new StaticUserIdSource();
    }
}
