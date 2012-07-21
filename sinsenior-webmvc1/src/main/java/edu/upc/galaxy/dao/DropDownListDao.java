package edu.upc.galaxy.dao;


import java.util.List;

import edu.upc.galaxy.entity.DropDownList;


public interface DropDownListDao {
    public List<DropDownList> buscarTipoInmueble();
    public List<DropDownList> buscarDistrito();
    public List<DropDownList> buscarTipoPersona();
    public List<DropDownList> buscarEstado();

}
