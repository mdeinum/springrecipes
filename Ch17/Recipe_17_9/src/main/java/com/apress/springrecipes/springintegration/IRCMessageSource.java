package com.apress.springrecipes.springintegration;

import org.pircbotx.Configuration;
import org.pircbotx.PircBotX;
import org.pircbotx.exception.IrcException;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;
import org.springframework.beans.factory.BeanInitializationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.integration.core.MessageSource;
import org.springframework.integration.endpoint.MessageProducerSupport;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessageHeaders;

import java.io.IOException;

/**
 * Created by marten on 14-04-14.
 */
public class IRCMessageSource extends MessageProducerSupport {

    private PircBotX bot;

    @Override
    public String getComponentType() {
        return "irc:inbound-channel-adapter";
    }

    @Override
    protected void onInit() {
        Configuration<PircBotX> config = new Configuration.Builder()
                .setName("SpringRecipesBot") //Nick of the bot. CHANGE IN YOUR CODE
                .setLogin("SpringRecipes3") //Login part of hostmask, eg name:login@host
                .setAutoNickChange(true) //Automatically change nick when the current one is in use
                .setServerHostname("irc.freenode.net") //The server were connecting to
                .addAutoJoinChannel("#sr3rd") //Join #pircbotx channel on connect
                .addListener(new IrcEventListener())
                .buildConfiguration(); //Create an immutable configuration from this builder

        bot = new PircBotX(config);
    }

    @Override
    protected void doStart() {
        try {
            bot.startBot();
        } catch (IOException | IrcException e) {
            throw new BeanInitializationException("failed to start.", e);
        }
    }

    private class IrcEventListener extends ListenerAdapter {

        @Override
        public void onMessage(MessageEvent event) throws Exception {
            Message msg = MessageBuilder.withPayload(event.getUser().getNick() + ":" + event.getMessage())
                    .build();
            IRCMessageSource.this.sendMessage(msg);
        }
    }


}
