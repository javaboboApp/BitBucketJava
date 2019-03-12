package com.example.bitbucket.ui.mvp.presenters;

import android.support.annotation.NonNull;
import android.util.Log;

import com.example.bitbucket.domain.models.Transaction;
import com.example.bitbucket.domain.usecases.GetTransaction;
import com.example.bitbucket.rx.SchedulerProvider;
import com.example.bitbucket.ui.mvp.contracts.TransactionContract;
import com.example.bitbucket.ui.mvp.shared.BasePresenter;

import rx.Subscriber;


public class TransactionActivityPresenter extends BasePresenter<TransactionContract.View> implements TransactionContract.Presenter {

    private TransactionContract.View view;
    private GetTransaction getTransaction;
    private SchedulerProvider mSchedulerProvider;

    public TransactionActivityPresenter(SchedulerProvider schedulerProvider, GetTransaction getTransaction) {
        this.getTransaction = getTransaction;
        this.mSchedulerProvider = schedulerProvider;

    }

    @Override
    public void setView(@NonNull TransactionContract.View view) {
        this.view = view;
    }

    @Override
    public void getTransaction() {
        rx.Observable<Transaction> observable = getTransaction.getTransaction();

        subscribe(observable.subscribeOn(mSchedulerProvider.io())
                .observeOn(mSchedulerProvider.main())
                .subscribe(new Subscriber<Transaction>() {

                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable throwable) {
                        Log.v("Error", "subscribe->subscribe->onError->(" + throwable.getMessage() + ")");
                        view.stateError();
                    }

                    @Override
                    public void onNext(Transaction transaction) {
                        Log.v("Sucess on the response", " getTransaction()");
                        handleResponse(transaction);
                    }
                }));

    }

    private void handleResponse(Transaction transaction) {
        if (!transaction.getStatus().equals("Succeeded")) {
            view.stateError();
            return;
        }
        if (transaction.getStatements().size() == 0) view.stateEmpty();
        else view.stateSucess(transaction);

    }
}
