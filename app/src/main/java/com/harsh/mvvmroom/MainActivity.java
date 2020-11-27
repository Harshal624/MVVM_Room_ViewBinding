package com.harsh.mvvmroom;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.harsh.mvvmroom.databinding.ActivityMainBinding;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    LaptopViewModel viewModel;
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        viewModel = new ViewModelProvider(this).get(LaptopViewModel.class);

        viewModel.getLaptops().observe(this, new Observer<List<Laptop>>() {
            @Override
            public void onChanged(List<Laptop> laptops) {
                for (int i = 0; i < laptops.size(); i++) {
                    binding.textview.setText(laptops.get(i).toString());
                }
            }
        });

        binding.addLaptop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.insert(new Laptop("TestLaptop", "This is a laptop " +
                        "description", 8, 3, 3, 30000));
            }
        });

    }
}
