package com.example.icovidclusterpredictor.data;

import java.util.List;

public class Area {
    private String _name;
    private int _postCode;
    private List<Area> _neighbours;
    public String getName() {
        return _name;
    }
    public void setName(String name) {
        this._name = name;
    }

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public int get_postCode() {
        return _postCode;
    }

    public void set_postCode(int _postCode) {
        this._postCode = _postCode;
    }

    public List<Area> get_neighbours() {
        return _neighbours;
    }

    public void set_neighbours(List<Area> neighbours) {
        this._neighbours = neighbours;
    }
}
