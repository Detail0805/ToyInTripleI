package LeetCodeExercise;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

class MyTask extends TimerTask{
	int count;
	@Override
	public void run() {
//		try {
//			new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").parse("2017.08.30:00:00");
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println("yeeeeeee");
//		System.out.println(count);
//		count++;
		
	}
	
}

public class ScheduleServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	Timer timer;
	int count;
	
	public void init(){
		timer = new Timer();
		try {
			timer.scheduleAtFixedRate(new MyTask(){
				public void run() {try {
					new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").parse("2017.08.30 "+count+":00:00");
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					System.out.println("第"+count+"次" +"時間點 :"+new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").parse("2017.08.30 "+count+":00:00"));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				count++;}
			},new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").parse("2017.08.30 00:00:00"), 3600000l);
			
		} catch (ParseException e) {
			System.out.println("格式錯誤");
		}
	}
	public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
	
	}
	

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doGet(request, response);
}
public void destroy(){
	timer.cancel();
	}
}
