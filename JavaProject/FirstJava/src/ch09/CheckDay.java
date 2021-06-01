package ch09;

import java.util.Calendar;

public class CheckDay {

	public static void main(String[] args) {

		Calendar game_start_calendar = Calendar.getInstance();
		game_start_calendar.set(2021, 1 - 1, 4, 0, 0, 0);

		Calendar now_calendar = Calendar.getInstance();

		System.out.println(game_start_calendar.getTime());
		System.out.println(now_calendar.getTime());

		System.out.println(now_calendar.getTimeInMillis() - game_start_calendar.getTimeInMillis());

		long remainLong = now_calendar.getTimeInMillis() - game_start_calendar.getTimeInMillis();
		long days = remainLong / (1000L * 60 * 60 * 24);
		System.out.println(days + " 일이 지났습니다.");

	}

}