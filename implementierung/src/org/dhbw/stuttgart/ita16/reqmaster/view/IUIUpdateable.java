package org.dhbw.stuttgart.ita16.reqmaster.view;

import java.io.*;
import java.util.*;
import org.dhbw.stuttgart.ita16.reqmaster.model.IModel;

/**
 * Das Interface legt die Fähigkeit der View und aller Komponenten darunter fest,
 * sich auf Grundlage eines Model zu aktualisieren
 *
 */
public interface IUIUpdateable {

	void update(IModel model);

}
