package com.example.voteclone;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;

import java.io.IOException;

public class ResultVote extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resultvote);
        setTitle("투표 결과");

        ImageView resImg = (ImageView) findViewById(R.id.resImg);
        TextView resText = (TextView) findViewById(R.id.tv1);
        final ListView lv = (ListView) findViewById(R.id.lv_voter);

        int top = 0;
        Intent intent = getIntent();
        int[] rVote = intent.getIntArrayExtra("vCount");
        String[] rCandidate = intent.getStringArrayExtra("Candidate");
        String[] rVoter = intent.getStringArrayExtra("Voter");

        ArrayAdapter<String> lAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, rVoter);
        lv.setAdapter(lAdapter);

        int rImg[] = {R.drawable.pic1, R.drawable.pic2, R.drawable.pic3};

        for(int i = 0; i < rVote.length; i++) {
            if(rVote[top] < rVote[i]) top = i;
        }

        rVote.toString();
        resImg.setImageResource(rImg[top]);
        resText.setText(rCandidate[top]+"/"+rVote[top]+"표");

        Button btn = findViewById(R.id.rbtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}
