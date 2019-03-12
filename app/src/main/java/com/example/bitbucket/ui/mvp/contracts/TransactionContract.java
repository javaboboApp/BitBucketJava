package com.example.bitbucket.ui.mvp.contracts;


import com.example.bitbucket.domain.models.Transaction;
import com.example.bitbucket.ui.mvp.shared.BaseContract;


import java.util.LinkedList;

public interface TransactionContract {

    interface View extends BaseContract.View {


        void stateError();

        void stateEmpty();

        void stateSucess(Transaction transaction);


        ;
    }

    interface Presenter extends BaseContract.Presenter<View> {
        void getTransaction();

        void onViewDetached();

    }
}
