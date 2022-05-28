package com.example.icovidclusterpredictor.data;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.icovidclusterpredictor.R;
import com.example.icovidclusterpredictor.data.model.LoggedInUser;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CovidAreaDataAdapter extends RecyclerView.Adapter<CovidAreaDataAdapter.ViewHolder> {

    private List<AreaInfo> areas;
    private Context context;

    public CovidAreaDataAdapter(ArrayList<AreaInfo> areas, Context context) {
        this.areas = areas;
        this.context = context;
    }
    @NonNull
    @Override
    public CovidAreaDataAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View contactView = LayoutInflater.from(context).inflate(R.layout.recycle_row, parent, false);
        // Return a new holder instance
        return new ViewHolder(contactView);
    }

    @Override
    public void onBindViewHolder(@NonNull CovidAreaDataAdapter.ViewHolder holder, int position) {

        // Get the data model based on position
        final AreaInfo area = areas.get(position);
        TextView _nameTextView, _postCodeTextView, _numCasesTextView, _numDeathsTextView, _clusterStatusTextView;
        _nameTextView = holder._nameTextView;
        _postCodeTextView = holder._postCodeTextView;
        _numCasesTextView = holder._numCasesTextView;
        _numDeathsTextView = holder._numDeathsTextView;
        _clusterStatusTextView = holder._clusterStatusTextView;

        _nameTextView.setText(area.get_name());
        _postCodeTextView.setText(area.get_postCode());
        _numCasesTextView.setText(String.valueOf(area.get_numberOfCases()));
        _numDeathsTextView.setText(String.valueOf(area.getNumberOfDeaths()));
        _clusterStatusTextView.setText(String.format("%.2f", area.get_inCluster()));
        Button _showClusterInfo = holder._showClusterInfo;

        //TextView cholesterolTextView = holder.aw;

        // Set item views based on your views and data model

        final LoggedInUser user= LoginDataSource.getLoggedInUser();
        _showClusterInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String TAG = "Covid Prediction";
                Map<String, Object> areaSelected = new HashMap<>();
                areaSelected.put("user", user.getUserEmail());
                areaSelected.put("name", area.get_name());
                areaSelected.put("code", area.get_postCode());
                areaSelected.put("num_cases", area.get_numberOfCases());
                areaSelected.put("num_deaths", area.getNumberOfDeaths());
                areaSelected.put("in_cluster", area.get_inCluster());

                FirebaseFirestore db = FirebaseFirestore.getInstance();
                // add to collection
                db.collection("areas")
                        .add(areaSelected)
                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {
                                Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.w(TAG, "Error adding document", e);
                            }
                        });
            }
        });
        //costTextView.setText(String.format("%.2f", recipe.getCost()));

    }

    @Override
    public int getItemCount() {
        return areas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        public TextView _nameTextView, _postCodeTextView, _numCasesTextView, _numDeathsTextView, _clusterStatusTextView;
        public Button _showClusterInfo;

        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            _nameTextView = itemView.findViewById(R.id.area_info_name);
            _postCodeTextView = itemView.findViewById(R.id.area_info_code);
            _numCasesTextView = itemView.findViewById(R.id.area_info_number_cases);
            _numDeathsTextView = itemView.findViewById(R.id.area_info_number_deaths);
            _clusterStatusTextView = itemView.findViewById(R.id.area_info_in_cluster);
            _showClusterInfo = itemView.findViewById(R.id.show_cluster_info);
        }
    }
}
