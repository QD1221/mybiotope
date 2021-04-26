package com.example.mybiotope;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mybiotope.adapter.DiscountedProductAdapter;
import com.example.mybiotope.adapter.RecentlyViewedAdapter;
import com.example.mybiotope.model.DiscountedProducts;
import com.example.mybiotope.model.RecentlyViewed;

import java.util.ArrayList;
import java.util.List;

import static com.example.mybiotope.R.drawable.b1;
import static com.example.mybiotope.R.drawable.b2;
import static com.example.mybiotope.R.drawable.b3;
import static com.example.mybiotope.R.drawable.b4;
import static com.example.mybiotope.R.drawable.card1;
import static com.example.mybiotope.R.drawable.card2;
import static com.example.mybiotope.R.drawable.card3;
import static com.example.mybiotope.R.drawable.card4;
import static com.example.mybiotope.R.drawable.discountberry;
import static com.example.mybiotope.R.drawable.discountbrocoli;
import static com.example.mybiotope.R.drawable.discountmeat;

public class TrangChuFragment extends Fragment {

    RecyclerView discountRecyclerView, recentlyViewedRecycler;
    DiscountedProductAdapter discountedProductAdapter;
    List<DiscountedProducts> discountedProductsList;

    RecentlyViewedAdapter recentlyViewedAdapter;
    List<RecentlyViewed> recentlyViewedList;

    LinearLayout llmuasam;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_trangchu, container, false);
        discountRecyclerView = view.findViewById(R.id.discountedRecycler);
        recentlyViewedRecycler = view.findViewById(R.id.recently_item);

        llmuasam = view.findViewById(R.id.llmuasam);
        llmuasam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CuaHangActivity.class);
                startActivity(intent);
            }
        });


        // adding data to model
        discountedProductsList = new ArrayList<>();
        discountedProductsList.add(new DiscountedProducts(1, discountberry));
        discountedProductsList.add(new DiscountedProducts(2, discountbrocoli));
        discountedProductsList.add(new DiscountedProducts(3, discountmeat));
        discountedProductsList.add(new DiscountedProducts(4, discountberry));
        discountedProductsList.add(new DiscountedProducts(5, discountbrocoli));
        discountedProductsList.add(new DiscountedProducts(6, discountmeat));

        // adding data to model
        recentlyViewedList = new ArrayList<>();
        recentlyViewedList.add(new RecentlyViewed("Watermelon", "Watermelon has high water content and also provides some fiber.", "80000đ", "1", "KG", card4, b4));
        recentlyViewedList.add(new RecentlyViewed("Papaya", "Papayas are spherical or pear-shaped fruits that can be as long as 20 inches.", "85000đ", "1", "KG", card3, b3));
        recentlyViewedList.add(new RecentlyViewed("Strawberry", "The strawberry is a highly nutritious fruit, loaded with vitamin C.", "30000đ", "1", "KG", card2, b1));
        recentlyViewedList.add(new RecentlyViewed("Kiwi", "Full of nutrients like vitamin C, vitamin K, vitamin E, folate, and potassium.", "30000đ", "1", "PC", card1, b2));

        setDiscountedRecycler(discountedProductsList);
        setRecentlyViewedRecycler(recentlyViewedList);
        setHasOptionsMenu(true);
        return view;
    }

    private void setDiscountedRecycler(List<DiscountedProducts> dataList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        discountRecyclerView.setLayoutManager(layoutManager);
        discountedProductAdapter = new DiscountedProductAdapter(getContext(),dataList);
        discountRecyclerView.setAdapter(discountedProductAdapter);
    }


    private void setRecentlyViewedRecycler(List<RecentlyViewed> recentlyViewedDataList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recentlyViewedRecycler.setLayoutManager(layoutManager);
        recentlyViewedAdapter = new RecentlyViewedAdapter(getContext(),recentlyViewedDataList);
        recentlyViewedRecycler.setAdapter(recentlyViewedAdapter);
    }
}
