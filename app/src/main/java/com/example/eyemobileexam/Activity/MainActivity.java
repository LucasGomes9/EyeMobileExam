package com.example.eyemobileexam.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.RelativeSizeSpan;
import android.util.Log;
import android.view.Window;
import android.widget.TextView;

import com.example.eyemobileexam.Adapter.ItemsRecyclerAdapter;
import com.example.eyemobileexam.Adapter.SectionsPagerAdapter;
import com.example.eyemobileexam.Model.Product;
import com.example.eyemobileexam.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private RecyclerView itemsRecycler;
    private TextView textTotal;
    private ArrayList<Product> productList = new ArrayList<Product>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_main);
        itemsRecycler = findViewById(R.id.itemsRecycler);
        textTotal = findViewById(R.id.textTotal);

        GridLayoutManager linearLayoutManager = new GridLayoutManager(this, 3);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        itemsRecycler.setLayoutManager(linearLayoutManager);
        itemsRecycler.setHasFixedSize(false);
        createList();
        ItemsRecyclerAdapter adapter = new ItemsRecyclerAdapter(this, productList ) ;
        itemsRecycler.setAdapter(adapter);

        Log.d("test", productList.size() + "");
        Log.d("test", productList + "");

        SpannableString spannableString=  new SpannableString(textTotal.getText());
        spannableString.setSpan(new RelativeSizeSpan(1.5f), 2, textTotal.length(), 0);
        textTotal.setText(spannableString);

        adapter.notifyDataSetChanged();

    }

    private void createList(){
        for(int i = 0; i < 10; i++){
            Product product = new Product((int) (i + Math.floor((Math.random()*(200-100+1)+100))), "Product "+ i, "Type "+ i);

            productList.add(product);
        }
    }
}