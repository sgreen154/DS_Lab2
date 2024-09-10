package calendar;

import java.util.GregorianCalendar;

public class MultiDayPerWeekEvent extends CalendarEvent 
{
	private GregorianCalendar repeatUntil;
	private int [] days;
	
	public MultiDayPerWeekEvent(String desc, String loc, GregorianCalendar start, GregorianCalendar end, GregorianCalendar repeat, int[] day) {
		super(desc, loc, start, end);
		repeatUntil = repeat;
		days = day;
		
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void scheduleEvent(MeetingCalendar cal) 
	{
		// TODO Auto-generated method stub

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
