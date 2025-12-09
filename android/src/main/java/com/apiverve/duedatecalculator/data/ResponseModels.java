// Converter.java

// To use this code, add the following Maven dependency to your project:
//
//
//     com.fasterxml.jackson.core     : jackson-databind          : 2.9.0
//     com.fasterxml.jackson.datatype : jackson-datatype-jsr310   : 2.9.0
//
// Import this package:
//
//     import com.apiverve.data.Converter;
//
// Then you can deserialize a JSON string with
//
//     DueDateCalculatorData data = Converter.fromJsonString(jsonString);

package com.apiverve.duedatecalculator.data;

import java.io.IOException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.*;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

public class Converter {
    // Date-time helpers

    private static final DateTimeFormatter DATE_TIME_FORMATTER = new DateTimeFormatterBuilder()
            .appendOptional(DateTimeFormatter.ISO_DATE_TIME)
            .appendOptional(DateTimeFormatter.ISO_OFFSET_DATE_TIME)
            .appendOptional(DateTimeFormatter.ISO_INSTANT)
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SX"))
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ssX"))
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
            .toFormatter()
            .withZone(ZoneOffset.UTC);

    public static OffsetDateTime parseDateTimeString(String str) {
        return ZonedDateTime.from(Converter.DATE_TIME_FORMATTER.parse(str)).toOffsetDateTime();
    }

    private static final DateTimeFormatter TIME_FORMATTER = new DateTimeFormatterBuilder()
            .appendOptional(DateTimeFormatter.ISO_TIME)
            .appendOptional(DateTimeFormatter.ISO_OFFSET_TIME)
            .parseDefaulting(ChronoField.YEAR, 2020)
            .parseDefaulting(ChronoField.MONTH_OF_YEAR, 1)
            .parseDefaulting(ChronoField.DAY_OF_MONTH, 1)
            .toFormatter()
            .withZone(ZoneOffset.UTC);

    public static OffsetTime parseTimeString(String str) {
        return ZonedDateTime.from(Converter.TIME_FORMATTER.parse(str)).toOffsetDateTime().toOffsetTime();
    }
    // Serialize/deserialize helpers

    public static DueDateCalculatorData fromJsonString(String json) throws IOException {
        return getObjectReader().readValue(json);
    }

    public static String toJsonString(DueDateCalculatorData obj) throws JsonProcessingException {
        return getObjectWriter().writeValueAsString(obj);
    }

    private static ObjectReader reader;
    private static ObjectWriter writer;

    private static void instantiateMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        SimpleModule module = new SimpleModule();
        module.addDeserializer(OffsetDateTime.class, new JsonDeserializer<OffsetDateTime>() {
            @Override
            public OffsetDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
                String value = jsonParser.getText();
                return Converter.parseDateTimeString(value);
            }
        });
        mapper.registerModule(module);
        reader = mapper.readerFor(DueDateCalculatorData.class);
        writer = mapper.writerFor(DueDateCalculatorData.class);
    }

    private static ObjectReader getObjectReader() {
        if (reader == null) instantiateMapper();
        return reader;
    }

    private static ObjectWriter getObjectWriter() {
        if (writer == null) instantiateMapper();
        return writer;
    }
}

// DueDateCalculatorData.java

package com.apiverve.duedatecalculator.data;

import com.fasterxml.jackson.annotation.*;
import java.time.LocalDate;

public class DueDateCalculatorData {
    private String calculationMethod;
    private LocalDate lastPeriodDate;
    private LocalDate estimatedConceptionDate;
    private LocalDate dueDate;
    private CurrentProgress currentProgress;
    private TimeUntilDue timeUntilDue;
    private Object[] upcomingMilestones;
    private ImportantDates importantDates;
    private String disclaimer;

    @JsonProperty("calculation_method")
    public String getCalculationMethod() { return calculationMethod; }
    @JsonProperty("calculation_method")
    public void setCalculationMethod(String value) { this.calculationMethod = value; }

    @JsonProperty("last_period_date")
    public LocalDate getLastPeriodDate() { return lastPeriodDate; }
    @JsonProperty("last_period_date")
    public void setLastPeriodDate(LocalDate value) { this.lastPeriodDate = value; }

    @JsonProperty("estimated_conception_date")
    public LocalDate getEstimatedConceptionDate() { return estimatedConceptionDate; }
    @JsonProperty("estimated_conception_date")
    public void setEstimatedConceptionDate(LocalDate value) { this.estimatedConceptionDate = value; }

    @JsonProperty("due_date")
    public LocalDate getDueDate() { return dueDate; }
    @JsonProperty("due_date")
    public void setDueDate(LocalDate value) { this.dueDate = value; }

    @JsonProperty("current_progress")
    public CurrentProgress getCurrentProgress() { return currentProgress; }
    @JsonProperty("current_progress")
    public void setCurrentProgress(CurrentProgress value) { this.currentProgress = value; }

