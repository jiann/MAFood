package com.ma.mafood;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.ma.mafood.component.Store;
import com.ma.mafood.component.StoreAdapter;

import org.w3c.dom.Text;

public class HomeActivity extends AppCompatActivity {
    ArrayList<Store> stores = new ArrayList<>();
    private StoreAdapter storeAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ListView contents = findViewById(R.id.storeListView);

        DatabaseReference products = FirebaseDatabase.getInstance().getReference("Meals");
        products.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot mySnapshot : snapshot.getChildren()) {
                    String img = snapshot.child("image").toString();
                    String name = snapshot.child("meal name").toString();
                    String description = snapshot.child("meal description").toString();
                    String price = snapshot.child("meal price").toString();
                    Store tempStore = new Store(img, name, description, price);
                    stores.add(tempStore);
                }
                storeAdapter = new StoreAdapter(getApplicationContext(), stores);
                contents.setAdapter(storeAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }

    public void gotoProfileActivity(View v){
        Intent it = new Intent(this, ProfileActivity.class);
        startActivity(it);
    }
}
//    public void showProduct() {
//        DatabaseReference products = FirebaseDatabase.getInstance().getReference("Meals");
//        products.addValueEventListener(
//                new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                        for(DataSnapshot snapshot : dataSnapshot.getChildren()) {
//                            String img = snapshot.child("image").toString();
//                            String name = snapshot.child("meal name").toString();
//                            String description = snapshot.child("meal description").toString();
//                            String price = snapshot.child("meal price").toString();
//                            LinearLayout contentLinearLayout = (LinearLayout) findViewById(R.id.contentTable);
//                            TextView tvt = new TextView(this);
//
//                            try {
//                                contentLinearLayout.addView(createViewProduct(img,name,description,price));
//                            } catch (IOException e) {
//                                e.printStackTrace();
//                            }
//                            //CardView contentCard = (CardView) findViewById(R.id.storeCompoment);
//
//                        }
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError error) {
//
//                    }
//                });
//    }
//    public CardView createViewProduct(String storeImage, String storeName, String storeDescribe, String storeShipping) throws IOException {
//        int tmp;
//        //cardView
//        CardView card = new CardView(this);
//        CardView.LayoutParams paramsCard = new CardView.LayoutParams(CardView.LayoutParams.MATCH_PARENT, CardView.LayoutParams.MATCH_PARENT);
//        tmp = inDp(10);
//        paramsCard.setMargins(tmp,tmp,tmp,tmp);
//        card.setLayoutParams(paramsCard);
//        card.setRadius(12);
//
//        //cardView[--linearLayoutH--]
//        LinearLayout linearLayoutH = new LinearLayout(this);
//        LinearLayout.LayoutParams paramsHorizontalView = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
//        linearLayoutH.setOrientation(LinearLayout.HORIZONTAL);
//        linearLayoutH.setLayoutParams(paramsHorizontalView);
//
//        //cardView[linearLayoutH[--imageView--]]
//        ImageView storeImageView = new ImageView(this);
//        URL storeImageUrl = new URL(storeImage);
//        storeImageView.setImageBitmap(BitmapFactory.decodeStream(storeImageUrl.openConnection().getInputStream()));
//        tmp = inDp(108);
//        LinearLayout.LayoutParams paramsImageView = new LinearLayout.LayoutParams(tmp,tmp);
//        tmp = inDp(16);
//        paramsImageView.setMargins(tmp,tmp,tmp,tmp);
//        storeImageView.setLayoutParams(paramsImageView);
//
//
//        //cardView[linearLayoutH[imageView,--linearLayoutV--]]
//        LinearLayout linearLayoutV = new LinearLayout(this);
//        //linearLayout style
//        LinearLayout.LayoutParams paramsVerticalView = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
//        tmp = inDp(16);
//        paramsVerticalView.setMargins(0,tmp,tmp,tmp);
//        linearLayoutV.setOrientation(LinearLayout.VERTICAL);
//        linearLayoutV.setLayoutParams(paramsHorizontalView);
//
//        //cardView[linearLayoutH[imageView,linearLayoutV[--textView,textView,textView--]]]
//        TextView storeNameTV = new TextView(this);
//        storeNameTV.setText(storeName);
//        storeNameTV.setGravity(Gravity.TOP);
//        storeNameTV.setTypeface(Typeface.create("sans-serif-medium",Typeface.BOLD));
//        storeNameTV.setTextSize(TypedValue.COMPLEX_UNIT_SP, 24);
//        LinearLayout.LayoutParams paramsNameTV = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
//        storeNameTV.setLayoutParams(paramsNameTV);
//
//        TextView storeDescribeTV = new TextView(this);
//        storeDescribeTV.setText(storeDescribe);
//        LinearLayout.LayoutParams paramsDescribeTV = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
//        storeDescribeTV.setLayoutParams(paramsDescribeTV);
//
//        TextView storeShippingTV = new TextView(this);
//        String formatShipping = "$" + storeShipping;
//        storeShippingTV.setText(formatShipping);
//        LinearLayout.LayoutParams paramsShippingTV = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT);
//        storeShippingTV.setLayoutParams(paramsShippingTV);
//        storeShippingTV.setGravity(Gravity.BOTTOM);
//
//        linearLayoutV.addView(storeNameTV);
//        linearLayoutV.addView(storeDescribeTV);
//        linearLayoutV.addView(storeShippingTV);
//        linearLayoutH.addView(storeImageView);
//        linearLayoutH.addView(linearLayoutV);
//        card.addView(linearLayoutH);
//        //cardView[linearLayoutH[imageView,linearLayoutV[textView,textView,textView]]]
//
//        return card;
//    }
//    public int inDp(int value) {
//        return (int) (value * getResources().getDisplayMetrics().density);
//    }
