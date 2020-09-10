package com.moshood.gadsleaderboard.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.moshood.gadsleaderboard.R;
import com.moshood.gadsleaderboard.models.TopLearner;

import java.util.List;

public class TopLearnerAdapter extends RecyclerView.Adapter<TopLearnerAdapter.TopLearnerViewHolder> {

    private List<TopLearner> mTopLearnerList;
    private Context mContext;

    public TopLearnerAdapter(Context context, List<TopLearner> topLearnerList) {
        mContext = context;
        mTopLearnerList = topLearnerList;
    }

    @NonNull
    @Override
    public TopLearnerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.learning_leaders_item, parent, false);


        return new TopLearnerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TopLearnerViewHolder holder, int position) {
        TopLearner topLearner = mTopLearnerList.get(position);
        holder.tvName.setText(topLearner.getName());
        String hours = topLearner.getHours().toString() + " learning hours,";
        holder.tvHours.setText(hours);
        holder.tvCountry.setText(topLearner.getCountry());


    }

    @Override
    public int getItemCount() {
        return mTopLearnerList.size();
    }


    public class TopLearnerViewHolder extends RecyclerView.ViewHolder {

        private TextView tvName;
        private TextView tvHours;
        private TextView tvCountry;

        public TopLearnerViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tv_name);
            tvHours = itemView.findViewById(R.id.tv_details);
            tvCountry = itemView.findViewById(R.id.tv_details);
        }
    }
}
