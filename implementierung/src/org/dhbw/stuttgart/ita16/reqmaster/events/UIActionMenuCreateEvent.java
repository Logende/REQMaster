package org.dhbw.stuttgart.ita16.reqmaster.events;

import java.io.File;

public class UIActionMenuCreateEvent extends UIActionMenuEvent {


    private File fileAnforderungssammlung;

    public UIActionMenuCreateEvent(File fileAnforderungssammlung){
        this.fileAnforderungssammlung = fileAnforderungssammlung;
    }

    public File getFileAnforderungssammlung() {
        return fileAnforderungssammlung;
    }
}
