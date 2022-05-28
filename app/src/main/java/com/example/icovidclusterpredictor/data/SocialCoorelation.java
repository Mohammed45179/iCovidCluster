package com.example.icovidclusterpredictor.data;

public class SocialCoorelation {
    int _areaIndex;

    public int get_areaIndex() {
        return _areaIndex;
    }

    public void set_areaIndex(int _areaIndex) {
        this._areaIndex = _areaIndex;
    }

    public double get_socialFactor() {
        return _socialFactor;
    }

    public void set_socialFactor(double _socialFactor) {
        this._socialFactor = _socialFactor;
    }

    double _socialFactor;

    public SocialCoorelation(int _areaIndex, double _socialFactor) {
        this._areaIndex = _areaIndex;
        this._socialFactor = _socialFactor;
    }
}
