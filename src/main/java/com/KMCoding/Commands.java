package com.KMCoding;

public class Commands {
    public static String main(String question){
        String q;
        q = question.toLowerCase();

        IRCBot bot = new IRCBot();

        if ((q.contains("hi") || q.contains("hey") || q.contains("hello")) && !q.contains("to")) {
            if (!q.contains("time") && !q.contains("date"))
                return ("Hey! How's it going?");
            if (q.contains("time") && !q.contains("date"))
                return ("Hey! It's " + TimeAndDate.getTime());
            if (q.contains("date") && !q.contains("time"))
                return ("Hey! It's " + TimeAndDate.getDate());
            if (q.contains("time") && q.contains("date"))
                return ("Hey! It's " + TimeAndDate.getTime() + " on " + TimeAndDate.getDate());
        }
        if ((q.contains("time") || q.contains("date")) && !q.contains("to") && !q.contains("hi") && !q.contains("hey") && !q.contains("hello")) {
            if (q.contains("time") && !q.contains("date"))
                return ("It's " + TimeAndDate.getTime());
            if (q.contains("date") && !q.contains("time"))
                return ("It's " + TimeAndDate.getDate());
            if (q.contains("time") && q.contains("date"))
                return ("It's " + TimeAndDate.getTime() + " on " + TimeAndDate.getDate());
        }
        if (((q.contains("time") || q.contains("date")) && q.contains("to")))
            return ("If I had feelings, I'd be flattered");
        if (q.contains("about you") || q.contains("are you"))
            return ("I can't have feelings, Kian thought it would be best if I stay non-sentient.");
        if (q.contains("what") && q.contains("up"))
            return ("Just doing some complex algorithms.");
        if (q.startsWith("ircjoin ")) {
            bot.joinChannel(q.replace("ircjoin ", ""));
            return ("Joined Channel " + q.replace("ircjoin ", ""));
        } else return "";
    }
}
