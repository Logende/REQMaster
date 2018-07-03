package org.dhbw.stuttgart.ita16.reqmaster.events;

/**
 * Klasse für Modifyevents. Kann fehlschlagen, wenn z.B. vom Anwender eingebene Ids  bereits vorhanden sind.
 */
class UIModifyEvent extends UIEvent implements IEventFailable{

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
