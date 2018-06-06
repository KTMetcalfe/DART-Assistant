package com.KMCoding;

import org.jibble.pircbot.PircBot;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class IRCBot extends PircBot {
    /**If you get any issues just comment out IRCBot.main in the main method of Main*/

    public static void main() throws Exception {
        File token = new File("C:\\Users\\kmetc\\Google Drive\\IntelliJ\\Projects\\token.txt");
        BufferedReader tokenReader = new BufferedReader(new FileReader(token));

        IRCBot bot = new IRCBot();

        bot.setVerbose(true);
        bot.setName("mrbottek");
        bot.connect("irc.chat.twitch.tv", 6667, "oauth:"+tokenReader.readLine());
        bot.joinChannel("#default");
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
            joinChannel("#" + message.replace("+ircjoin ", ""));
        else if (message.startsWith("+say"))
            sendMessage(channel, message.replace("+say ", ""));
        else if (message.startsWith("+"))
            sendMessage(channel, "@" + sender + ", " + Commands.Main(message).replace("+", ""));
    }
}