package com.example.bitbucket.rx;

import rx.Scheduler;

public interface SchedulerProvider {

    Scheduler io();

    Scheduler computation();

    Scheduler main();
}
