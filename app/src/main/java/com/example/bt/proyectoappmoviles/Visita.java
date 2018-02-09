package com.example.bt.proyectoappmoviles;

/**
 * Created by bt on 09/02/2018.
 */
public class Visita {

    int _id;
    String _nombre;
    String _fecha_visita;
    String _numero_visitantes;
    String _hora_ingreso;
    String _telefono;

    public Visita(){}

    public Visita(int _id, String _nombre, String _fecha_visita, String _numero_visitantes, String _hora_ingreso,String _telefono ){
        this._id=_id;
        this._nombre=_nombre;
        this._fecha_visita=_fecha_visita;
        this._numero_visitantes=_numero_visitantes;
        this._hora_ingreso=_hora_ingreso;
        this._telefono = _telefono;
    }

    public Visita(String _nombre, String _fecha_visita, String _numero_visitantes, String _hora_ingreso,String _telefono ){
        this._nombre=_nombre;
        this._fecha_visita=_fecha_visita;
        this._numero_visitantes=_numero_visitantes;
        this._hora_ingreso=_hora_ingreso;
        this._telefono = _telefono;
    }

    public int get_id() {
        return _id;
    }
    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_nombre() {
        return _nombre;
    }
    public void set_nombre(String _nombre) {
        this._nombre = _nombre;
    }

    public String get_fecha_visita() {
        return _fecha_visita;
    }

    public void set_fecha_visita(String _fecha_visita) {
        this._fecha_visita = _fecha_visita;
    }

    public String get_numero_visitantes() {
        return _numero_visitantes;
    }

    public void set_numero_visitantes(String _numero_visitantes) {
        this._numero_visitantes = _numero_visitantes;
    }

    public String get_hora_ingreso() {
        return _hora_ingreso;
    }

    public void set_hora_ingreso(String _hora_ingreso) {
        this._hora_ingreso = _hora_ingreso;
    }

    public String get_telefono() {
        return _telefono;
    }

    public void set_telefono(String _telefono) {
        this._telefono = _telefono;
    }

}
