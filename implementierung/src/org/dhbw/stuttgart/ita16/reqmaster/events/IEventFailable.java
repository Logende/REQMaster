package org.dhbw.stuttgart.ita16.reqmaster.events;

public interface IEventFailable {

    boolean isSuccess();
    String getErrorMessage();
}
