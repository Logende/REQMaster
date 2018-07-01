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

    public static File selected; // Datei, die gespeichert oder geöffnet werden soll

    /**
     * statische Methode des FileChooser zur Auswahl einer Datei
     * @param title Titel des Fensters
     * @param description Filterung der Dateien nach diesem String
     * @param ending Dateiendung
     * @param default_directory Verzeichnis, in dem man sich aktuell befindet bei Fensteröffnung
     * @param type_save boolean: true: Speicherdialog, false: Öffnendialog
     * @return File, das geöffnet oder gespeichert werden soll
     */
    public static File forcePathSelection(final String title, final String description, final String ending, String default_directory, boolean type_save){
        //Instanzierung
        UIFrame frame = new UIFrame(title);
        UIFileChooser filechooser = new UIFileChooser();

        String username = System.getProperty("user.name"); // Hostname, der gerade eingeloggt ist
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
             * Die Implementierung der Methode entscheidet, ob ein File von diesem Filter akzeptiert wird
             * @param f das zu prüfende File
             * @return true: wenn akzeptiert, false sonst
             */
            @Override
            public boolean accept(File f) {
                if(f.getName().toLowerCase().endsWith(ending) || f.isDirectory()){
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
            // falls Datei vom Benutzer ohne xml Endung eingegeben wurde, Endung hinzufügen
            selected = filechooser.getSelectedFile();
            if(selected.getName().toLowerCase().endsWith(".xml")) {
                return selected;
            }
            else{
                return new File(selected.getAbsolutePath() + ".xml");
            }
        }
        return null;
    }
}

