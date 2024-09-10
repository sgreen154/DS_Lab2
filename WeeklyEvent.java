package calendar;

import java.util.GregorianCalendar;

public class WeeklyEvent extends CalendarEvent 
{
	private GregorianCalendar repeatUntil;
	
	public WeeklyEvent(String desc, String loc, GregorianCalendar start, GregorianCalendar end, GregorianCalendar repeat) {
		super(desc, loc, start, end);
		setRepeatUntil(repeat);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void scheduleEvent(MeetingCalendar cal) {
		// TODO Auto-generated method stub

	}

	public GregorianCalendar getRepeatUntil() {
		return repeatUntil;
	}

	public void setRepeatUntil(GregorianCalendar repeatUntil) {
		this.repeatUntil = repeatUntil;
	}

}
