package TRJavaHWs.lesson24;

public class CustomDateTime {
    private final int dayOfMonth;
    private final Month month;
    private final int year;
    private final int hour;
    private final int minute;
    private final int seconds;
    private final int secondsInYear = 86400 * 365;
    private final int secondsInLeapYear = 86400 * 366;
    private int leapYears;
    private int currentDay;
    private int currentHour;
    private int currentMin;
    private int currenSec;


    public CustomDateTime(long unixTimeStamp) {
        if (unixTimeStamp < 0) {
            throw new RuntimeException("Only positive");
        }

        year = calculateYear(unixTimeStamp);
        month = calculateMonth(unixTimeStamp);
        dayOfMonth = calculateDay(unixTimeStamp);
        hour = calculateHour(unixTimeStamp);
        minute = calculateMin(unixTimeStamp);
        seconds = calculateSec(unixTimeStamp);

    }

    private int calculateYear(long unixTimeStamp) {
        long seconds = unixTimeStamp / 1000;
        long wholeYears = (seconds / secondsInYear);
        for (int i = 0; i < wholeYears; i++) {
            if (isLeap(1970 + i)) {
                leapYears++;
            }
        }
        int spareDaysInSecs = 86400 * leapYears;
        long secondsWOLeap = seconds - spareDaysInSecs;
        wholeYears = 1970 + secondsWOLeap / secondsInYear;

        return (int) wholeYears;

    }

    private boolean isLeap(int y) {
        return (y) % 400 == 0 ||
                (y) % 100 != 0 &&
                        (y) % 4 == 0;
    }

    private Month calculateMonth(long unixTimeStamp) {
        long seconds = unixTimeStamp / 1000;
        long secsOfYear = (long) (year - 1970) * secondsInYear + leapYears * 86400L;
        currentDay = (int) ((seconds - secsOfYear) / 86400) + 1;
        if (isLeap(year)) {
            if (currentDay < 32) {
                return Month.JANUARY;
            } else if (currentDay < 61) {
                return Month.FEBRUARY_LEAP;
            } else if (currentDay < 92) {
                return Month.MARCH;
            } else if (currentDay < 122) {
                return Month.APRIL;
            } else if (currentDay < 153) {
                return Month.MAY;
            } else if (currentDay < 183) {
                return Month.JUNE;
            } else if (currentDay < 214) {
                return Month.JULY;
            } else if (currentDay < 245) {
                return Month.AUGUST;
            } else if (currentDay < 275) {
                return Month.SEPTEMBER;
            } else if (currentDay < 306) {
                return Month.OCTOBER;
            } else if (currentDay < 336) {
                return Month.NOVEMBER;
            } else if (currentDay < 367) {
                return Month.DECEMBER;
            }
        } else {
            if (currentDay < 32) {
                return Month.JANUARY;
            } else if (currentDay < 60) {
                return Month.FEBRUARY;
            } else if (currentDay < 91) {
                return Month.MARCH;
            } else if (currentDay < 121) {
                return Month.APRIL;
            } else if (currentDay < 152) {
                return Month.MAY;
            } else if (currentDay < 182) {
                return Month.JUNE;
            } else if (currentDay < 213) {
                return Month.JULY;
            } else if (currentDay < 244) {
                return Month.AUGUST;
            } else if (currentDay < 274) {
                return Month.SEPTEMBER;
            } else if (currentDay < 305) {
                return Month.OCTOBER;
            } else if (currentDay < 335) {
                return Month.NOVEMBER;
            } else if (currentDay < 366) {
                return Month.DECEMBER;
            }
        }
        throw new RuntimeException();
    }

