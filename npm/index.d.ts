declare module '@apiverve/duedatecalculator' {
  export interface duedatecalculatorOptions {
    api_key: string;
    secure?: boolean;
  }

  /**
   * Describes fields the current plan does not unlock. Locked fields arrive as null
   * in `data`; `locked_fields` names them, using dot paths for nested fields.
   * Absent when the plan unlocks everything.
   */
  export interface PremiumInfo {
    message: string;
    upgrade_url: string;
    locked_fields: string[];
  }

  export interface duedatecalculatorResponse {
    status: string;
    error: string | null;
    data: DueDateCalculatorData;
    code?: number;
    premium?: PremiumInfo;
  }


  interface DueDateCalculatorData {
      calculationMethod:       null | string;
      lastPeriodDate:          Date | null;
      estimatedConceptionDate: Date | null;
      dueDate:                 Date | null;
      currentProgress:         CurrentProgress;
      timeUntilDue:            TimeUntilDue;
      upcomingMilestones:      any[];
      importantDates:          ImportantDates;
      disclaimer:              null | string;
  }
  
  interface CurrentProgress {
      daysPregnant:       number | null;
      weeksPregnant:      number | null;
      daysIntoWeek:       number | null;
      formatted:          null | string;
      trimester:          number | null;
      percentageComplete: number | null;
  }
  
  interface ImportantDates {
      endFirstTrimester:  Date | null;
      endSecondTrimester: Date | null;
      fullTermBegins:     Date | null;
  }
  
  interface TimeUntilDue {
      days:      number | null;
      weeks:     number | null;
      daysExtra: number | null;
      formatted: null | string;
      isOverdue: boolean | null;
  }

  export default class duedatecalculatorWrapper {
    constructor(options: duedatecalculatorOptions);

    execute(callback: (error: any, data: duedatecalculatorResponse | null) => void): Promise<duedatecalculatorResponse>;
    execute(query: Record<string, any>, callback: (error: any, data: duedatecalculatorResponse | null) => void): Promise<duedatecalculatorResponse>;
    execute(query?: Record<string, any>): Promise<duedatecalculatorResponse>;
  }
}
