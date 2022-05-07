package com.example.icovidclusterpredictor.data;

import java.util.List;

public class CovidStat {

    private Area _area;
    private int _numCases;

    public Area get_area() {
        return _area;
    }

    public void set_area(Area _area) {
        this._area = _area;
    }

    public int get_numCases() {
        return _numCases;
    }

    public void set_numCases(int _numCases) {
        this._numCases = _numCases;
    }

    public CovidStat(Area _area, int _numCases, int _numDeaths, List<CovidConstraint> _CovidConstraints) {
        this._area = _area;
        this._numCases = _numCases;
        this._numDeaths = _numDeaths;
        this._CovidConstraints = _CovidConstraints;
    }

    public int get_numDeaths() {
        return _numDeaths;
    }

    public void set_numDeaths(int _numDeaths) {
        this._numDeaths = _numDeaths;
    }

    public List<CovidConstraint> get_CovidConstraints() {
        return _CovidConstraints;
    }

    public void set_CovidConstraints(List<CovidConstraint> _CovidConstraints) {
        this._CovidConstraints = _CovidConstraints;
    }

    private int _numDeaths;
    private List<CovidConstraint> _CovidConstraints;
}
