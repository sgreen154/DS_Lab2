package calendar;

import java.util.GregorianCalendar;

public class OneTimeEvent extends CalendarEvent
{
	public OneTimeEvent(String desc, String loc, GregorianCalendar start, GregorianCalendar end) 
	{
		super(desc, loc, start, end);
	}
	
	@Override
	public void scheduleEvent(MeetingCalendar cal)
	{
		// TODO Auto-generated method stub
		
	}

}
