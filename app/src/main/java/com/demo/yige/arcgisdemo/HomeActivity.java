package com.demo.yige.arcgisdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by yige on 2016/12/8.
 */

public class HomeActivity extends Activity implements View.OnClickListener{

    private Button btn_one,btn_two,btn_three,btn_four,btn_five,btn_six,btn_seven
            ,btn_eight,btn_nine,btn_ten,btn_11,btn_twelve,btn_thirteen,btn_fourteen,btn_fiveteen,btn_sixteen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        btn_one = (Button) findViewById(R.id.btn_one);
        btn_two = (Button) findViewById(R.id.btn_two);
        btn_three = (Button) findViewById(R.id.btn_three);
        btn_four = (Button) findViewById(R.id.btn_four);
        btn_five = (Button) findViewById(R.id.btn_five);
        btn_six = (Button) findViewById(R.id.btn_six);
        btn_seven = (Button) findViewById(R.id.btn_seven);
        btn_eight = (Button) findViewById(R.id.btn_eight);
        btn_nine = (Button) findViewById(R.id.btn_nine);
        btn_ten = (Button) findViewById(R.id.btn_ten);
        btn_11 = (Button) findViewById(R.id.btn_11);
        btn_twelve = (Button) findViewById(R.id.btn_twelve);
        btn_thirteen = (Button) findViewById(R.id.btn_thirteen);
        btn_fourteen = (Button) findViewById(R.id.btn_fourteen) ;
        btn_fiveteen = (Button) findViewById(R.id.btn_fiveteen) ;
        btn_sixteen = (Button) findViewById(R.id.btn_sixteen) ;
        btn_one.setOnClickListener(this);
        btn_two.setOnClickListener(this);
        btn_three.setOnClickListener(this);
        btn_four.setOnClickListener(this);
        btn_five.setOnClickListener(this);
        btn_six.setOnClickListener(this);
        btn_seven.setOnClickListener(this);
        btn_eight.setOnClickListener(this);
        btn_nine.setOnClickListener(this);
        btn_ten.setOnClickListener(this);
        btn_11.setOnClickListener(this);
        btn_twelve.setOnClickListener(this);
        btn_thirteen.setOnClickListener(this);
        btn_fourteen.setOnClickListener(this);
        btn_fiveteen.setOnClickListener(this);
        btn_sixteen.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_one:
                Intent one = new Intent(HomeActivity.this,MainActivity.class);
                startActivity(one);
                break;
            case R.id.btn_two:
                Intent two = new Intent(HomeActivity.this,MapOneActivity.class);
                startActivity(two);
                break;
            case R.id.btn_three:
                Intent three = new Intent(HomeActivity.this,MapTwoActivity.class);
                startActivity(three);
                break;
            case R.id.btn_four:
                Intent four = new Intent(HomeActivity.this,MapThreeActivity.class);
                startActivity(four);
                break;
            case R.id.btn_five:
                Intent five = new Intent(HomeActivity.this,MapFourActivity.class);
                startActivity(five);
                break;
            case R.id.btn_six:
                Intent six = new Intent(HomeActivity.this,MapFiveActivity.class);
                startActivity(six);
                break;
            case R.id.btn_seven:
                Intent seven = new Intent(HomeActivity.this,MapSixActivity.class);
                startActivity(seven);
                break;
            case R.id.btn_eight:
                Intent eight = new Intent(HomeActivity.this,MapSevenActivity.class);
                startActivity(eight);
                break;
            case R.id.btn_nine:
                Intent nine = new Intent(HomeActivity.this,MapEightActivity.class);
                startActivity(nine);
                break;
            case R.id.btn_ten:
                Intent ten = new Intent(HomeActivity.this,MapNineActivity.class);
                startActivity(ten);
                break;
            case R.id.btn_11:
                Intent eleven = new Intent(HomeActivity.this,MapTenActivity.class);
                startActivity(eleven);
                break;
            case R.id.btn_twelve:
                Intent twelve = new Intent(HomeActivity.this,MapElevenActivity.class);
                startActivity(twelve);
                break;
            case R.id.btn_thirteen:
                Intent thirteen = new Intent(HomeActivity.this,MapThirteenActivity.class);
                startActivity(thirteen);
                break;
            case R.id.btn_fourteen:
                Intent fourteen = new Intent(HomeActivity.this,MapFourteenActivity.class);
                startActivity(fourteen);
                break;
            case R.id.btn_fiveteen:
                Intent fiveteen = new Intent(HomeActivity.this,MapFiveteenActivity.class);
                startActivity(fiveteen);
                break;
            case R.id.btn_sixteen:
                Intent sixteen = new Intent(HomeActivity.this,MapSixteenActivity.class);
                startActivity(sixteen);
                break;
        }
    }
}
