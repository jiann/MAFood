package com.ma.mafood.component;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ma.mafood.R;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class StoreAdapter extends BaseAdapter  {
    ArrayList<Store> adapterStores;
    LayoutInflater inflater;

    public StoreAdapter(Context context, ArrayList<Store> stores) {
        this.adapterStores=stores;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return adapterStores.size();
    }

    @Override
    public Object getItem(int i) {
        return adapterStores.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int index, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.compoment_card_store,null);

        ImageView img = (ImageView) view.findViewById(R.id.imgStore_main);
        TextView name = (TextView) view.findViewById(R.id.storeName_main);
        TextView description = (TextView) view.findViewById(R.id.storeDescribe_main);
        TextView price = (TextView) view.findViewById(R.id.storeShipPrice_main);
        try {
            URL storeImageUrl = new URL(adapterStores.get(index).getImg());
            img.setImageBitmap(BitmapFactory.decodeStream(storeImageUrl.openConnection().getInputStream()));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        name.setText(adapterStores.get(index).getName());
        description.setText(adapterStores.get(index).getDescribe());
        price.setText(adapterStores.get(index).getPrice());

        return view;
    }
}
