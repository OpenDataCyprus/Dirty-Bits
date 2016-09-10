package com.dirtybits.spotted.ViewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.dirtybits.spotted.R;

/**
 * Created by Valentinos on 9/4/2016.
 */
public class ViewHolderWanted extends RecyclerView.ViewHolder {

    public TextView textviewName;
    public TextView textviewDate;
    public TextView textviewSpottedTime;
    public ImageButton imageButtonPicture;

    public ViewHolderWanted(View itemView) {
        super(itemView);

        imageButtonPicture = (ImageButton) itemView.findViewById(R.id.imageButtonPicture);
        textviewDate = (TextView) itemView.findViewById(R.id.textViewDate);
        textviewSpottedTime = (TextView) itemView.findViewById(R.id.textViewSpottedTimes);
        textviewName = (TextView) itemView.findViewById(R.id.textViewName);
    }
}
