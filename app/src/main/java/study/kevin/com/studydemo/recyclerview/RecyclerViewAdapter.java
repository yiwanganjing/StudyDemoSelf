package study.kevin.com.studydemo.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import study.kevin.com.studydemo.R;

/**
 * Created by kevin on 2018/4/14.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private ArrayList<String> mDataList;
    private Context mContext;

    public RecyclerViewAdapter(Context context, ArrayList<String> datalist) {
        this.mContext = context;
        this.mDataList = datalist;
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public int getItemCount() {
        return mDataList == null || mDataList.size() == 0 ? 0 : mDataList.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.adapter_recyclerview,null);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.itemName.setText(mDataList.get(position));

    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView itemName;

        public ViewHolder(View v) {
            super(v);
            itemName = (TextView) v.findViewById(R.id.tv_recyclerview_adpter_item);
        }
    }
}
