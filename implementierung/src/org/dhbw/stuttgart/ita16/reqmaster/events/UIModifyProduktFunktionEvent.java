package org.dhbw.stuttgart.ita16.reqmaster.events;
/**
 * legt den typ eines Events des User Interface fest
 * und speichert dessen relavente Werte
 */
public class UIModifyProduktFunktionEvent extends UIModifyEvent {

	private IIdentifiable id;
	private DataProduktFunktion proposal;

   /**
     * Konstruktor für die Klasse schreibt Eingansvariablen auf Klassenvariablen um
     * @param id
     * @param proposal
     */
    public UIModifyProduktFunktionEvent(IIdentifiable id, DataProduktDatum proposal)
            {
            this.id=id;
            this.proposal=proposal;
            }

    /**
     * getter für id
     * @return id
     */
    public IIdentifiable getId() {
            return id;
            }

    /**
     * getter für proposal
     * @return proposal
     */
    public DataProduktDatum getProposal() {
            return proposal;
            }

}
