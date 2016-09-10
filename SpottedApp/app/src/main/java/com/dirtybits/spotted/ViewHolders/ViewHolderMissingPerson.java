package com.dirtybits.spotted.ViewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.dirtybits.spotted.Interfaces.OnRecyclerViewItemClickListener;
import com.dirtybits.spotted.Models.MissingPerson;
import com.dirtybits.spotted.R;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Valentinos on 9/10/2016.
 */
public class ViewHolderMissingPerson extends RecyclerView.ViewHolder {

    public TextView textviewName;
    public TextView textviewDate;
    public TextView textviewSpottedTime;
    public CircleImageView imageButtonPicture;
    public Button reportButton;

    public  ViewHolderMissingPerson(View itemView) {
        super(itemView);
        imageButtonPicture = (CircleImageView) itemView.findViewById(R.id.imageButtonPicture);
        textviewDate = (TextView) itemView.findViewById(R.id.textViewDate);
        textviewSpottedTime = (TextView) itemView.findViewById(R.id.textViewSpottedTimes);
        textviewName = (TextView) itemView.findViewById(R.id.textViewName);
        reportButton = (Button) itemView.findViewById(R.id.buttonReport);
    }
}
