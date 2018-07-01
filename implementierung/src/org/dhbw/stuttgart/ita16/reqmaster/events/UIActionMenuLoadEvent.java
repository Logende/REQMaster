package org.dhbw.stuttgart.ita16.reqmaster.events;

import java.io.File;

public class UIActionMenuLoadEvent extends UIActionMenuEvent {


    private final File fileAnforderungssammlung;

    public UIActionMenuLoadEvent(File fileAnforderungssammlung){
        this.fileAnforderungssammlung = fileAnforderungssammlung;
    }

    public File getFileAnforderungssammlung() {
        return fileAnforderungssammlung;
    }
}
