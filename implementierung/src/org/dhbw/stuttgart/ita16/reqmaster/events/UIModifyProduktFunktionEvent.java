package org.dhbw.stuttgart.ita16.reqmaster.events;

import org.dhbw.stuttgart.ita16.reqmaster.model.DataId;
import org.dhbw.stuttgart.ita16.reqmaster.model.DataProduktFunktion;
import org.dhbw.stuttgart.ita16.reqmaster.model.IIdentifiable;

public class UIModifyProduktFunktionEvent extends UIModifyEvent {

    private final DataId id;
    private final DataProduktFunktion proposal;

    /**
     * Konstruktor für die Klasse schreibt Eingansvariablen auf Klassenvariablen um
     * @param id
     * @param proposal
     */
    public UIModifyProduktFunktionEvent(DataId id, DataProduktFunktion proposal){
        this.id=id;
        this.proposal=proposal;
    }

    /**
     * getter für id
     * @return id
     */
    public DataId getId() {
        return id;
    }

    /**
     * getter für proposal
     * @return proposal
     */
    public DataProduktFunktion getProposal() {
        return proposal;
    }

}
