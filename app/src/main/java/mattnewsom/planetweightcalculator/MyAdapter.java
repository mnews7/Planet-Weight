package mattnewsom.planetweightcalculator;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Matthew on 11/9/2015.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private ArrayList<Double> mDataset;


    public MyAdapter(ArrayList<Double> myDataset) {
        mDataset = myDataset;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleitem, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final String name = mDataset.get(position).toString();
        holder.txtHeader.setText(name);
        holder.txtFooter.setText("Footer: " + mDataset.get(position));
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public void add(int position, Double item) {
        mDataset.add(position, item);
        notifyItemInserted(position);
    }

    public void remove(String item) {
        int position = mDataset.indexOf(item);
        mDataset.remove(position);
        notifyItemRemoved(position);

    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView txtHeader;
        public TextView txtFooter;

        public ViewHolder(View itemView) {
            super(itemView);
            txtHeader = (TextView) itemView.findViewById(R.id.firstLine);
            txtFooter = (TextView) itemView.findViewById(R.id.secondLine);
        }
    }


}

