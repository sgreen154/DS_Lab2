

import java.util.Calendar;
import java.util.GregorianCalendar;

import calendar.Meeting;
import calendar.MeetingCalendar;

public class MultiDayPerWeekEvent extends CalendarEvent 
{
	private GregorianCalendar repeatUntil;
	private int [] days;
	
	public MultiDayPerWeekEvent(String desc, String loc, GregorianCalendar start, GregorianCalendar end, GregorianCalendar repeat, int[] day) {
		super(desc, loc, start, end);
		repeatUntil = repeat;
		days = day;
	}
	
	@Override
	public void scheduleEvent(MeetingCalendar cal) 
	{
		Meeting multi = new Meeting(getDescription(), getLocation(), getStartTime(), getEndTime());
		GregorianCalendar multiStart = getStartTime();
		GregorianCalendar multiEnd = getEndTime();
		GregorianCalendar multiFinal = getRepeatUntil();
		int days[] = getDays();
		int l = days.length;
		boolean week[] = {false, false, false, false, false, false, false};
		for(int i = 0; i < l; i++)
		{
			
		}
		multiStart.setFirstDayOfWeek(0);
		int cont = 0;
		boolean timeOver = false;
		while(timeOver == false)
		{
			
			cont = multiStart.compareTo(multiFinal);
			if(cont > 0)
			{
				timeOver = true;
				return;
				
			}
			else
			{
				multi.setStartTime(multiStart);
				multi.setEndTime(multiEnd);
				cal.addMeeting(multi);
				multiStart.set(Calendar.DAY_OF_WEEK, days[i]);
				multiEnd.set(Calendar.DAY_OF_WEEK, days[i]);
				i++;
				if(i >= l)
				{
					i = 0;
				}
			}
		}
		return;

	}

	public GregorianCalendar getRepeatUntil() {
		return repeatUntil;
	}

	public void setRepeatUntil(GregorianCalendar repeatUntil) {
		this.repeatUntil = repeatUntil;
	}

	public int [] getDays() {
		return days;
	}

	public void setDays(int [] days) {
		this.days = days;
	}

}
