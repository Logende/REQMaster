package org.dhbw.stuttgart.ita16.reqmaster.view;

import org.dhbw.stuttgart.ita16.reqmaster.components.UIFileChooser;
import org.dhbw.stuttgart.ita16.reqmaster.components.UIFrame;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileFilter;

/**
 * Grafikkomponente: Auswahlfenster um eine zu importierende Datei auszuwählen,
 * oder den Pfad für eine neu anzulegende Datei auszuwählen
 */
public class UIPathSelector {

    public static File selected;

    /**
     * statische Methode des FileChooser zur Auswahl einer Datei
     * @param title Titel des Fensters
     * @param description Filterung der Dateien nach diesem String
     * @param select boolean true/false
     * @param ending Dateiendung
     * @param default_directory Verzeichnis, in dem standardmäßig gespeichert wird
     * @param type_save boolean: true: Speicherdialog, false: Öffnendialog
     * @return File das geöffnet oder gespeichert werden soll
     */
    public static File forcePathSelection(final String title, final String description, boolean select, final String ending, String default_directory, boolean type_save){
        UIFrame frame = new UIFrame(title);

        UIFileChooser filechooser = new UIFileChooser();
        String username = System.getProperty("user.name");
        filechooser.setCurrentDirectory(new File(default_directory.replace("%name%", username)));
        filechooser.setFileFilter(new FileFilter() {

            /**
             * Überschreiben der Methode des Filefilters
             * @return String nach dem die Files zu filtern sind
             */
            @Override
            public String getDescription() {
                return description;
            }

            /**
             * Überschreiben der Methode des FileFilters
             * entscheidet, ob das File von diesem Filter akzeptiert wird
             * @param f
             * @return true: wenn akzeptiert, false sonst
             */
            @Override
            public boolean accept(File f) {
                if(f.getName().toLowerCase().endsWith(ending)){
                    System.out.println(f.getName());
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