package org.dhbw.stuttgart.ita16.reqmaster.events;

/**
 * Interface für Events die fehlschlagen können.
 * Falls ein Event fehlschlägt, wird die entsprechende Fehlermeldung dem Anwender angezeigt
 * und z.B. im Falle eines Modify Events fordert die bearbeitete Komponente erneut den Fokus an, da ihre aktuellen Eingabewerte invalide sind.
 */
public interface IEventFailable {

    /**
     * Erfolgsstatus des events
     * @return true bei Erfolg, false bei Misserfolg. False erfordert, dass #getErrorMessage!=null.
     */
    boolean isSuccess();

    /**
     * Fehlermeldung die gezeigt wird, falls #isSuccess==false
     * @return null bei Erfolg und Fehlermeldung sonst.
     */
    String getErrorMessage();
}