    @JsonProperty("time_until_due")
    public TimeUntilDue getTimeUntilDue() { return timeUntilDue; }
    @JsonProperty("time_until_due")
    public void setTimeUntilDue(TimeUntilDue value) { this.timeUntilDue = value; }

    @JsonProperty("upcoming_milestones")
    public Object[] getUpcomingMilestones() { return upcomingMilestones; }
    @JsonProperty("upcoming_milestones")
    public void setUpcomingMilestones(Object[] value) { this.upcomingMilestones = value; }

    @JsonProperty("important_dates")
    public ImportantDates getImportantDates() { return importantDates; }
    @JsonProperty("important_dates")
    public void setImportantDates(ImportantDates value) { this.importantDates = value; }

    @JsonProperty("disclaimer")
    public String getDisclaimer() { return disclaimer; }
    @JsonProperty("disclaimer")
    public void setDisclaimer(String value) { this.disclaimer = value; }
}

// CurrentProgress.java

package com.apiverve.duedatecalculator.data;

import com.fasterxml.jackson.annotation.*;

public class CurrentProgress {
    private long daysPregnant;
    private long weeksPregnant;
    private long daysIntoWeek;
    private String formatted;
    private long trimester;
    private double percentageComplete;

    @JsonProperty("days_pregnant")
    public long getDaysPregnant() { return daysPregnant; }
    @JsonProperty("days_pregnant")
    public void setDaysPregnant(long value) { this.daysPregnant = value; }

    @JsonProperty("weeks_pregnant")
    public long getWeeksPregnant() { return weeksPregnant; }
    @JsonProperty("weeks_pregnant")
    public void setWeeksPregnant(long value) { this.weeksPregnant = value; }

    @JsonProperty("days_into_week")
    public long getDaysIntoWeek() { return daysIntoWeek; }
    @JsonProperty("days_into_week")
    public void setDaysIntoWeek(long value) { this.daysIntoWeek = value; }

    @JsonProperty("formatted")
    public String getFormatted() { return formatted; }
    @JsonProperty("formatted")
    public void setFormatted(String value) { this.formatted = value; }

    @JsonProperty("trimester")
    public long getTrimester() { return trimester; }
    @JsonProperty("trimester")
    public void setTrimester(long value) { this.trimester = value; }

    @JsonProperty("percentage_complete")
    public double getPercentageComplete() { return percentageComplete; }
    @JsonProperty("percentage_complete")
    public void setPercentageComplete(double value) { this.percentageComplete = value; }
}

// ImportantDates.java

package com.apiverve.duedatecalculator.data;

import com.fasterxml.jackson.annotation.*;
import java.time.LocalDate;

public class ImportantDates {
    private LocalDate endFirstTrimester;
    private LocalDate endSecondTrimester;
    private LocalDate fullTermBegins;

    @JsonProperty("end_first_trimester")
    public LocalDate getEndFirstTrimester() { return endFirstTrimester; }
    @JsonProperty("end_first_trimester")
    public void setEndFirstTrimester(LocalDate value) { this.endFirstTrimester = value; }

    @JsonProperty("end_second_trimester")
    public LocalDate getEndSecondTrimester() { return endSecondTrimester; }
    @JsonProperty("end_second_trimester")
    public void setEndSecondTrimester(LocalDate value) { this.endSecondTrimester = value; }

    @JsonProperty("full_term_begins")
    public LocalDate getFullTermBegins() { return fullTermBegins; }
    @JsonProperty("full_term_begins")
    public void setFullTermBegins(LocalDate value) { this.fullTermBegins = value; }
}

// TimeUntilDue.java

package com.apiverve.duedatecalculator.data;

import com.fasterxml.jackson.annotation.*;

public class TimeUntilDue {
    private long days;
    private long weeks;
    private long daysExtra;
    private String formatted;
    private boolean isOverdue;

    @JsonProperty("days")
    public long getDays() { return days; }
    @JsonProperty("days")
    public void setDays(long value) { this.days = value; }

    @JsonProperty("weeks")
    public long getWeeks() { return weeks; }
    @JsonProperty("weeks")
    public void setWeeks(long value) { this.weeks = value; }

    @JsonProperty("days_extra")
    public long getDaysExtra() { return daysExtra; }
    @JsonProperty("days_extra")
    public void setDaysExtra(long value) { this.daysExtra = value; }

    @JsonProperty("formatted")
    public String getFormatted() { return formatted; }
    @JsonProperty("formatted")
    public void setFormatted(String value) { this.formatted = value; }

    @JsonProperty("is_overdue")
    public boolean getIsOverdue() { return isOverdue; }
    @JsonProperty("is_overdue")
    public void setIsOverdue(boolean value) { this.isOverdue = value; }
}