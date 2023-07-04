package com.example.voteclone;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class ResultVote extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resultvote);
        setTitle("투표 결과");

        ImageView resImg = (ImageView) findViewById(R.id.resImg);
        TextView resText = (TextView) findViewById(R.id.tv1);
        int top = 0;

        Intent intent = getIntent();
        int[] rVote = intent.getIntArrayExtra("vCount");
        String[] rName = intent.getStringArrayExtra("Name");

        int rImg[] = {R.drawable.pic1, R.drawable.pic2, R.drawable.pic3};

        for(int i = 0; i < rVote.length; i++) {
            if(rVote[top] < rVote[i]) top = i;
        }

        rVote.toString();
        resImg.setImageResource(rImg[top]);
        resText.setText(rName[top]+"/"+rVote[top]+"표");

        Button btn = findViewById(R.id.rbtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
