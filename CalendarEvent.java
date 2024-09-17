

import java.util.GregorianCalendar;

import calendar.MeetingCalendar;

public abstract class CalendarEvent
{
	private String description;
	private String location;
	private GregorianCalendar startTime;
	private GregorianCalendar endTime;
	
	public CalendarEvent(String desc, String loc, GregorianCalendar start, GregorianCalendar end)
	{
		description = desc;
		location = loc;
		startTime = start;
		endTime = end;
	}
	
	public abstract void scheduleEvent(MeetingCalendar cal);
	
	
	public GregorianCalendar getEndTime()
	{
		return endTime;
	}

	public void setEndTime(GregorianCalendar endTime)
	{
		this.endTime = endTime;
	}

	public GregorianCalendar getStartTime() 
	{
		return startTime;
	}

	public void setStartTime(GregorianCalendar startTime) 
	{
		this.startTime = startTime;
	}

	public String getLocation() 
	{
		return location;
	}

	public void setLocation(String location) 
	{
		this.location = location;
	}

	public String getDescription() 
	{
		return description;
	}

	public void setDescription(String description) 
	{
		this.description = description;
	}

}
