import static org.junit.jupiter.api.Assertions.*;

import java.util.GregorianCalendar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import calendar.MeetingCalendar;

class CalendarEventTest 
{
	MeetingCalendar cal = new MeetingCalendar();
	MultiDayPerWeekEvent m;
	MultiDayPerWeekEvent m1;
	OneTimeEvent o;
	OneTimeEvent o1;
	PriorityEvent p;
	PriorityEvent p1;
	WeeklyEvent w;
	WeeklyEvent w1;
	GregorianCalendar startm = new GregorianCalendar(2023,8,1,8,30);
	GregorianCalendar endm = new GregorianCalendar(2023,8,1,9,30);
	GregorianCalendar repeatm = new GregorianCalendar(2023,8,8);
	GregorianCalendar starto = new GregorianCalendar(2023,8,29,10,30);
	GregorianCalendar endo = new GregorianCalendar(2023,8,29,11,30);
	GregorianCalendar startp = new GregorianCalendar(2023,8,30,9,30);
	GregorianCalendar endp = new GregorianCalendar(2023,8,30,10,30);
	GregorianCalendar startw = new GregorianCalendar(2023,9,1,1,30);
	GregorianCalendar endw = new GregorianCalendar(2023,9,1,2,30);
	GregorianCalendar repeatw = new GregorianCalendar(2023,9,14);
	GregorianCalendar startw1 = new GregorianCalendar(2023,9,8,1,30);
	GregorianCalendar startwFalse = new GregorianCalendar(2023,9,15,1,30);
	GregorianCalendar startMulti1 = new GregorianCalendar(2023,8,8,9,30);
	GregorianCalendar startFalse1 = new GregorianCalendar(2023,8,2,8,30);
	GregorianCalendar startFalse2 = new GregorianCalendar(2023,8,3,8,30);
	GregorianCalendar startFalse3 = new GregorianCalendar(2023,8,4,8,30);
	GregorianCalendar startFalse4 = new GregorianCalendar(2023,8,5,8,30);
	GregorianCalendar startFalse5 = new GregorianCalendar(2023,8,6,8,30);
	GregorianCalendar startFalse6 = new GregorianCalendar(2023,8,7,8,30);
	GregorianCalendar startFalse7 = new GregorianCalendar(2023,8,9,8,30);
	
	GregorianCalendar starto1 = new GregorianCalendar(2023,8,29,11,45);
	GregorianCalendar endo1 = new GregorianCalendar(2023,8,29,12,45);
	
	OneTimeEvent oFalsew = new OneTimeEvent("Mfalse", "Lfalse", startwFalse, startwFalse);
	
	OneTimeEvent oFalse1 = new OneTimeEvent("Mfalse", "Lfalse", startFalse1, startFalse1);
	OneTimeEvent oFalse2 = new OneTimeEvent("Mfalse", "Lfalse", startFalse2, startFalse2);
	OneTimeEvent oFalse3 = new OneTimeEvent("Mfalse", "Lfalse", startFalse3, startFalse3);
	OneTimeEvent oFalse4 = new OneTimeEvent("Mfalse", "Lfalse", startFalse4, startFalse4);
	OneTimeEvent oFalse5 = new OneTimeEvent("Mfalse", "Lfalse", startFalse5, startFalse5);
	OneTimeEvent oFalse6 = new OneTimeEvent("Mfalse", "Lfalse", startFalse6, startFalse6);
	OneTimeEvent oFalse7 = new OneTimeEvent("Mfalse", "Lfalse", startFalse7, startFalse7);
	
	int daysm[] = {6};
	
	
	@BeforeEach
	void setUp() throws Exception 
	{
		o = new OneTimeEvent("Mo", "Lo", starto, endo);
		m = new MultiDayPerWeekEvent("Mm", "Lm", startm, endm, repeatm, daysm);
		w = new WeeklyEvent("Mw", "Lw", startw, endw, repeatw);
		p = new PriorityEvent("Mp", "Lp", startp, endp);
	}

	@Test
	void testOneTimeEvent() 
	{
	    assertEquals("Mo", o.getDescription());
		assertEquals("Lo", o.getLocation());
		assertEquals(starto, o.getStartTime());
		assertEquals(endo, o.getEndTime());
		
		o.scheduleEvent(cal);
		
		o1 = new OneTimeEvent("Mo1", "Lo1", starto, endo);
		
		o1.scheduleEvent(cal);
		
		assertEquals(o.getDescription(), cal.findMeeting(starto).getDescription());
	}
	
	@Test
	void testWeeklyEvent()
	{
		assertEquals("Mw", w.getDescription());
		assertEquals("Lw", w.getLocation());
		assertEquals(startw, w.getStartTime());
		assertEquals(endw, w.getEndTime());
		assertEquals(repeatw, w.getRepeatUntil());
		
		w1 = new WeeklyEvent("Mw1", "Lw1", startw, endw, repeatw);
		
		
		
		w.scheduleEvent(cal);
		w1.scheduleEvent(cal);
		oFalsew.scheduleEvent(cal);
		
		assertEquals(w.getDescription(), cal.findMeeting(startw).getDescription());
		assertEquals(w.getDescription(), cal.findMeeting(startw1).getDescription());
		assertFalse(cal.doesMeetingConflict(cal.findMeeting(startwFalse)));
	}

    @Test
	void testMultiDayPerWeekEvent()
	{
		assertEquals("Mm", m.getDescription());
		assertEquals("Lm", m.getLocation());
		assertEquals(startm, m.getStartTime());
		assertEquals(endm, m.getEndTime());
		assertEquals(repeatm, m.getRepeatUntil());
		assertArrayEquals(daysm, m.getDays());
		
		m1 = new MultiDayPerWeekEvent("Mm1", "Lm1", startm, endm, repeatm, daysm);
	
		
		
		m.scheduleEvent(cal);
		m1.scheduleEvent(cal);
		oFalse1.scheduleEvent(cal);
		oFalse2.scheduleEvent(cal);
		oFalse3.scheduleEvent(cal);
		oFalse4.scheduleEvent(cal);
		oFalse5.scheduleEvent(cal);
		oFalse6.scheduleEvent(cal);
		oFalse7.scheduleEvent(cal);
		
		assertEquals(m.getDescription(), cal.findMeeting(startm).getDescription());
		
		assertFalse(cal.doesMeetingConflict(cal.findMeeting(startFalse1)));
		assertFalse(cal.doesMeetingConflict(cal.findMeeting(startFalse2)));
		assertFalse(cal.doesMeetingConflict(cal.findMeeting(startFalse3)));
		assertFalse(cal.doesMeetingConflict(cal.findMeeting(startFalse4)));
		assertFalse(cal.doesMeetingConflict(cal.findMeeting(startFalse5)));
		assertFalse(cal.doesMeetingConflict(cal.findMeeting(startFalse6)));
		assertFalse(cal.doesMeetingConflict(cal.findMeeting(startFalse7)));
	}
	
	@Test
	void testPriorityEvent()
	{
		assertEquals("Mp", p.getDescription());
		assertEquals("Lp", p.getLocation());
		assertEquals(startp, p.getStartTime());
		assertEquals(endp, p.getEndTime());
		
		p1 = new PriorityEvent("Mp1", "Lp1", startp, endp);
		
		p.scheduleEvent(cal);
		p1.scheduleEvent(cal);
		
		assertEquals(p1.getDescription(), cal.findMeeting(startp).getDescription());
		
	}
	
}