    private int calculateDay(long unixTimeStamp) {
        int dayOfMonth = currentDay + 1;
        if (dayOfMonth - Month.JANUARY.daysInMonth > 0) {
            dayOfMonth = dayOfMonth - Month.JANUARY.daysInMonth;
        } else return dayOfMonth;
        if ((isLeap(year) && (dayOfMonth - Month.FEBRUARY_LEAP.daysInMonth > 0))) {
            dayOfMonth = dayOfMonth - Month.FEBRUARY_LEAP.daysInMonth;
        } else if ((!isLeap(year) && (dayOfMonth - Month.FEBRUARY.daysInMonth > 0))) {
            dayOfMonth = dayOfMonth - Month.FEBRUARY_LEAP.daysInMonth;
        } else return dayOfMonth;
        if (dayOfMonth - Month.MARCH.daysInMonth > 0) {
            dayOfMonth = dayOfMonth - Month.MARCH.daysInMonth;
        } else return dayOfMonth;
        if (dayOfMonth - Month.APRIL.daysInMonth > 0) {
            dayOfMonth = dayOfMonth - Month.APRIL.daysInMonth;
        } else return dayOfMonth;
        if (dayOfMonth - Month.MAY.daysInMonth > 0) {
            dayOfMonth = dayOfMonth - Month.MAY.daysInMonth;
        } else return dayOfMonth;
        if (dayOfMonth - Month.JUNE.daysInMonth > 0) {
            dayOfMonth = dayOfMonth - Month.JUNE.daysInMonth;
        } else return dayOfMonth;
        if (dayOfMonth - Month.JULY.daysInMonth > 0) {
            dayOfMonth = dayOfMonth - Month.JULY.daysInMonth;
        } else return dayOfMonth;
        if (dayOfMonth - Month.AUGUST.daysInMonth > 0) {
            dayOfMonth = dayOfMonth - Month.AUGUST.daysInMonth;
        } else return dayOfMonth;
        if (dayOfMonth - Month.SEPTEMBER.daysInMonth > 0) {
            dayOfMonth = dayOfMonth - Month.SEPTEMBER.daysInMonth;
        } else return dayOfMonth;
        if (dayOfMonth - Month.OCTOBER.daysInMonth > 0) {
            dayOfMonth = dayOfMonth - Month.OCTOBER.daysInMonth;
        } else return dayOfMonth;
        if (dayOfMonth - Month.NOVEMBER.daysInMonth > 0) {
            dayOfMonth = dayOfMonth - Month.NOVEMBER.daysInMonth;
        } else return dayOfMonth;
        if (dayOfMonth - Month.DECEMBER.daysInMonth > 0) {
            dayOfMonth = dayOfMonth - Month.DECEMBER.daysInMonth;
        } else return dayOfMonth;

        throw new RuntimeException();
    }

    private int calculateHour(long unixTimeStamp) {
        long seconds = unixTimeStamp / 1000;
        long secsOfYear = (long) (year - 1970) * secondsInYear + leapYears * 86400L;
        currentHour = (int) (((seconds - secsOfYear) % 86400) / 3600) + 1;

        return currentHour;

    }

    private int calculateMin(long unixTimeStamp) {
        long seconds = unixTimeStamp / 1000;
        long secsOfYear = (long) (year - 1970) * secondsInYear + leapYears * 86400L;
        currentMin = (int) (((seconds - secsOfYear) % 86400) / 60 % 60);

        return currentMin;

    }

    private int calculateSec(long unixTimeStamp) {
        long seconds = unixTimeStamp / 1000;
        long secsOfYear = (long) (year - 1970) * secondsInYear + leapYears * 86400L;
        currenSec = (int) (((seconds - secsOfYear) % 86400) % 3600 %60);

        return currenSec;

    }


    public int getDayOfMonth() {
        return dayOfMonth;
    }

    public Month getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getSeconds() {
        return seconds;
    }

    public boolean isBefore(CustomDateTime t) {
        return false;
    }

    public boolean isAfter(CustomDateTime t) {
        return false;
    }

    public enum Month {
        JANUARY(31), FEBRUARY(28), FEBRUARY_LEAP(29), MARCH(31), APRIL(30),
        MAY(31), JUNE(30), JULY(31), AUGUST(31),
        SEPTEMBER(30), OCTOBER(31), NOVEMBER(30), DECEMBER(31);

        int daysInMonth;

        Month(int daysInMonth) {
            this.daysInMonth = daysInMonth;
        }
    }

    @Override
    public String toString() {
        return dayOfMonth + " " + month + " " + year + " " + hour + ":" + minute + ":" + seconds;

    }
}
