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
    private int _numberOfDeaths;
    private double _inCluster;

    public void set_numberOfDeaths(int _numberOfDeaths) {
        this._numberOfDeaths = _numberOfDeaths;
    }

    public List<SocialCoorelation> get_socialCoorelations() {
        return _socialCoorelations;
    }

    public void set_socialCoorelations(List<SocialCoorelation> _socialCoorelations) {
        this._socialCoorelations = _socialCoorelations;
    }

    private List<SocialCoorelation> _socialCoorelations;


//    -37.691384, 145.057249
//            -37.692916, 145.059151
//            -37.691391, 145.057223
//            -37.692262, 145.050515

    public double get_inCluster() {
        return _inCluster;
    }

    public void set_inCluster(double _inCluster) {
        this._inCluster = _inCluster;
    }

    public int get_numberOfCases() {
        return _numberOfCases;
    }

    public void set_numberOfCases(int _numberOfCases) {
        this._numberOfCases = _numberOfCases;
    }


    public int getNumberOfDeaths() {
        return _numberOfDeaths;
    }


    public void setNumberOfDeaths(int numberOfDeaths) {
        this._numberOfDeaths = numberOfDeaths;
    }

    public String getName() {
        return _name;
    }
    public void setName(String name) {
        this._name = name;
    }

    public AreaInfo(String _name, String _postCode, List<String> _neighbours, int _numberOfCases, int _numberOfDeaths) {
        this._name = _name;
        this._postCode = _postCode;
        this._neighbours = _neighbours;
        this._numberOfCases = _numberOfCases;
        this._numberOfDeaths = _numberOfDeaths;
        _socialCoorelations = new ArrayList<>();
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
    public static ArrayList<AreaInfo> GenerateAreaList() {
        ArrayList<AreaInfo> areaList = new ArrayList<>();
        int index = 0;
        List<SocialCoorelation> socialCoorelations = new ArrayList<>(Arrays.asList(new SocialCoorelation(1,0.65), new SocialCoorelation(2,0.80), new SocialCoorelation(3,0.65)));
        areaList.add(new AreaInfo("area1","4563",new ArrayList<String>(Arrays.asList("4511", "4512", "4555")),1500,50));
        areaList.get(index).set_socialCoorelations(socialCoorelations);
        index++;

        socialCoorelations = new ArrayList<>(Arrays.asList(new SocialCoorelation(0,0.55), new SocialCoorelation(2,0.80), new SocialCoorelation(3,0.65)));
        areaList.add(new AreaInfo("area2","4555",new ArrayList<String>(Arrays.asList("4511", "4512", "4563")),2600,88));
        areaList.get(index).set_socialCoorelations(socialCoorelations);
        index++;

        socialCoorelations = new ArrayList<>(Arrays.asList(new SocialCoorelation(0,0.72), new SocialCoorelation(1,0.60), new SocialCoorelation(3,0.60)));
        areaList.add(new AreaInfo("area3","4512",new ArrayList<String>(Arrays.asList("4511", "4555", "4563")),4200,110));
        areaList.get(index).set_socialCoorelations(socialCoorelations);
        index++;

        socialCoorelations = new ArrayList<>(Arrays.asList(new SocialCoorelation(0,0.65), new SocialCoorelation(1,0.70), new SocialCoorelation(2,0.55)));
        areaList.add(new AreaInfo("area4","4511",new ArrayList<String>(Arrays.asList("4512", "4555", "4563")),3600,99));
        areaList.get(index).set_socialCoorelations(socialCoorelations);

        return areaList;
    }
}
