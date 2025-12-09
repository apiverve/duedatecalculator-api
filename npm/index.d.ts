declare module '@apiverve/duedatecalculator' {
  export interface duedatecalculatorOptions {
    api_key: string;
    secure?: boolean;
  }

  export interface duedatecalculatorResponse {
    status: string;
    error: string | null;
    data: DueDateCalculatorData;
    code?: number;
  }


  interface DueDateCalculatorData {
      calculationMethod:       string;
      lastPeriodDate:          Date;
      estimatedConceptionDate: Date;
      dueDate:                 Date;
      currentProgress:         CurrentProgress;
      timeUntilDue:            TimeUntilDue;
      upcomingMilestones:      any[];
      importantDates:          ImportantDates;
      disclaimer:              string;
  }
  
  interface CurrentProgress {
      daysPregnant:       number;
      weeksPregnant:      number;
      daysIntoWeek:       number;
      formatted:          string;
      trimester:          number;
      percentageComplete: number;
  }
  
  interface ImportantDates {
      endFirstTrimester:  Date;
      endSecondTrimester: Date;
      fullTermBegins:     Date;
  }
  
  interface TimeUntilDue {
      days:      number;
      weeks:     number;
      daysExtra: number;
      formatted: string;
      isOverdue: boolean;
  }

  export default class duedatecalculatorWrapper {
    constructor(options: duedatecalculatorOptions);

    execute(callback: (error: any, data: duedatecalculatorResponse | null) => void): Promise<duedatecalculatorResponse>;
    execute(query: Record<string, any>, callback: (error: any, data: duedatecalculatorResponse | null) => void): Promise<duedatecalculatorResponse>;
    execute(query?: Record<string, any>): Promise<duedatecalculatorResponse>;
  }
}
