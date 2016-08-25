package com.timaimee.blockview;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;


public class MainActivity extends ActionBarActivity {

    BlockPercentView mBlockView;
    float progress[] = new float[]

            {
                    0.1f, 0.3f, 0.2f, 0.1f, 0.3f
            };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBlockView = (BlockPercentView) findViewById(R.id.main_blockview);
        mBlockView.setProgressArr(progress);

    }


}
