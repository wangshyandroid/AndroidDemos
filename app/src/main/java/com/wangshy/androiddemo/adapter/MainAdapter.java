package com.wangshy.androiddemo.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wangshy.androiddemo.R;

import java.util.List;

/**
 * Created by wangshy on 17/2/8.
 */

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {
    public MainAdapter(List<String> mList) {
        this.mList = mList;
    }

    private List<String> mList;

    private IRecyclerView view;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_recycler_itme, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.itme_text.setText(mList.get(position));
        holder.itme_layout.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (view != null) {
                            view.onCheck(position);
                        }
                    }
                });
    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView itme_text;
        CardView itme_layout;

        public ViewHolder(View itemView) {
            super(itemView);
            itme_text = (TextView) itemView.findViewById(R.id.itme_text);
            itme_layout = (CardView) itemView.findViewById(R.id.itme_layout);
        }
    }

    public void setOn(IRecyclerView view) {
        this.view = view;
    }

    public interface IRecyclerView {
        void onCheck(int position);
    }
}
