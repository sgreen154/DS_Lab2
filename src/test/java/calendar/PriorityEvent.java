

import java.util.GregorianCalendar;

import calendar.Meeting;
import calendar.MeetingCalendar;

public class PriorityEvent extends CalendarEvent 
{

	public PriorityEvent(String desc, String loc, GregorianCalendar start, GregorianCalendar end) 
	{
		super(desc, loc, start, end);
	}

	public void scheduleEvent(MeetingCalendar cal) 
	{
		Meeting priority = new Meeting(getDescription(), getLocation(), getStartTime(), getEndTime());
		cal.addMeeting(priority, true);
		return;
	}

}
