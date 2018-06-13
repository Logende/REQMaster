package org.dhbw.stuttgart.ita16.reqmaster.view;

import java.io.*;
import java.util.*;
import org.dhbw.stuttgart.ita16.reqmaster.model.IModel;

/**
 * interface legt die Fähigkeit der View sich auf Grundlage eines Model neu aufzubauen
 *
 */
public interface UIUpdateable {

	void update(IModel model);

}
