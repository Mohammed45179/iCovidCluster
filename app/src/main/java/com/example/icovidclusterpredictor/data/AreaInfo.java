package com.example.icovidclusterpredictor.data;

import com.example.icovidclusterpredictor.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AreaInfo {
    private String _name;
    private String _postCode;
    private List<String> _neighbours;
    private int _numberOfCases;
    private int numberOfDeaths;
    private float _inCluster;

    public float get_inCluster() {
        return _inCluster;
    }

    public void set_inCluster(float _inCluster) {
        this._inCluster = _inCluster;
    }

    public int get_numberOfCases() {
        return _numberOfCases;
    }

    public void set_numberOfCases(int _numberOfCases) {
        this._numberOfCases = _numberOfCases;
    }

    public int getNumberOfDeaths() {
        return numberOfDeaths;
    }

    public void setNumberOfDeaths(int numberOfDeaths) {
        this.numberOfDeaths = numberOfDeaths;
    }

    public String getName() {
        return _name;
    }
    public void setName(String name) {
        this._name = name;
    }

    public AreaInfo(String _name, String _postCode, List<String> _neighbours) {
        this._name = _name;
        this._postCode = _postCode;
        this._neighbours = _neighbours;
    }

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public String get_postCode() {
        return _postCode;
    }

    public void set_postCode(String _postCode) {
        this._postCode = _postCode;
    }

    public List<String> get_neighbours() {
        return _neighbours;
    }

    public void set_neighbours(List<String> neighbours) {
        this._neighbours = neighbours;
    }


    // set list values
    public static ArrayList<AreaInfo> GenerateRecipeList() {
        ArrayList<AreaInfo> areaList = new ArrayList<>();
        areaList.add(new AreaInfo("area1","4563",new ArrayList<String>(Arrays.asList("4511", "4512", "4555"))));
        areaList.add(new AreaInfo("area2","4555",new ArrayList<String>(Arrays.asList("4511", "4512", "4563"))));
        areaList.add(new AreaInfo("area3","4512",new ArrayList<String>(Arrays.asList("4511", "4555", "4563"))));
        areaList.add(new AreaInfo("area4","4511",new ArrayList<String>(Arrays.asList("4512", "4555", "4563"))));
        return areaList;
    }
}
