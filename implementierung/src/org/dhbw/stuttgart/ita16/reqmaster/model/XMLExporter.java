package org.dhbw.stuttgart.ita16.reqmaster.model;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.*;

/**
 * Exporter Implementierung, welche eine Bibliothek verwendet,
 * um die zu exportierenden Java-Objekte aus dem Arbeitspeicher in XML-Dateien zu schreiben
 * bzw. um Java-Objekte aus XML-Dateien zu importieren.
 */
public class XMLExporter implements IExporter {


	public void saveToXML(File f, Object o){
		XStream xStream = new XStream(new DomDriver());
        if (!f.getParentFile().exists() && !f.getParentFile().mkdirs()) {
            throw new IllegalStateException("Couldn't create dir: " + f.getParentFile().getPath());
        }
	    if(!f.exists()){
	        try {
                f.createNewFile();
            }catch(IOException e){
	            e.printStackTrace();
            }
        }
		try {
			xStream.toXML(o, new FileOutputStream(f));
			System.out.println("Saved Object of type " + o.getClass().getName() + " to file " + f.getPath());
		}catch (FileNotFoundException e){
			e.printStackTrace();
		}
	}
	public Object loadFromXML(File f){
		XStream xStream = new XStream(new DomDriver());
		return xStream.fromXML(f);
	}

	public IDataAnforderungssammlung loadAnforderungssammlung(File f) {
		return (IDataAnforderungssammlung) loadFromXML(f);
	}

	public void saveAnforderungssammlung(IDataAnforderungssammlung anforderungsSammlung, File f) {
		saveToXML(f, anforderungsSammlung);
	}


	@Override
	public IDataSchaetzKonfiguration loadSchaetzkonfiguration(File f) {
		return (IDataSchaetzKonfiguration) loadFromXML(f);
	}

	@Override
	public void saveSchaetzKonfiguration(IDataSchaetzKonfiguration schaetzKonfiguration, File f) {
		saveToXML(f, schaetzKonfiguration);
	}
}
