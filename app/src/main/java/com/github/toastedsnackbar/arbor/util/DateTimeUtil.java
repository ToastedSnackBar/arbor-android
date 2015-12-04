package com.github.toastedsnackbar.arbor.util;

import android.content.Context;

import com.github.toastedsnackbar.arbor.R;
import com.github.toastedsnackbar.arbor.net.ApiEndpoints;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class DateTimeUtil {

    public static String getEventTimeStamp(String createdAtString, long obtainedAt,
                                           Context context) {
        try {
            DateFormat formatCreatedAt = new SimpleDateFormat(ApiEndpoints.SERVER_TIME_FORMAT,
                    Locale.CANADA);
            long createdAt = formatCreatedAt.parse(createdAtString).getTime();

            long diff = obtainedAt - createdAt;
            long diffDays = diff / (24 * 60 * 60 * 1000);
            long diffHours = diff / (60 * 60 * 1000) % 24;
            long diffMinutes = diff / (60 * 1000) % 60;
            long diffSeconds = diff / 1000 % 60;

            long greatestDiff;
            int greatestDiffUnitResId;
            if (diffDays > 0) {
                greatestDiff = diffDays;
                greatestDiffUnitResId = R.string.days;
            } else if (diffHours > 0) {
                greatestDiff = diffHours;
                greatestDiffUnitResId = R.string.hours;
            } else if (diffMinutes > 0) {
                greatestDiff = diffMinutes;
                greatestDiffUnitResId = R.string.minutes;
            } else {
                greatestDiff = diffSeconds;
                greatestDiffUnitResId = R.string.seconds;
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
