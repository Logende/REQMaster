package org.dhbw.stuttgart.ita16.reqmaster.model;


public interface IModel
{
    IDataAnforderungssammlung getIDataAnforderungssammlung();


    IDataSchaetzKonfiguration getSchaetzKonfiguration();
    void setSchaetzKonfiguration(IDataSchaetzKonfiguration schaetzKonfiguration);

    /**
     * Is executed by the controller after it modified model data.
     */
   public void wasModified();

}
