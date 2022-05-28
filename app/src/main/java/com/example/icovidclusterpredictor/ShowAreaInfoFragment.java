package com.example.icovidclusterpredictor;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.icovidclusterpredictor.data.AreaInfo;
import com.example.icovidclusterpredictor.data.CovidAreaDataAdapter;
import com.example.icovidclusterpredictor.data.PredictionCovidResult;

import java.util.ArrayList;

public class ShowAreaInfoFragment extends Fragment {

    private ArrayList<AreaInfo> areas;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_show_areas_list, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = view.findViewById(R.id.areaRecyclerView);
        areas = AreaInfo.GenerateAreaList();
        PredictionCovidResult.predict_covid_cluster(areas);

        CovidAreaDataAdapter areaDataAdapter = new CovidAreaDataAdapter(areas, getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(areaDataAdapter);

        view.findViewById(R.id.button_first).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(ShowAreaInfoFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });
    }
}