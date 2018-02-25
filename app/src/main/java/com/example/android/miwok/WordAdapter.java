package com.example.android.miwok;

import android.app.Activity;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by RajPrabhakar on 24-02-2018.
 */

public class WordAdapter extends ArrayAdapter<Word> {

    private int mColorResourceId;

    public WordAdapter(Activity context, ArrayList<Word> words, int ColorResourceId) {
        super(context, 0, words);
        mColorResourceId = ColorResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Word currentWord = getItem(position);
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        TextView defaultNumberTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        defaultNumberTextView.setText(currentWord.getDefaultTranslation());

        TextView miwokNumberTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        miwokNumberTextView.setText(currentWord.getMiwokTranslation());

        ImageView mImageView = (ImageView) listItemView.findViewById(R.id.image_view);
        if(currentWord.hasImage()) {
            mImageView.setImageResource(currentWord.getImageResourceId());
            mImageView.setVisibility(View.VISIBLE);
        } else {
            mImageView.setVisibility(View.GONE);
        }

        View textContainer = listItemView.findViewById(R.id.textContainer);
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        textContainer.setBackgroundColor(color);
        return listItemView;
    }
}
