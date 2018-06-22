package org.dhbw.stuttgart.ita16.reqmaster.model;


import java.io.File;

public interface IModel
{
    IDataAnforderungssammlung getIDataAnforderungssammlung();


    IDataSchaetzKonfiguration getSchaetzKonfiguration();
    void setSchaetzKonfiguration(IDataSchaetzKonfiguration schaetzKonfiguration);



    public void createAnforderungssammlung(File f);

    public void loadAnforderungssammlung(File f);

    public void saveAnforderungssammlung() ;

    public void saveSchaetzkonfiguration();


   public void wasModified();

}
