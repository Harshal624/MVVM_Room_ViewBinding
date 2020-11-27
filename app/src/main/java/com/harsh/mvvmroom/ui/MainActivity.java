package com.harsh.mvvmroom.ui;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.harsh.mvvmroom.databinding.ActivityMainBinding;
import com.harsh.mvvmroom.model.Laptop;
import com.harsh.mvvmroom.ui.adapter.LaptopRecyclerAdapter;
import com.harsh.mvvmroom.ui.adapter.OnLaptopClickListener;
import com.harsh.mvvmroom.viewmodel.LaptopViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity implements OnLaptopClickListener {
    private static final String TAG = "MainActivity";
    LaptopViewModel viewModel;
    ActivityMainBinding binding;
    LaptopRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        adapter = new LaptopRecyclerAdapter(Laptop.itemCallback, this);
        viewModel = new ViewModelProvider(this).get(LaptopViewModel.class);

        viewModel.getLaptops().observe(this, new Observer<List<Laptop>>() {
            @Override
            public void onChanged(List<Laptop> laptops) {
                adapter.submitList(laptops);
            }
        });
        //LaptopRecyclerAdapter adapter = new LaptopRecyclerAdapter(Laptop.itemCallback,this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.recyclerview.setLayoutManager(layoutManager);
        binding.recyclerview.setHasFixedSize(true);
        binding.recyclerview.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        binding.recyclerview.setAdapter(adapter);

        binding.floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.insert(new Laptop("Dell XPS 6969", "This is a " +
                        "laptop description", 4, 1, 2, 25000));
            }
        });
    }

    @Override
    public void onClick(Laptop laptop, int postion) {
        viewModel.delete(laptop);
    }
}
