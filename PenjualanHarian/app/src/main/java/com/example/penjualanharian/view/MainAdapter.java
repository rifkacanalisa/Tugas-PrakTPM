package com.example.penjualanharian.view;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.penjualanharian.R;
import com.example.penjualanharian.database.DataPenjualan;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.viewHolder> {
    Context context;
    List<DataPenjualan> list;
    MainContact.view mView;

    public MainAdapter(Context context, List<DataPenjualan> list, MainContact.view mView) {
        this.context = context;
        this.list = list;
        this.mView = mView;
    }

    @NonNull
    @Override
    public MainAdapter.viewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  MainAdapter.viewHolder holder, int position) {
        final DataPenjualan item = list.get(position);
        holder.tvID.setText(item.getId());
        holder.tvTanggal.setText(item.getTanggal());
        holder.tvPemasukanKotor.setText(item.getPemasukan());
        holder.tvPengeluaran.setText(item.getPengeluaran());
        int pemasukanKotor, pengeluaran, pemasukan;
        pemasukanKotor = item.getPemasukan();
        pengeluaran = item.getPengeluaran();
        pemasukan = pemasukanKotor - pengeluaran;
        holder.tvPemasukan.setText(pemasukan);

        if(pemasukan > 0){
            holder.cardView.setCardBackgroundColor(Integer.parseInt("#1aff00"));
        }
        else {
            holder.cardView.setCardBackgroundColor(Integer.parseInt("#ff0000"));
        }

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, EditDataActivity.class);
                intent.putExtra("tanggal", item.getTanggal());
                intent.putExtra("pemasukan", item.getPemasukan());
                intent.putExtra("pengeluaran", item.getPengeluaran());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView tvID, tvTanggal, tvPemasukanKotor, tvPengeluaran, tvPemasukan;
        CardView cardView;
        public viewHolder(@NonNull  View itemView) {
            super(itemView);
            tvID = itemView.findViewById(R.id.tv_item_id);
            tvTanggal = itemView.findViewById(R.id.tv_item_tanggal);
            tvPemasukanKotor = itemView.findViewById(R.id.tv_item_pemasukan_kotor);
            tvPengeluaran = itemView.findViewById(R.id.tv_item_pengeluaran);
            tvPemasukan = itemView.findViewById(R.id.tv_item_pemasukan);
            cardView = itemView.findViewById(R.id.cardview_item);
        }
    }
}
