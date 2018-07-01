package org.dhbw.stuttgart.ita16.reqmaster.controller;

import org.dhbw.stuttgart.ita16.reqmaster.model.*;

public class Validator implements  IValidator{


    @Override
    public boolean isValid(IModel model, DataProduktDatum current, DataProduktDatum proposal) {
        if(!isValidId(model, current, proposal.getId())){
            return false;
        }
        return true;
    }

    @Override
    public boolean isValid(IModel model, DataZielbestimmung proposal) {
        return true;
    }

    @Override
    public boolean isValid(IModel model, DataProdukteinsatz proposal) {
        return true;
    }
    @Override
    public boolean isValid(IModel model, DataUmgebung proposal) {
        return true;
    }

    @Override
    public boolean isValid(IModel model, DataProduktFunktion current, DataProduktFunktion proposal) {
        if(!isValidId(model, current, proposal.getId())){
            return false;
        }
        return true;
    }

    @Override
    public boolean isValid(IModel model, IDataFunctionPointEinstufung current, IDataFunctionPointEinstufung proposal, IIdentifiable iIdentifiable) {
         switch (proposal.getFunktionstyp()) {
            case DATEN:
                switch (proposal.getKlassifizierung()) {
                    case DATEN_ELF:
                    case DATEN_ILF:
                        break;
                    case TRANSAKTION_EI:
                    case TRANSAKTION_EO:
                    case TRANSAKTION_EQ:
                        return false;
                }
                break;

            case TRANSAKTION:
                switch (proposal.getKlassifizierung()) {
                    case DATEN_ELF:
                    case DATEN_ILF:
                        return false;
                    case TRANSAKTION_EI:
                    case TRANSAKTION_EO:
                    case TRANSAKTION_EQ:
                        break;
                }
                break;
        }
        return true;
    }

    @Override
    public boolean isValid(IModel model, double realerAufwand) {
        return realerAufwand > 0;
    }

    @Override
    public boolean isValid(IModel model, IDataSchaetzKonfiguration schaetzKonfiguration) {
        return true;
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
