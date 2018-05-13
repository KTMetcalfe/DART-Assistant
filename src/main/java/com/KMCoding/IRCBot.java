package com.KMCoding;

import org.jibble.pircbot.PircBot;

public class IRCBot extends PircBot {
    public static void main() throws Exception {
        IRCBot bot = new IRCBot();

        bot.setVerbose(true);
        bot.setName("mrbottek");
        bot.connect("irc.chat.twitch.tv", 6667, "oauth:kqfdosubw4bpatt2cu1i4u467r3gw9");
        bot.joinChannel("#redtek720");
    }

    @Override
    public void onMessage(String channel, String sender, String login, String hostname, String message) {
        Main.listChat.getItems().add(0, message);
        if (Main.listChat.getItems().size() > 32) {
            Main.listChat.getItems().clear();
        }
        if (message.equalsIgnoreCase("+debug") && sender.equalsIgnoreCase("redtek720"))
            sendMessage(channel, channel + " " + sender + " " + login + " " + hostname + " " + message);
        else if (message.startsWith("+ircjoin "))
            joinChannel(message.replace("+ircjoin ", ""));
        else if (message.startsWith("+say"))
            sendMessage(channel, message.replace("+say ", ""));
        else if (message.startsWith("+"))
            sendMessage(channel, "@" + sender + ", " + Commands.main(message).replace("+", ""));
    }
}