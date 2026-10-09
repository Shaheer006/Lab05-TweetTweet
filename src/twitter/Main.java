package twitter;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class Main {
    
    public static void main(String[] args) {
        try {
            assert false;
            throw new Error("Always run main and tests with assertions enabled");
        } catch (AssertionError ae) { }
        
        // Recreating offline sample tweets since the MIT server is dead
        final List<Tweet> tweets = Arrays.asList(
            new Tweet(1, "alyssa", "is it reasonable to talk about rivest so much?", Instant.parse("2016-02-17T10:00:00Z")),
            new Tweet(2, "bbitdiddle", "rivest talk in 30 minutes #hype", Instant.parse("2016-02-17T11:00:00Z")),
            new Tweet(3, "alyssa", "@bbitdiddle saving you a seat in 32-123", Instant.parse("2016-02-17T11:20:00Z")),
            new Tweet(5, "cy_d_fect", "anyone started pset 1 yet? mail me at cy@mit.edu", Instant.parse("2016-02-17T13:40:00Z")),
            new Tweet(7, "alyssa", "test-first programming actually saved me an hour on the PSET", Instant.parse("2016-02-17T16:30:00Z"))
        );
        
        System.err.println("fetched " + tweets.size() + " tweets");
        
        final Timespan span = Extract.getTimespan(tweets);
        System.err.println("ranging from " + span.getStart() + " to " + span.getEnd());
        
        final Set<String> mentionedUsers = Extract.getMentionedUsers(tweets);
        System.err.println("covers " + mentionedUsers.size() + " Twitter users");
        
        System.err.println("\ntweets written by alyssa:");
        for (Tweet t : Filter.writtenBy(tweets, "alyssa")) {
            System.err.println(t.toString());
        }
        
        System.err.println("\ntweets containing 'rivest' or 'pset':");
        for (Tweet t : Filter.containing(tweets, Arrays.asList("rivest", "pset"))) {
            System.err.println(t.toString());
        }
    }
}