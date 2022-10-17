package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Text {
    private String fileText;
    private String searchText;
    private List<MatchResult> matchResults;
    private ListIterator<MatchResult> matchResultsIterator;
    private boolean iteratorForward;
    private boolean useRegex;

    public Text(String fileText, String searchText, boolean useRegex) {
        this.fileText = fileText;
        this.searchText = searchText;
        this.matchResults = new ArrayList<>();
        this.iteratorForward = true;
        this.useRegex = useRegex;
    }

    public MatchResult search() {
        if (!useRegex) {
            searchText = Pattern.quote(searchText);
        }
        //String searchTextQuote = Pattern.quote(searchText);
        Pattern pattern = Pattern.compile(searchText);
        Matcher matcher = pattern.matcher(fileText);
        while (matcher.find()) {
            matchResults.add(matcher.toMatchResult());
        }
        this.matchResultsIterator = matchResults.listIterator();
        return next();
    }

    public MatchResult next() {
        if (!iteratorForward) { // sets iterator index correctly based on whether previous request was forward or previous
            matchResultsIterator.next();
        }
        MatchResult matchResult;
        if (matchResults.size() > 0 && matchResultsIterator.hasNext()) {
            matchResult = matchResultsIterator.next();
        } else if (matchResults.size() > 0) {
            while (matchResultsIterator.hasPrevious()) {
                matchResultsIterator.previous();
            }
            matchResult = matchResultsIterator.next();
        } else {
            matchResult = null;
        }
        iteratorForward = true;
        return matchResult;
    }

    public MatchResult previous() {
        if (iteratorForward) { // sets iterator index correctly based on whether previous request was forward or previous
            matchResultsIterator.previous();
        }
        MatchResult matchResult;
        if (matchResults.size() > 0 && matchResultsIterator.hasPrevious()) {
            matchResult = matchResultsIterator.previous();
        } else if (matchResults.size() > 0) {
            while (matchResultsIterator.hasNext()) {
                matchResultsIterator.next();
            }
            matchResult = matchResultsIterator.previous();
        } else {
            matchResult = null;
        }
        iteratorForward = false;
        return matchResult;
    }
}
