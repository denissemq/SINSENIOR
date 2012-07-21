package edu.upc.galaxy.service;

import java.util.List;

import edu.upc.galaxy.entity.DropDownList;

public interface DropDownListService {
    public List<DropDownList> buscarTipoInmueble();
    public List<DropDownList> buscarDistrito();
    public List<DropDownList> buscarTipoPersona();
    public List<DropDownList> buscarEstado();
}