package org.dhbw.stuttgart.ita16.reqmaster.model;


public interface IModel
{
    IDataAnforderungssammlung getIDataAnforderungssammlung();

    /**
     * Is executed by the controller after it modified model data.
     */
    void wasModified();

}
