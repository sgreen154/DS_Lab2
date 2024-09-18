

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
		GregorianCalendar weeklyStart = (GregorianCalendar) getStartTime().clone();
		GregorianCalendar weeklyEnd = (GregorianCalendar) getEndTime().clone();
		GregorianCalendar weeklyFinal = getRepeatUntil();
		while(weeklyStart.compareTo(weeklyFinal) <= 0)
		{
				weekly.setStartTime(weeklyStart);
				weekly.setEndTime(weeklyEnd);
				cal.addMeeting(weekly);
				weeklyStart.add(Calendar.DAY_OF_MONTH, 7);
				weeklyEnd.add(Calendar.DAY_OF_MONTH, 7);
		}
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
