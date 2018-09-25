package com.odbpo.fenggou.spannablestringdemo;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.widget.TextView;

import com.odbpo.fenggou.spannablestringdemo.util.CenterAlignImageSpan;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv = (TextView) findViewById(R.id.tv_content);
        String content = getResources().getString(R.string.tv_content);
        Drawable drawable = getResources().getDrawable(R.drawable.icon_manzeng);
        formatImgText(tv, content, drawable, true);
    }

    public void formatImgText(TextView tv, String content, final Drawable drawable, boolean flag) {
        SpannableString spanText = new SpannableString(" " + content);

        // 左上右下 控制图片大小
//        drawable.setBounds(0, 0, DisplayUtil.dip2px(this, 36), DisplayUtil.dip2px(this, 16));
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());

        if (flag) {
            // 替换0,1的字符
//            spanText.setSpan(new ImageSpan(drawable), 0, 1, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);

            //图片居中对齐
            CenterAlignImageSpan imageSpan = new CenterAlignImageSpan(drawable);
            spanText.setSpan(imageSpan, 0, 1, ImageSpan.ALIGN_BASELINE);
        } else {
            // 替换0,1的字符
            spanText.setSpan("", 0, 1, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
        }

        tv.append(spanText);
    }

}
