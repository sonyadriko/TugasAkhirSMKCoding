package com.example.xdreamer.notepadtugasakhir;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {

    private List<CatatanModel> catatanModels;
    private TextView tvJudul;
    private TextView tvDeskripsi;
    public static final String EXTRA_CATATAN = "EXTRA_NOTE";

    public MainAdapter(List<CatatanModel> catatanModels) {
        this.catatanModels = catatanModels;
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.catatan_item, parent, false);
        return new MainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MainViewHolder holder, final int position) {
        final CatatanModel catatanModel = catatanModels.get(position);

        holder.inputJudul.setText(catatanModel.getJudul());
        holder.inputDeskripsi.setText(catatanModel.getDeskripsi());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent k = new Intent(holder.itemView.getContext(), ActionCatatanActivity.class);
                k.putExtra(EXTRA_CATATAN, catatanModels.get(position));
                holder.itemView.getContext().startActivity(k);
            }
        });
    }

    public int getItemCount() {
        return catatanModels.size();
    }

    public class MainViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.txt_judul)
        TextView inputJudul;
        @BindView(R.id.txt_deskripsi)
        TextView inputDeskripsi;

        public MainViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);

        }
    }
}
