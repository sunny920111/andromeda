package com.example.macro;
import android.app.Instrumentation;
import android.app.Service;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.SystemClock;
import android.view.Gravity;
import android.view.InputDevice;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;

public class MacroService extends Service implements OnClickListener,Runnable{

	
    private WindowManager.LayoutParams mParams;  //layout params 객체. 뷰의 위치 및 크기
	private WindowManager mWindowManager;  
	private LayoutInflater inflater;
	private View myView;
	private boolean flag =true;
	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void onCreate(){
		System.out.println("onCreate");
		super.onCreate();

		inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
		myView = inflater.inflate(R.layout.activity_main, null);     
		
		mParams = new WindowManager.LayoutParams(
					WindowManager.LayoutParams.WRAP_CONTENT,
		            WindowManager.LayoutParams.WRAP_CONTENT,
		            WindowManager.LayoutParams.TYPE_PHONE,//항상 최 상위. 터치 이벤트 받을 수 있음.
		            WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,  //포커스를 가지지 않음
		            PixelFormat.TRANSLUCENT
		);
		
		mParams.gravity = Gravity.LEFT | Gravity.TOP;
	    mWindowManager = (WindowManager) getSystemService(WINDOW_SERVICE);
	    mWindowManager.addView(myView, mParams);
	   
	    setButtonListener(myView);
	    
	}

	@Override
	public void onDestroy(){
		System.out.println("onDestroy");
		if(mWindowManager != null) {        //서비스 종료시 뷰 제거. *중요 : 뷰를 꼭 제거 해야함.
			if(myView != null){
				((WindowManager) getSystemService(WINDOW_SERVICE)).removeView(myView);

			}
            
            mWindowManager = null;
        }
		super.onDestroy();
	}

	@Override
	public void onClick(View v) {
		int id = v.getId();
		if (id == R.id.startMacro) {
			startMacro();
		} else if (id == R.id.stopMacro) {
			stopMacro();
		}
	}
	
	public void setButtonListener(View myView){
		Button startButton = (Button)myView.findViewById(R.id.startMacro);
		Button stopButton = (Button)myView.findViewById(R.id.stopMacro);
		
		startButton.setOnClickListener(this);
		stopButton.setOnClickListener(this);
		
	}
	
	public void startMacro(){
		System.out.println("startMacro");
		flag = true;
		this.run();
	}
	
	public void stopMacro(){

		System.out.println("stopMacro");
		flag = false;
	}
	

	@Override
	public void run() {
		// TODO Auto-generated method stub

			try{
				long downTime = SystemClock.uptimeMillis();
				long eventTime = SystemClock.uptimeMillis();
				final MotionEvent down_event = MotionEvent.obtain(downTime, eventTime,   MotionEvent.ACTION_DOWN, 100,200, 0);
				final MotionEvent up_event = MotionEvent.obtain(downTime, eventTime,   MotionEvent.ACTION_UP, 100, 200, 0);
				down_event.setSource(InputDevice.SOURCE_TOUCHSCREEN);		
				up_event.setSource(InputDevice.SOURCE_TOUCHSCREEN);
				
		
				final Instrumentation inst = new Instrumentation() ;
				Thread task = new Thread(new Runnable() {
					 private Handler handler;
		
					@Override
					public void run() {
						// TODO Auto-generated method stub
						 Looper.prepare();
		                 handler = new Handler();
		                 handler.post(new Runnable() {
		
							@Override
							public void run() {
								// TODO Auto-generated method stub
								while(flag){
									
			                         try {
			                        	 inst.sendPointerSync(down_event);
			                             Thread.sleep(10);
			                             inst.sendPointerSync(up_event);
			                             Thread.sleep(200);
			                             System.out.println("point :"+down_event.getX()+","+down_event.getY());
			                          } catch (InterruptedException e) {
			                             // TODO Auto-generated catch block
			                             e.printStackTrace();
			                         }
			                   
								}
								
							}
		                 
		                 });
		                 
		                 Looper.loop();
		
					}
					
					
				});
				
				 task.start();
			
			
			}catch(NullPointerException e){
				e.printStackTrace();
			}
	
	}
	
	

}
