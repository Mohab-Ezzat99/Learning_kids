package mrandroid.app.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;

import mrandroid.app.R;
import mrandroid.app.model.AnswerModel;

public class AnswerAdapter extends RecyclerView.Adapter<AnswerAdapter.MedicineViewHolder> {

    private List<AnswerModel> list = new ArrayList<>();
    private OnItemClickListener listener;
    private int selectedPosition = -1;

    @SuppressLint("InflateParams")
    @NonNull
    @Override
    public MedicineViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MedicineViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_answer, parent, false));
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull MedicineViewHolder holder, int position) {
        AnswerModel item = list.get(holder.getAdapterPosition());

        holder.radioButton.setChecked(selectedPosition == holder.getAdapterPosition());

        holder.ivImg.setImageResource(item.getAnswer());

        holder.itemView.getRootView().setOnClickListener(view -> {
            listener.onItemClick(item);
            selectedPosition = holder.getAdapterPosition();
            notifyDataSetChanged();
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public AnswerModel getSelectedAnswer() {
        return list.get(selectedPosition);
    }

    public void setListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public void setList(List<AnswerModel> list) {
        this.selectedPosition = -1;
        this.list = list;
        this.notifyDataSetChanged();
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    static class MedicineViewHolder extends RecyclerView.ViewHolder {

        private final RadioButton radioButton;
        private final ImageView ivImg;

        public MedicineViewHolder(@NonNull View itemView) {
            super(itemView);

            radioButton = itemView.findViewById(R.id.radioButton);
            ivImg = itemView.findViewById(R.id.ivImg);

        }
    }

    public interface OnItemClickListener {
        void onItemClick(AnswerModel item);
    }
}