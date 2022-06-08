package com.ma.mafood.component;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.FrameLayout;
import androidx.cardview.widget.CardView;

public class StoreCard {
    private String storeImage;
    private String storeName;
    private String storeDescribe;
    private int storeShipping;


    public StoreCard(String storeImage, String storeName, String storeDescribe, int storeShipping) {
        this.storeImage = storeImage;
        this.storeName = storeName;
        this.storeDescribe = storeDescribe;
        this.storeShipping = storeShipping;
    }

    CardView card ;
    CardView.LayoutParams params = new CardView.LayoutParams(CardView.LayoutParams.MATCH_PARENT, CardView.LayoutParams.MATCH_PARENT);

}
/*
<androidx.cardview.widget.CardView
                    android:id="@+id/storeCompoment"
                    android:layout_width="match_parent"
                    android:layout_height="match_parent"
                    android:layout_margin="10dp"
                    app:cardCornerRadius="12dp">

                    <LinearLayout
                        android:layout_width="match_parent"
                        android:layout_height="match_parent"
                        android:orientation="horizontal">

                        <ImageView
                            android:id="@+id/imgStore_main"
                            android:layout_width="108dp"
                            android:layout_height="108dp"
                            android:layout_margin="16dp"
                            tools:srcCompat="@color/purple_200" />

                        <LinearLayout
                            android:layout_width="match_parent"
                            android:layout_height="match_parent"
                            android:layout_marginVertical="16dp"
                            android:layout_marginRight="16dp"
                            android:orientation="vertical">

                            <TextView
                                android:id="@+id/storeName_main"
                                android:layout_width="wrap_content"
                                android:layout_height="wrap_content"
                                android:fontFamily="sans-serif-medium"
                                android:gravity="top"
                                android:text="Store1"
                                android:textSize="24sp"
                                android:textStyle="bold"
                                android:visibility="visible" />

                            <TextView
                                android:id="@+id/storeDescribe_main"
                                android:layout_width="match_parent"
                                android:layout_height="wrap_content"
                                android:text="Any describe" />

                            <TextView
                                android:id="@+id/storeShipPrice_main"
                                android:layout_width="wrap_content"
                                android:layout_height="match_parent"
                                android:gravity="bottom"
                                android:text="$TWD10" />

                        </LinearLayout>

                    </LinearLayout>

                </androidx.cardview.widget.CardView>


 */