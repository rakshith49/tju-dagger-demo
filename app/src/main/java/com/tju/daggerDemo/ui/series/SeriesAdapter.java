package com.tju.daggerDemo.ui.series;

import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.simplecityapps.recyclerview_fastscroll.views.FastScrollRecyclerView;
import com.tju.daggerDemo.R;
import com.tju.daggerDemo.model.pojo.SearchModel;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SeriesAdapter extends RecyclerView.Adapter<SeriesAdapter.SeriesViewHolder>
        implements FastScrollRecyclerView.SectionedAdapter {

    private ArrayList<SearchModel> seriesList;
    private SeriesPresenter mPresenter;

    public SeriesAdapter() {
        seriesList = new ArrayList<>();
    }

    @Override
    public SeriesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_item, parent, false);
        return new SeriesViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(SeriesViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return seriesList.size();
    }


    public void setSeriesList(ArrayList<SearchModel> seriesList) {
        this.seriesList = seriesList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public String getSectionName(int position) {
        return null;
    }

    public void setPresenter(SeriesPresenter presenter) {
        mPresenter = presenter;
    }


    public class SeriesViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.view_Container)
        LinearLayout mContainerLayout;

        @Bind(R.id.poster_img)
        AppCompatImageView posterImageView;
        @Bind(R.id.title)
        AppCompatTextView titleView;
        @Bind(R.id.type)
        AppCompatTextView typeView;
        @Bind(R.id.year)
        AppCompatTextView yearView;


        public SeriesViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContainerLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mPresenter.clickedSeriesItem(seriesList.get(getLayoutPosition()));
                }
            });
        }

        public void bind(int position) {
            SearchModel series = seriesList.get(position);
            titleView.setText(series.getTitle());
            typeView.setText((!series.getType().isEmpty()) ? "Type : " + series.getType() : "Type : NA");
            yearView.setText((!series.getYear().isEmpty()) ? "Year : " + series.getYear() : "Year : NA");
            Glide.with(posterImageView.getContext())
                    .load(series.getPosterImage())
                    .placeholder(ContextCompat.getDrawable(posterImageView.getContext(),R.drawable.cover1))
                    .error(ContextCompat.getDrawable(posterImageView.getContext(),R.drawable.cover1))
                    .into(posterImageView);
        }
    }
}
