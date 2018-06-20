package org.dhbw.stuttgart.ita16.reqmaster.view;

import java.io.*;
import java.util.*;
import org.dhbw.stuttgart.ita16.reqmaster.model.IModel;

/**
 * Interface legt die Fähigkeit der View und aller Komponenten darunter fest,
 * sich auf Grundlage eines Model neu aufzubauen
 *
 */
public interface UIUpdateable {

	void update(IModel model);

}
