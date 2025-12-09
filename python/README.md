Due Date Calculator API
============

Due Date Calculator estimates pregnancy due dates using either last menstrual period or conception date, providing comprehensive pregnancy timeline information.

![Build Status](https://img.shields.io/badge/build-passing-green)
![Code Climate](https://img.shields.io/badge/maintainability-B-purple)
![Prod Ready](https://img.shields.io/badge/production-ready-blue)

This is a Python API Wrapper for the [Due Date Calculator API](https://apiverve.com/marketplace/api/duedatecalculator)

---

## Installation
	pip install apiverve-duedatecalculator

---

## Configuration

Before using the duedatecalculator API client, you have to setup your account and obtain your API Key.  
You can get it by signing up at [https://apiverve.com](https://apiverve.com)

---

## Usage

The Due Date Calculator API documentation is found here: [https://docs.apiverve.com/api/duedatecalculator](https://docs.apiverve.com/api/duedatecalculator).  
You can find parameters, example responses, and status codes documented here.

### Setup

```
# Import the client module
from apiverve_duedatecalculator.apiClient import DuedatecalculatorAPIClient

# Initialize the client with your APIVerve API key
api = DuedatecalculatorAPIClient("[YOUR_API_KEY]")
```

---


### Perform Request
Using the API client, you can perform requests to the API.

###### Define Query

```
query = { "method": "last_period", "last_period": "2024-01-01", "conception_date": "2024-01-15" }
```

###### Simple Request

```
# Make a request to the API
result = api.execute(query)

# Print the result
print(result)
```

###### Example Response

```
{
  "status": "ok",
  "error": null,
  "data": {
    "calculation_method": "last_period",
    "last_period_date": "2024-01-01",
    "estimated_conception_date": "2024-01-15",
    "due_date": "2024-10-07",
    "current_progress": {
      "days_pregnant": 688,
      "weeks_pregnant": 98,
      "days_into_week": 2,
      "formatted": "98 weeks, 2 days",
      "trimester": 3,
      "percentage_complete": 245.71
    },
    "time_until_due": {
      "days": 0,
      "weeks": 0,
      "days_extra": 0,
      "formatted": "Past due date",
      "is_overdue": true
    },
    "upcoming_milestones": [],
    "important_dates": {
      "end_first_trimester": "2024-04-01",
      "end_second_trimester": "2024-07-08",
      "full_term_begins": "2024-09-16"
    },
    "disclaimer": "This is an estimate only. Due dates can vary. Consult your healthcare provider for medical advice."
  }
}
```

---

## Customer Support

Need any assistance? [Get in touch with Customer Support](https://apiverve.com/contact).

---

## Updates
Stay up to date by following [@apiverveHQ](https://twitter.com/apiverveHQ) on Twitter.

---

## Legal

All usage of the APIVerve website, API, and services is subject to the [APIVerve Terms of Service](https://apiverve.com/terms) and all legal documents and agreements.

---

## License
Licensed under the The MIT License (MIT)

Copyright (&copy;) 2025 APIVerve, and EvlarSoft LLC

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.