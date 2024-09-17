

import java.util.Calendar;
import java.util.GregorianCalendar;

import calendar.Meeting;
import calendar.MeetingCalendar;

public class WeeklyEvent extends CalendarEvent 
{
	private GregorianCalendar repeatUntil;
	
	public WeeklyEvent(String desc, String loc, GregorianCalendar start, GregorianCalendar end, GregorianCalendar repeat)
	{
		super(desc, loc, start, end);
		setRepeatUntil(repeat);
	}

	@Override
	public void scheduleEvent(MeetingCalendar cal)
	{
		Meeting weekly = new Meeting(getDescription(), getLocation(), getStartTime(), getEndTime());
		GregorianCalendar weeklyStart = getStartTime();
		GregorianCalendar weeklyEnd = getEndTime();
		GregorianCalendar weeklyFinal = getRepeatUntil();
		int cont = 0;
		boolean timeOver = false;
		while(timeOver == false)
		{
			
			cont = weeklyStart.compareTo(weeklyFinal);
			if(cont > 0)
			{
				timeOver = true;
				return;
				
			}
			else
			{
				weekly.setStartTime(weeklyStart);
				weekly.setEndTime(weeklyEnd);
				cal.addMeeting(weekly);
				weeklyStart.add(Calendar.DAY_OF_MONTH, 7);
				weeklyEnd.add(Calendar.DAY_OF_MONTH, 7);
			}
		}
		return;
	}

	public GregorianCalendar getRepeatUntil()
	{
		return repeatUntil;
	}

	public void setRepeatUntil(GregorianCalendar repeatUntil)
	{
		this.repeatUntil = repeatUntil;
	}

}
