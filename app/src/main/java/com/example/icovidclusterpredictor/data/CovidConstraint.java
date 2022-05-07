package com.example.icovidclusterpredictor.data;

import java.util.List;

public class CovidConstraint {

    private String _name;
    private String _value;

    public CovidConstraint(String _name, String _value) {
        this._name = _name;
        this._value = _value;
    }

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public String get_value() {
        return _value;
    }

    public void set_value(String _value) {
        this._value = _value;
    }
}
