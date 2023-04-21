package com.example.thuchanh2.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thuchanh2.R;
import com.example.thuchanh2.models.Item;

import java.util.ArrayList;
import java.util.List;


public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {
    List<Item> lstTask;
    private List<Item> listBackup;

    ItemListener taskItemListener;

    public List<Item> getBackup() {
        return listBackup;

    }
    public void filterList(List<Item> filterList) {
        lstTask = filterList;
        notifyDataSetChanged();
    }

    public void setLstTask(List<Item> lstTask) {
        this.lstTask = lstTask;
    }

    public TaskAdapter() {
        listBackup = new ArrayList<>();
        lstTask = new ArrayList<>();
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new TaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        Item task = lstTask.get(position);
        if (task != null) {
            holder.tvName.setText(task.getName());
            holder.tvEndDate.setText(task.getEndDate());
            holder.tvStartDate.setText(task.getStartDate());
            holder.ckbIsCompleted.setChecked(task.getIsCompleted());
//            holder.btnRemove.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    AlertDialog.Builder builder = new AlertDialog.Builder(parent.getContext());
//                    builder.setTitle("Thông báo xoá!");
//                    builder.setMessage("Bạn có chắc chắn muốn xoá  không?");
//                    builder.setIcon(R.drawable.ic_launcher_background);
//                    builder.setPositiveButton("NO", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialogInterface, int i) {
//
//                        }
//                    });
//                    builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialogInterface, int i) {
//                            lstTask.remove(position);
//                            listBackup.remove(position);
//                            notifyDataSetChanged();
//                        }
//                    });
//                    AlertDialog alertDialog = builder.create();
//                    alertDialog.show();
//                }
//            });
        }
    }


    @Override
    public int getItemCount() {
        return lstTask.size();
    }


    public void add(Item task){
        this.lstTask.add(task);
        listBackup.add(task);
        notifyDataSetChanged();
    }
    public void update(int position, Item cat) {

        lstTask.set(position, cat);
        listBackup.set(position, cat);
        notifyDataSetChanged();
    }

    public Item getItem(int position) {
        return lstTask.get(position);
    }


    public void setItemListener(ItemListener itemListener) {
        this.taskItemListener = itemListener;
    }


    public class TaskViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener {
        private TextView tvName, tvStartDate, tvEndDate;
        CheckBox ckbIsCompleted;
        private Button btnRemove;

        public TaskViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvTask);
//            tvDescribe = itemView.findViewById(R.id.eTaskDesc);
            tvStartDate = itemView.findViewById(R.id.tvStartDate);
            tvEndDate = itemView.findViewById(R.id.tvEndDate);
            btnRemove = itemView.findViewById(R.id.btnRemove);
            ckbIsCompleted = itemView.findViewById(R.id.ckbIsCompleted);
            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View view) {
            if (taskItemListener != null) {
                taskItemListener.onItemClick(view, getAdapterPosition());
            }
        }
    }
    public interface ItemListener{
        void onItemClick(View view, int position);
    }

}

