package com.example.bitbucket.ui.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.example.bitbucket.BitBuketApp;
import com.example.bitbucket.R;
import com.example.bitbucket.domain.models.Transaction;
import com.example.bitbucket.ui.adapters.ItemAdapter;
import com.example.bitbucket.ui.helpers.ItemClickHelper;
import com.example.bitbucket.ui.mvp.contracts.TransactionContract;

import java.util.LinkedList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements TransactionContract.View {


    @Inject
    TransactionContract.Presenter presenter;
    RecyclerView recyclerView;
    @BindView(R.id.progress)
    ProgressBar progressBar;

    ItemAdapter itemAdapter;
    private Transaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initializeDagger();
        setupPresenter();
        getTransaction();
    }

    private void initViews() {
        ButterKnife.bind(this);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_browse);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        ItemClickHelper.addTo(recyclerView).setOnItemClickListener(new ItemClickHelper.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                Intent intent2 = new Intent(MainActivity.this, DetailsTransactionActivity.class);
                intent2.putExtra("item", transaction.getStatements().get(position));
                startActivity(intent2);            }
        });
    }

    private void getTransaction() {
        progressBar.setVisibility(View.VISIBLE);
        presenter.getTransaction();
    }


    private void initializeDagger() {
        BitBuketApp app = (BitBuketApp) getApplication();
        app.getMainComponent().inject(this);
    }

    private void setupPresenter() {
        presenter.setView(this);
    }

    @Override
    public void stateError() {
        //TODO DO SOMETHING SHOW A ERROR MESSAGE...
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void stateEmpty() {
        //TODO DO SOMETHING SHOW A EMPTY MESSAGE...

        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void stateSucess(Transaction transaction) {
        progressBar.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);
        Log.v("transaction", transaction.toString());
        itemAdapter = new ItemAdapter(this, new LinkedList<>(transaction.getStatements()));
        recyclerView.setAdapter(itemAdapter);
        this.transaction = transaction;

    }

    @Override
    protected void onDestroy() {
        //Before go destroy all the subcribers.
        presenter.onViewDetached();
        super.onDestroy();
    }
}
