package org.dhbw.stuttgart.ita16.reqmaster.controller;

import org.dhbw.stuttgart.ita16.reqmaster.model.*;

public class Validator implements  IValidator{


    @Override
    public String isValid(IModel model, DataProduktDatum current, DataProduktDatum proposal) {
        if(!isValidId(model, current, proposal.getId())){
            return "Invalide Id.";
        }
        return null;
    }

    @Override
    public String isValid(IModel model, DataZielbestimmung proposal) {
        return null;
    }

    @Override
    public String isValid(IModel model, DataProdukteinsatz proposal) {
        return null;
    }
    @Override
    public String isValid(IModel model, DataUmgebung proposal) {
        return null;
    }

    @Override
    public String isValid(IModel model, DataProduktFunktion current, DataProduktFunktion proposal) {
        if(!isValidId(model, current, proposal.getId())){
            return "Invalide Id.";
        }
        return null;
    }

    @Override
    public String isValid(IModel model, IDataFunctionPointEinstufung current, IDataFunctionPointEinstufung proposal, IIdentifiable iIdentifiable) {
         switch (proposal.getFunktionstyp()) {
            case DATEN:
                switch (proposal.getKlassifizierung()) {
                    case DATEN_ELF:
                    case DATEN_ILF:
                        break;
                    case TRANSAKTION_EI:
                    case TRANSAKTION_EO:
                    case TRANSAKTION_EQ:
                        return "Invalide Klassifizierung für Funktionstyp DATEN.";
                }
                break;

            case TRANSAKTION:
                switch (proposal.getKlassifizierung()) {
                    case DATEN_ELF:
                    case DATEN_ILF:
                        return "Invalide Klassifizierung für Funktionstyp TRANSAKTION.";
                    case TRANSAKTION_EI:
                    case TRANSAKTION_EO:
                    case TRANSAKTION_EQ:
                        break;
                }
                break;
        }
        return null;
    }

    @Override
    public String isValid(IModel model, double realerAufwand) {
        if(realerAufwand <= 0){
            return "Invalider realer Aufwand: Muss positiv sein.";
        }
        return null;
    }

    @Override
    public String isValid(IModel model, IDataSchaetzKonfiguration schaetzKonfiguration) {
        return null;
    }


    public boolean isValidId(IModel model, IIdentifiable current, DataId idProposal){
        if(idProposal.getId().length() == 0){
            return false;
        }
        IIdentifiable existingWithSameId = model.getIDataAnforderungssammlung().getObject(idProposal);
        if(existingWithSameId != null && existingWithSameId != current){
            return false;
        }
        return true;
    }
}
