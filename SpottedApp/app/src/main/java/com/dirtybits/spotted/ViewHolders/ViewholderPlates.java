package com.dirtybits.spotted.ViewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;


public class ViewholderPlates extends RecyclerView.ViewHolder {

    public TextView textviewPlateNumber;
    public TextView textviewDate;
    public TextView textviewSpottedTime;
    public TextView textviewBrand;
    public TextView textviewColor;
   
    public ViewholderPlates(View itemView) {
        super(itemView);
    }
}
