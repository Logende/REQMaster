package org.dhbw.stuttgart.ita16.reqmaster.events;


public class UIErrorEvent extends UIEvent implements IEventFailable{


    private final String error;

    public UIErrorEvent(String error) {
        this.error = error;
    }

    @Override
    public boolean isSuccess() {
        return false;
    }

    @Override
    public String getErrorMessage() {
        return error;
    }
}
