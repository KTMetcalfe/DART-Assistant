package com.KMCoding;

import javafx.scene.control.ListView;
import org.jibble.pircbot.PircBot;

public class IRCBot extends PircBot {
    public static void main(String ircChannel) throws Exception {
        IRCBot bot = new IRCBot();

        bot.setVerbose(true);
        bot.setName("mrbottek");
        bot.connect("irc.chat.twitch.tv", 6667, "oauth:kqfdosubw4bpatt2cu1i4u467r3gw9");
        bot.joinChannel("#" + ircChannel);
    }

    public static ListView listChat = new ListView();

    public void onMessage(String channel, String sender, String login, String hostname, String message) {
        listChat.getItems().add(0, message);
        if (listChat.getItems().size() > 32) {
            listChat.getItems().clear();
        }


        if (message.equalsIgnoreCase("+debug") && sender.equalsIgnoreCase("redtek720")) {
            sendMessage(channel, channel + " " + sender + " " + login + " " + hostname + " " + message);
        }
    }
}