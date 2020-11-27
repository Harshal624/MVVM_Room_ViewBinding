package com.harsh.mvvmroom.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.harsh.mvvmroom.databinding.LaptopListBinding;
import com.harsh.mvvmroom.model.Laptop;

public class LaptopRecyclerAdapter extends ListAdapter<Laptop, LaptopRecyclerAdapter.ViewHolder> {


    OnLaptopClickListener laptopClickListener;

    public LaptopRecyclerAdapter(@NonNull DiffUtil.ItemCallback<Laptop> diffCallback, OnLaptopClickListener laptopClickListener) {
        super(diffCallback);
        this.laptopClickListener = laptopClickListener;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LaptopListBinding binding;
        binding = LaptopListBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Laptop laptop = getItem(position);
        holder.bind(laptop);
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        LaptopListBinding binding;

        public ViewHolder(@NonNull LaptopListBinding binding) {
            super(binding.getRoot());
            this.binding = binding;


            binding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        Laptop laptop = getItem(getAdapterPosition());
                        laptopClickListener.onClick(laptop, getAdapterPosition());
                    }
                }
            });
        }

        public void bind(Laptop laptop) {
            binding.laptopName.setText(laptop.getLaptop_name());
            binding.laptopDesc.setText(laptop.getLaptop_description());
            binding.laptopGpu.setText(laptop.getGpu() + "GB");
            binding.laptopRam.setText(laptop.getRam() + "GB");
            binding.laptopStorage.setText(laptop.getStorage() + "GB");
            binding.laptopCost.setText("Rs." + laptop.getCost());
        }
    }
}
