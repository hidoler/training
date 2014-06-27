/**
 * 
 */
package mention;

import java.util.Calendar;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.util.Log;

/**
 * @author Richard 2014.06.27
 *
 */
public class MainReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		setAlarm(context);
	}
	
	private void setAlarm(Context context) {
		AlarmManager alarmMgr = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(context, AlarmReceiver.class);
		PendingIntent alarmIntent = PendingIntent.getBroadcast(context, 0, intent, 0);

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        // Set the alarm's trigger time to 10:00 a.m.
        calendar.set(Calendar.HOUR_OF_DAY, 9);
        
        Log.d("wangyu", "wangyu"+Long.toString(calendar.getTimeInMillis()));
        
        alarmMgr.setInexactRepeating(AlarmManager.RTC_WAKEUP,  
                calendar.getTimeInMillis(), AlarmManager.INTERVAL_HOUR, alarmIntent);
        
        
    }

}
