/// Response models for the Due Date Calculator API.

/// API Response wrapper.
class DuedatecalculatorResponse {
  final String status;
  final dynamic error;
  final DuedatecalculatorData? data;

  DuedatecalculatorResponse({
    required this.status,
    this.error,
    this.data,
  });

  factory DuedatecalculatorResponse.fromJson(Map<String, dynamic> json) => DuedatecalculatorResponse(
    status: json['status'] as String? ?? '',
    error: json['error'],
    data: json['data'] != null ? DuedatecalculatorData.fromJson(json['data']) : null,
  );

  Map<String, dynamic> toJson() => {
    'status': status,
    if (error != null) 'error': error,
    if (data != null) 'data': data,
  };
}

/// Response data for the Due Date Calculator API.

class DuedatecalculatorData {
  String? calculationMethod;
  String? lastPeriodDate;
  String? estimatedConceptionDate;
  String? dueDate;
  DuedatecalculatorDataCurrentProgress? currentProgress;
  DuedatecalculatorDataTimeUntilDue? timeUntilDue;
  List<dynamic>? upcomingMilestones;
  DuedatecalculatorDataImportantDates? importantDates;
  String? disclaimer;

  DuedatecalculatorData({
    this.calculationMethod,
    this.lastPeriodDate,
    this.estimatedConceptionDate,
    this.dueDate,
    this.currentProgress,
    this.timeUntilDue,
    this.upcomingMilestones,
    this.importantDates,
    this.disclaimer,
  });

  factory DuedatecalculatorData.fromJson(Map<String, dynamic> json) => DuedatecalculatorData(
      calculationMethod: json['calculation_method'],
      lastPeriodDate: json['last_period_date'],
      estimatedConceptionDate: json['estimated_conception_date'],
      dueDate: json['due_date'],
      currentProgress: json['current_progress'] != null ? DuedatecalculatorDataCurrentProgress.fromJson(json['current_progress']) : null,
      timeUntilDue: json['time_until_due'] != null ? DuedatecalculatorDataTimeUntilDue.fromJson(json['time_until_due']) : null,
      upcomingMilestones: (json['upcoming_milestones'] as List?)?.cast<dynamic>(),
      importantDates: json['important_dates'] != null ? DuedatecalculatorDataImportantDates.fromJson(json['important_dates']) : null,
      disclaimer: json['disclaimer'],
    );
}

class DuedatecalculatorDataCurrentProgress {
  int? daysPregnant;
  int? weeksPregnant;
  int? daysIntoWeek;
  String? formatted;
  int? trimester;
  double? percentageComplete;

  DuedatecalculatorDataCurrentProgress({
    this.daysPregnant,
    this.weeksPregnant,
    this.daysIntoWeek,
    this.formatted,
    this.trimester,
    this.percentageComplete,
  });

  factory DuedatecalculatorDataCurrentProgress.fromJson(Map<String, dynamic> json) => DuedatecalculatorDataCurrentProgress(
      daysPregnant: json['days_pregnant'],
      weeksPregnant: json['weeks_pregnant'],
      daysIntoWeek: json['days_into_week'],
      formatted: json['formatted'],
      trimester: json['trimester'],
      percentageComplete: json['percentage_complete'],
    );
}

class DuedatecalculatorDataTimeUntilDue {
  int? days;
  int? weeks;
  int? daysExtra;
  String? formatted;
  bool? isOverdue;

  DuedatecalculatorDataTimeUntilDue({
    this.days,
    this.weeks,
    this.daysExtra,
    this.formatted,
    this.isOverdue,
  });

  factory DuedatecalculatorDataTimeUntilDue.fromJson(Map<String, dynamic> json) => DuedatecalculatorDataTimeUntilDue(
      days: json['days'],
      weeks: json['weeks'],
      daysExtra: json['days_extra'],
      formatted: json['formatted'],
      isOverdue: json['is_overdue'],
    );
}

class DuedatecalculatorDataImportantDates {
  String? endFirstTrimester;
  String? endSecondTrimester;
  String? fullTermBegins;

  DuedatecalculatorDataImportantDates({
    this.endFirstTrimester,
    this.endSecondTrimester,
    this.fullTermBegins,
  });

  factory DuedatecalculatorDataImportantDates.fromJson(Map<String, dynamic> json) => DuedatecalculatorDataImportantDates(
      endFirstTrimester: json['end_first_trimester'],
      endSecondTrimester: json['end_second_trimester'],
      fullTermBegins: json['full_term_begins'],
    );
}

class DuedatecalculatorRequest {
  String lastPeriod;

  DuedatecalculatorRequest({
    required this.lastPeriod,
  });

  Map<String, dynamic> toJson() => {
      'last_period': lastPeriod,
    };
}
