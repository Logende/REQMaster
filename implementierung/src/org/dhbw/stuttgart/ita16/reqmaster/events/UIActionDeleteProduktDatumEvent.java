package org.dhbw.stuttgart.ita16.reqmaster.events;

import org.dhbw.stuttgart.ita16.reqmaster.model.DataId;

public class UIActionDeleteProduktDatumEvent extends UIActionDeleteEvent {

    private final DataId id;

    public UIActionDeleteProduktDatumEvent(DataId id){
        this.id = id;
    }

    public DataId getId() {
        return id;
    }
}
