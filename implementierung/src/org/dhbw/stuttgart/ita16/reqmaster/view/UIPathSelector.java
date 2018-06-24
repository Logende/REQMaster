package org.dhbw.stuttgart.ita16.reqmaster.view;

import org.dhbw.stuttgart.ita16.reqmaster.components.UIFileChooser;
import org.dhbw.stuttgart.ita16.reqmaster.components.UIFrame;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileFilter;

public class UIPathSelector {


    public static File selected;

    public static File forcePathSelection(final String title, final String description, boolean select, String default_directory, boolean type_save){
        return forcePathSelection(title, description, select,".xml", default_directory, type_save);
    }

    public static File forcePathSelection(final String title, final String description, boolean select, final String ending, String default_directory, boolean type_save){
        UIFrame frame = new UIFrame(title);

        UIFileChooser filechooser = new UIFileChooser();
        String username = System.getProperty("user.name");
        filechooser.setCurrentDirectory(new File(default_directory.replace("%name%", username)));
        filechooser.setFileFilter(new FileFilter() {

            @Override
            public String getDescription() {
                return description;
            }

            @Override
            public boolean accept(File f) {
                if(f.getName().toLowerCase().endsWith(ending)||f.isDirectory()){
                    return true;
                }
                return false;
            }
        });
        filechooser.setFileHidingEnabled(true);
        filechooser.setDialogTitle(title);
        int goal = -1;
        if(type_save){
            goal = filechooser.showSaveDialog(frame);
        }else{
            goal = filechooser.showOpenDialog(frame);
        }
        if (goal  == 0) {
            frame.dispose();
            if(select){
                selected = filechooser.getSelectedFile();
                return selected;
            }else{
                return filechooser.getSelectedFile();
            }
        }
        return null;
    }

}