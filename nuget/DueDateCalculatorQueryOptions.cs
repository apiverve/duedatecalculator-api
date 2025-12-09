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
        /// Calculation method (last_period or conception_date)
        /// Example: last_period
        /// </summary>
        [JsonProperty("method")]
        public string Method { get; set; }

        /// <summary>
        /// First day of last period (YYYY-MM-DD) - for last_period method
        /// Example: 2024-01-01
        /// </summary>
        [JsonProperty("last_period")]
        public string Last_period { get; set; }

        /// <summary>
        /// Conception date (YYYY-MM-DD) - for conception_date method
        /// Example: 2024-01-15
        /// </summary>
        [JsonProperty("conception_date")]
        public string Conception_date { get; set; }
    }
}
