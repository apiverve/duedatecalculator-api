using System;
using System.Collections.Generic;
using System.Text;
using Newtonsoft.Json;

namespace APIVerve.API.DueDateCalculator
{
    /// <summary>
    /// Query options for the Due Date Calculator API
    /// </summary>
    public class DueDateCalculatorQueryOptions
    {
        /// <summary>
        /// First day of last menstrual period (YYYY-MM-DD)
        /// </summary>
        [JsonProperty("last_period")]
        public string Last_period { get; set; }
    }
}
