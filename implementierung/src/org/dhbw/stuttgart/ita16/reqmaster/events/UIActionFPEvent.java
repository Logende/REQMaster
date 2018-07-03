package org.dhbw.stuttgart.ita16.reqmaster.events;


/**
 * Klasse für FunctionPoint events. Kann fehlschlagen, wenn z.B. Eingabewerte invalide sind.
 */
class UIActionFPEvent extends UIActionEvent implements IEventFailable{


    private boolean success;
    private String error;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setErrorMessage(String s){
        this.error = s;
    }

    public String getErrorMessage(){
        return this.error;
    }


}
