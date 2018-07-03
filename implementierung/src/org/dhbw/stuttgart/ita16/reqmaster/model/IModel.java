package org.dhbw.stuttgart.ita16.reqmaster.model;


import java.io.File;

/**
 * Interface für das Model im Rahmen des MVC pattern.
 */
public interface IModel{

    IDataAnforderungssammlung getIDataAnforderungssammlung();

    IDataSchaetzKonfiguration getSchaetzKonfiguration();
    void setSchaetzKonfiguration(IDataSchaetzKonfiguration schaetzKonfiguration);



    void createAnforderungssammlung(File f);
    void loadAnforderungssammlung(File f);
    void saveAnforderungssammlung() ;
    void saveSchaetzkonfiguration();


   void wasModified();

}
