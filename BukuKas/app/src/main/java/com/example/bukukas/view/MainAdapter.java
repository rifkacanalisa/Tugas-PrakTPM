package com.example.bukukas.view;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bukukas.R;
import com.example.bukukas.database.DataPenjualan;

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
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainAdapter.viewHolder holder, int position) {
        final DataPenjualan item = list.get(position);
        holder.tvID.setText(item.getId()+"");
        holder.tvTanggal.setText(item.getTanggal());
        holder.tvPemasukanKotor.setText(item.getPemasukan()+"");
        holder.tvPengeluaran.setText(item.getPengeluaran()+"");
        int pemasukanKotor, pengeluaran, pemasukan;
        pemasukanKotor = item.getPemasukan();
        pengeluaran = item.getPengeluaran();
        pemasukan = pemasukanKotor - pengeluaran;
        holder.tvPemasukan.setText(pemasukan+"");

        if(pemasukan > 0){
            holder.cardView.setCardBackgroundColor(Color.parseColor("#98ff8c"));
        }
        else {
            holder.cardView.setCardBackgroundColor(Color.parseColor("#ff8c8c"));
        }

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mView.editData(item);
            }
        });

        holder.cardView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                mView.deleteData(item);
                return true;
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
