package com.dirtybits.spotted.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dirtybits.spotted.R;
import com.dirtybits.spotted.ViewHolders.ViewHolderWanted;

/**
 * Created by Valentinos on 9/4/2016.
 */
public class AdapterWanted  extends RecyclerView.Adapter<ViewHolderWanted>  {
    @Override
    public ViewHolderWanted onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.person_row, parent, false);
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolderWanted holder, int position) {


    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
