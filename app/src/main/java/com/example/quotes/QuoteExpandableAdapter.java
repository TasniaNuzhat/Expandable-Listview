package com.example.quotes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;

import java.util.HashMap;
import java.util.List;


public class QuoteExpandableAdapter extends BaseExpandableListAdapter {

    private Context context;
    private List<String> groupTitles;
    private HashMap<String, List<String>> childQuotes;
    private HashMap<String, Integer> groupImages;

    public QuoteExpandableAdapter(Context context, List<String> groupTitles, HashMap<String, List<String>> childQuotes) {
        this.context = context;
        this.groupTitles = groupTitles;
        this.childQuotes = childQuotes;
        this.groupImages = new HashMap<>();


        groupImages.put("Success", R.drawable.success);
        groupImages.put("Friendship", R.drawable.friendship);
        groupImages.put("Nature", R.drawable.nature);
        groupImages.put("Happy",R.drawable.happy);
        groupImages.put("Science",R.drawable.science);
        groupImages.put("Time",R.drawable.time);
        groupImages.put("Love",R.drawable.love);
    }

    @Override
    public int getGroupCount() {
        return groupTitles.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return childQuotes.get(groupTitles.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return groupTitles.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return childQuotes.get(groupTitles.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.quote_group, null);
        }


        TextView quoteTitle = convertView.findViewById(R.id.quoteTitle);
        quoteTitle.setText(groupTitles.get(groupPosition));


        ImageView quoteImage = convertView.findViewById(R.id.quoteImage);
        quoteImage.setImageResource(groupImages.get(groupTitles.get(groupPosition)));

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.quote_child, null);
        }


        TextView quote = convertView.findViewById(R.id.quoteText);
        quote.setText(childQuotes.get(groupTitles.get(groupPosition)).get(childPosition));

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
