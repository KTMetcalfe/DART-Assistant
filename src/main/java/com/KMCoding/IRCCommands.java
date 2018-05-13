package com.KMCoding;

public class IRCCommands extends IRCBot{
    public void main(String channel, String sender, String login, String hostname, String message) {
        if (message.equalsIgnoreCase("+debug") && sender.equalsIgnoreCase("redtek720"))
            sendMessage(channel, channel + " " + sender + " " + login + " " + hostname + " " + message);
        else if (message.startsWith("+ircjoin "))
            joinIRC(message.replace("+", ""));
        else if (message.startsWith("+say"))
            sendMessage(channel, message.replace("+say ", ""));
        else if (message.startsWith("+"))
            sendMessage(channel, "@" + sender + ", " + Commands.main(message).replace("+", ""));
    }

    public void joinIRC(String message) {
        joinChannel("#" + message.replace("ircjoin ", ""));
    }
}
