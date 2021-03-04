package com.example.coursework;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class CPUCoreAdapter extends RecyclerView.Adapter<CPUCoreAdapter.ViewHolder> {

    private final Context context;
    private final ArrayList<CPUCoreModel> CPUCoreModelArrayList;

    public CPUCoreAdapter(Context context, ArrayList<CPUCoreModel> CPUCoreModelArrayList) {
        this.context = context;
        this.CPUCoreModelArrayList = CPUCoreModelArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CPUCoreModel model = CPUCoreModelArrayList.get(position);

        holder.coreNumber.setText("Core " + model.getCore());
        holder.cpuFreqCur.setText(model.getCpuFreqCur());
        holder.cpuFreqMax.setText(model.getCpuFreqMax());
        holder.cpuFreqMin.setText(model.getCpuFreqMin());
    }

    @Override
    public int getItemCount() {
        return CPUCoreModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView coreNumber;
        private final TextView cpuFreqCur;
        private final TextView cpuFreqMax;
        private final TextView cpuFreqMin;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            coreNumber = itemView.findViewById(R.id.textViewCoreNumber);
            cpuFreqCur = itemView.findViewById(R.id.textViewCPUFreqCur);
            cpuFreqMax = itemView.findViewById(R.id.textViewCPUFreqMax);
            cpuFreqMin = itemView.findViewById(R.id.textViewCPUFreqMin);
        }
    }
}
