package org.dhbw.stuttgart.ita16.reqmaster.events;

class UIModifyEvent extends UIEvent {

	private boolean success;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}
}
