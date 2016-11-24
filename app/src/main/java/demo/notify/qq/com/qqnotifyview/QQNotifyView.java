package demo.notify.qq.com.qqnotifyview;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.ObjectAnimator;

/*************************************************
 * <p/>
 * <p>类描述：${todo}(用一句话描述该文件做什么)</p>
 * <p>创建人：余志伟</p>
 * <p>创建时间 : 2016/11/24</p>
 * <p>修改人：       </p>
 * <p>修改时间：   </p>
 * <p>修改备注：   </p>
 *
 * @version V3.1
 *********************************/
public class QQNotifyView extends RelativeLayout {
    private View contenView;
    private View notifyView;
    private int notifyViewHeight;
    private int notifyViewWidth;
    AnimationFinishListener animationFinishListener;
    public QQNotifyView(Context context) {
        super(context);
    }

    public QQNotifyView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public QQNotifyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed,l,t,r,b);
        notifyViewHeight = notifyView.getHeight();
        notifyViewWidth= notifyView.getWidth();
        notifyView.layout(notifyView.getLeft(), -notifyViewHeight, notifyView.getRight(), 0);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        contenView =findViewById(R.id.contentview_id);
        notifyView =findViewById(R.id.notifyview_id);
    }
    public void startShowAnima(){
//        ObjectAnimator.ofFloat(notifyView, "y", -notifyViewHeight, 0).setDuration(4000).start();
        
        
        //下面这2个都可以y是直接改变坐标，translationY是改变偏移量来改变坐标，关闭类似，也有另外一个方法对应
//        ObjectAnimator objectAnimator =ObjectAnimator.ofFloat(notifyView, "y", -notifyViewHeight, 0);
        ObjectAnimator objectAnimator =ObjectAnimator.ofFloat(notifyView, "translationY", 0, notifyViewHeight);
        objectAnimator.setDuration(2000);
        objectAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                if(animationFinishListener!=null){
                    animationFinishListener.oncomplete();
                }
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        objectAnimator.start();
    }
    public void closeNotifyAnima(){
//        ObjectAnimator.ofFloat(notifyView, "translationY", 0,-notifyViewHeight).setDuration(3000).start();
        ObjectAnimator.ofFloat(notifyView, "translationY", notifyViewHeight,0).setDuration(3000).start();
    }
    public void setAnimationFinishListener(AnimationFinishListener listener){
        this.animationFinishListener = listener;
        }
    
}
