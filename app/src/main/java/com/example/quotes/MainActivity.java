package com.example.quotes;

import android.os.Bundle;
import android.widget.ExpandableListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ExpandableListView expandableListView;
    private List<String> groupTitles;
    private HashMap<String, List<String>> childQuotes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        expandableListView = findViewById(R.id.expandableListView);
        setupData();

        QuoteExpandableAdapter adapter = new QuoteExpandableAdapter(this, groupTitles, childQuotes);
        expandableListView.setAdapter(adapter);


        expandableListView.setOnGroupExpandListener(groupPosition -> {
            for (int i = 0; i < groupTitles.size(); i++) {
                if (i != groupPosition) {
                    expandableListView.collapseGroup(i);
                }
            }
        });
    }

    private void setupData() {
        groupTitles = new ArrayList<>();
        childQuotes = new HashMap<>();


        groupTitles.add("Success");
        groupTitles.add("Friendship");
        groupTitles.add("Nature");
        groupTitles.add("Happy");
        groupTitles.add("Science");
        groupTitles.add("Time");
        groupTitles.add("Love");

        List<String> successQuotes = new ArrayList<>();
        successQuotes.add("Success is not final; failure is not fatal: It is the courage to continue that counts.");
        successQuotes.add("Don't watch the clock; do what it does. Keep going.");
        successQuotes.add("The road to success and the road to failure are almost exactly the same.");
        successQuotes.add("To succeed in life, you need three things: a wishbone, a backbone, and a funny bone.");

        List<String> friendshipQuotes = new ArrayList<>();
        friendshipQuotes.add("Friendship is the only cement that will ever hold the world together.");
        friendshipQuotes.add("A real friend is one who walks in when the rest of the world walks out.");
        friendshipQuotes.add("True friendship comes when the silence between two people is comfortable.");

        List<String> natureQuotes = new ArrayList<>();
        natureQuotes.add("Nature is not a place to visit, it is home.");
        natureQuotes.add("What is the good of your stars and trees, your sunrise and the wind, if they do not enter into our daily lives?");
        natureQuotes.add("For a time, I rest in the grace of the world, and am free.");
        natureQuotes.add("It never hurts to keep looking for sunshine.");

        List<String> happyQuotes = new ArrayList<>();
        happyQuotes.add("Happiness shared is happiness doubled.");
        happyQuotes.add("Happiness can be found even in the darkest of times if one remembers to turn on the light.");
        happyQuotes.add("If you want to live a happy life, tie it to a goal, not people or things.");
        happyQuotes.add("Happiness comes from you. No one else can make you happy. You make you happy.");

        List<String> scienceQuotes = new ArrayList<>();
        scienceQuotes.add("Science is nothing but perception.");
        scienceQuotes.add("The science of today is the technology of tomorrow.");
        scienceQuotes.add("The human brain is an incredible pattern-matching machine");

        List<String> timeQuotes = new ArrayList<>();
        timeQuotes.add("We must use time as a tool, not as a couch");
        timeQuotes.add("Time you enjoy wasting is not wasted time.");
        timeQuotes.add("Time doesn’t heal emotional pain, you need to learn how to let go.");

        List<String> loveQuotes = new ArrayList<>();
        loveQuotes.add("Love yourself first and everything else falls into line. You really have to love yourself to get anything done in this world.");
        loveQuotes.add("You always gain by giving love.");
        loveQuotes.add("Love is friendship that has caught fire.");









        childQuotes.put(groupTitles.get(0), successQuotes);
        childQuotes.put(groupTitles.get(1), friendshipQuotes);
        childQuotes.put(groupTitles.get(2),natureQuotes);
        childQuotes.put(groupTitles.get(3), happyQuotes);
        childQuotes.put(groupTitles.get(4), scienceQuotes);
        childQuotes.put(groupTitles.get(5), timeQuotes);
        childQuotes.put(groupTitles.get(6), loveQuotes);

    }
}
