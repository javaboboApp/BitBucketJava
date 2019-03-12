package com.example.bitbucket.ui.mvp.shared;

import android.support.annotation.NonNull;

public interface BaseContract {

  interface View {
  }

  interface Presenter<T extends View> {


    public void setView(@NonNull T view);



  }
}
