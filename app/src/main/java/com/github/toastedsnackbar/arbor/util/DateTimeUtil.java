package com.github.toastedsnackbar.arbor.util;

import android.content.Context;

import com.github.toastedsnackbar.arbor.R;
import com.github.toastedsnackbar.arbor.net.ApiEndpoints;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;

public class DateTimeUtil {

    public static String getEventTimeStamp(String createdAtString, long obtainedAt,
                                           Context context) {
        try {
            DateFormat formatCreatedAt = new SimpleDateFormat(ApiEndpoints.SERVER_TIME_FORMAT,
                    Locale.CANADA);
            formatCreatedAt.setTimeZone(TimeZone.getTimeZone("UTC"));
            long createdAt = formatCreatedAt.parse(createdAtString).getTime();

            long diff = obtainedAt - createdAt;
            long diffMonths = diff / (4L * 7L * 24L * 60L * 60L * 1000L);
            long diffWeeks = diff / (7L * 24L * 60L * 60L * 1000L) % 4;
            long diffDays = diff / (24L * 60L * 60L * 1000L) % 7;
            long diffHours = diff / (60L * 60L * 1000L) % 24;
            long diffMinutes = diff / (60L * 1000L) % 60;

            long greatestDiff;
            int greatestDiffUnitResId;

            if (diffMonths > 0) {
                greatestDiff = diffMonths;
                greatestDiffUnitResId = diffMonths > 1 ? R.string.months : R.string.month;
            } else if (diffWeeks > 0) {
                greatestDiff = diffWeeks;
                greatestDiffUnitResId = diffWeeks > 1 ? R.string.weeks : R.string.week;
            } else if (diffDays > 0) {
                greatestDiff = diffDays;
                greatestDiffUnitResId = diffDays > 1 ? R.string.days : R.string.day;
            } else if (diffHours > 0) {
                greatestDiff = diffHours;
                greatestDiffUnitResId = diffHours > 1 ? R.string.hours : R.string.hour;
            } else {
                greatestDiff = diffMinutes;
                greatestDiffUnitResId = diffMinutes > 1 ? R.string.minutes : R.string.minute;
            }

            String greatestDiffString = String.valueOf(greatestDiff);
            String greatestDiffUnitString = context.getString(greatestDiffUnitResId);
            String agoString = context.getString(R.string.ago);

            return String.format("%s %s %s", greatestDiffString, greatestDiffUnitString, agoString);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return "";
    }
}
