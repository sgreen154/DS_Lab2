

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
		GregorianCalendar multiStart = (GregorianCalendar) getStartTime().clone();
		GregorianCalendar multiEnd = (GregorianCalendar) getEndTime().clone();
		GregorianCalendar multiFinal = getRepeatUntil();
		int days[] = getDays();
		int l = days.length;
		boolean start = false;
		boolean week[] = {false, false, false, false, false, false, false};
		for(int i = 0; i < l; i++)
		{
			week[days[i]] = true;
		}
		while(true)
		{
			if(multiStart.compareTo(multiFinal) > 0)
			{
				return;
			}
			if(multiStart.get(Calendar.DAY_OF_WEEK) == 0)
			{
				if(week[0] == true)
				{
					start = true;
					multi.setStartTime(multiStart);
					multi.setEndTime(multiEnd);
					cal.addMeeting(multi);
				}
			}
			if(start == true)
			{
				multiStart.add(Calendar.DAY_OF_MONTH, 1);
				multiEnd.add(Calendar.DAY_OF_MONTH, 1);
			}
			if(multiStart.compareTo(multiFinal) > 0)
			{
				return;
			}
			if(multiStart.get(Calendar.DAY_OF_WEEK) == 1)
			{
				if(week[1] == true)
				{
					start = true;
					multi.setStartTime(multiStart);
					multi.setEndTime(multiEnd);
					cal.addMeeting(multi);
				}
			}
			if(start == true)
			{
				multiStart.add(Calendar.DAY_OF_MONTH, 1);
				multiEnd.add(Calendar.DAY_OF_MONTH, 1);
			}
			if(multiStart.compareTo(multiFinal) > 0)
			{
				return;
			}
			if(multiStart.get(Calendar.DAY_OF_WEEK) == 2)
			{
				if(week[2] == true)
				{
					start = true;
					multi.setStartTime(multiStart);
					multi.setEndTime(multiEnd);
					cal.addMeeting(multi);
				}
			}
			if(start == true)
			{
				multiStart.add(Calendar.DAY_OF_MONTH, 1);
				multiEnd.add(Calendar.DAY_OF_MONTH, 1);
			}
			
			if(multiStart.compareTo(multiFinal) > 0)
			{
				return;
			}
			if(multiStart.get(Calendar.DAY_OF_WEEK) == 3)
			{
				if(week[3] == true)
				{
					start = true;
					multi.setStartTime(multiStart);
					multi.setEndTime(multiEnd);
					cal.addMeeting(multi);
				}
			}
			if(start == true)
			{
				multiStart.add(Calendar.DAY_OF_MONTH, 1);
				multiEnd.add(Calendar.DAY_OF_MONTH, 1);
			}
			
			if(multiStart.compareTo(multiFinal) > 0)
			{
				return;
			}
			if(multiStart.get(Calendar.DAY_OF_WEEK) == 4)
			{
				if(week[4] == true)
				{
					start = true;
					multi.setStartTime(multiStart);
					multi.setEndTime(multiEnd);
					cal.addMeeting(multi);
				}
			}
			if(start == true)
			{
				multiStart.add(Calendar.DAY_OF_MONTH, 1);
				multiEnd.add(Calendar.DAY_OF_MONTH, 1);
			}
			
			if(multiStart.compareTo(multiFinal) > 0)
			{
				return;
			}
			if(multiStart.get(Calendar.DAY_OF_WEEK) == 5)
			{
				if(week[5] == true)
				{
					start = true;
					multi.setStartTime(multiStart);
					multi.setEndTime(multiEnd);
					cal.addMeeting(multi);
				}
			}
			if(start == true)
			{
				multiStart.add(Calendar.DAY_OF_MONTH, 1);
				multiEnd.add(Calendar.DAY_OF_MONTH, 1);
			}
			
			if(multiStart.compareTo(multiFinal) > 0)
			{
				return;
			}
			if(multiStart.get(Calendar.DAY_OF_WEEK) == 6)
			{
				if(week[6] == true)
				{
					start = true;
					multi.setStartTime(multiStart);
					multi.setEndTime(multiEnd);
					cal.addMeeting(multi);
				}
			}
			if(start == true)
			{
				multiStart.add(Calendar.DAY_OF_MONTH, 1);
				multiEnd.add(Calendar.DAY_OF_MONTH, 1);
			}
		}
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
