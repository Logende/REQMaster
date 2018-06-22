package org.dhbw.stuttgart.ita16.reqmaster.model;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.*;

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
		/*XMLEncoder encoder=null;
		try{
			encoder=new XMLEncoder(new BufferedOutputStream(new FileOutputStream(f)));
		}catch(FileNotFoundException fileNotFound){
			System.out.println("Exception when trying to save object. File not found: " + f.getPath()+".");
		}
		encoder.writeObject(o);
		encoder.close();*/
		try {
			xStream.toXML(o, new FileOutputStream(f));
			System.out.println("Saved Object of type " + o.getClass().getName() + " to file " + f.getPath());
		}catch (FileNotFoundException e){
			e.printStackTrace();
		}
	}
	public Object loadFromXML(File f){
		/*XMLDecoder decoder= null;
		try {
			decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(f)));
		} catch (FileNotFoundException e) {
			System.out.println("Exception when trying to load object. File not found: " + f.getName()+".");
		}
		return decoder.readObject();*/
		XStream xStream = new XStream(new DomDriver());
		return xStream.fromXML(f);
	}

	public IDataAnforderungssammlung loadAnforderungssammlung(File f) {
		return (IDataAnforderungssammlung) loadFromXML(f);
	};

	public void saveAnforderungssammlung(IDataAnforderungssammlung anforderungsSammlung, File f) {
		saveToXML(f, anforderungsSammlung);
	}

	public IDataFunctionPointAnalyse loadFunctionPointAnalyse(File f) {
		return (IDataFunctionPointAnalyse) loadFromXML(f);
	}

	public void saveFunctionPointAnalyse(IDataFunctionPointAnalyse analyse, File f) {
		saveToXML(f, analyse);
	};

	@Override
	public IDataSchaetzKonfiguration loadSchaetzkonfiguration(File f) {
		return (IDataSchaetzKonfiguration) loadFromXML(f);
	}

	@Override
	public void saveSchaetzKonfiguration(IDataSchaetzKonfiguration schaetzKonfiguration, File f) {
		saveToXML(f, schaetzKonfiguration);
	}
}
