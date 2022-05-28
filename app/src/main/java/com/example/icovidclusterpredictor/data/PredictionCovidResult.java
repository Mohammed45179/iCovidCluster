package com.example.icovidclusterpredictor.data;

import java.util.List;
import java.util.Random;

public class PredictionCovidResult {

    public static void predict_covid_cluster(List<AreaInfo> areaInfoList) {
        int total_num_cases = 0, total_num_deaths = 0;
        for (AreaInfo area : areaInfoList) {
            total_num_cases = total_num_cases + area.get_numberOfCases();
            total_num_deaths = total_num_cases + area.get_numberOfCases();
        }
        for (AreaInfo area : areaInfoList) {
            total_num_cases = total_num_cases + area.get_numberOfCases();
            total_num_deaths = total_num_cases + area.get_numberOfCases();
            double c_ration = 0;
            double d_ration = 0;
            for (SocialCoorelation socialCoorelation : area.get_socialCoorelations()) {
                AreaInfo areaInfo = areaInfoList.get(socialCoorelation.get_areaIndex());
                c_ration += ((double) areaInfo.get_numberOfCases() / area.get_numberOfCases()) * socialCoorelation.get_socialFactor();
                d_ration += ((double) areaInfo.getNumberOfDeaths() / area.getNumberOfDeaths()) * socialCoorelation.get_socialFactor();
            }
            area.set_inCluster(c_ration * 0.40 + d_ration * 0.6);
        }
    }
}