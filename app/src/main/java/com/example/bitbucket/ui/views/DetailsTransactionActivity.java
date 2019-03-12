package com.example.bitbucket.ui.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.bitbucket.R;
import com.example.bitbucket.domain.models.Statement;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailsTransactionActivity extends AppCompatActivity {
    @BindView(R.id.from)
    TextView from;
    @BindView(R.id.to)
    TextView to;

    @BindView(R.id.details)
    TextView details;
    @BindView(R.id.status)
    TextView status;
    @BindView(R.id.dateTime)
    TextView dateTime;
    @BindView(R.id.credit)
    TextView credit;
    @BindView(R.id.debit)
    TextView debit;
    @BindView(R.id.id)
    TextView id;
    @BindView(R.id.reference)
    TextView reference;
    @BindView(R.id.currencyCode)
    TextView currencyCode;

    @BindView(R.id.contCredit)
    LinearLayout contCredit;
    @BindView(R.id.contDebit)
    LinearLayout contDebit;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_transaction);
        setupView();
        setupStatement();


    }

    private void setupStatement() {
        try {
            Statement statement = (Statement) getIntent().getExtras().getSerializable("item");
            from.setText("From: " + statement.getFrom());
            to.setText("To: " + statement.getTo());
            details.setText("Details: " + statement.getDetails());
            status.setText("Status: " + statement.getStatus());
            dateTime.setText("Time: " + statement.getDateTime());
            if (!statement.getCredit().equals("0,00")) {
                credit.setText(statement.getCredit());
                contDebit.setVisibility(View.GONE);
            }else {
                debit.setText(statement.getDebit());
                contCredit.setVisibility(View.GONE);
            }

            id.setText(" Transaction Id: " + statement.getTransactionID());
            if (!statement.getReference().equals("null"))
                reference.setText(statement.getReference());
            currencyCode.setText(statement.getCurrencyCode());
        } catch (NullPointerException e) {
            Log.e("exeption null", "null pointer");
        }
    }

    private void setupView() {
        ButterKnife.bind(this);

    }
}
