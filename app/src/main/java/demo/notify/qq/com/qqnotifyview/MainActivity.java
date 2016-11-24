package demo.notify.qq.com.qqnotifyview;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewTreeObserver;

public class MainActivity extends AppCompatActivity {
    private QQNotifyView qqNotifyView;
    Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        qqNotifyView = (QQNotifyView) findViewById(R.id.qqnotify);
        qqNotifyView.setAnimationFinishListener(new AnimationFinishListener() {
            @Override
            public void oncomplete() {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        qqNotifyView.closeNotifyAnima();
                    }
                }, 3000);
            }
        });
        qqNotifyView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                qqNotifyView.startShowAnima();
            }
        });
    }
}
