package com.example.bitbucket.ui.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.bitbucket.R;
import com.example.bitbucket.domain.models.Statement;

import java.util.LinkedList;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.MyViewHolder> {
    private Context context;
    private LinkedList<Statement> statements;

    public ItemAdapter(Context context, LinkedList<Statement> statements) {
        this.context = context;
        this.statements = statements;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.
                from(context).
                inflate(R.layout.item_statement, parent, false);

        return new MyViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Statement statement = statements.get(position);
        holder.vFrom.setText(statement.getFrom());
        holder.vTo.setText(statement.getTo());
        holder.vDetails.setText(statement.getDetails());
        holder.vStatus.setText(statement.getStatus());
    }


    @Override
    public int getItemCount() {

        return this.statements.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.from)
        TextView vFrom;
        @BindView(R.id.to)
        TextView vTo;
        @BindView(R.id.status)
        TextView vStatus;
        @BindView(R.id.details)
        TextView vDetails;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
