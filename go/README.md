# Due Date Calculator API - Go Client

Due Date Calculator estimates pregnancy due dates using either last menstrual period or conception date, providing comprehensive pregnancy timeline information.

![Build Status](https://img.shields.io/badge/build-passing-green)
![Code Climate](https://img.shields.io/badge/maintainability-B-purple)
![Prod Ready](https://img.shields.io/badge/production-ready-blue)

This is a Go client for the [Due Date Calculator API](https://apiverve.com/marketplace/duedatecalculator?utm_source=go&utm_medium=readme)

---

## Installation

```bash
go get github.com/apiverve/duedatecalculator-api/go
```

---

## Configuration

Before using the Due Date Calculator API client, you need to obtain your API key.
You can get it by signing up at [https://apiverve.com](https://apiverve.com?utm_source=go&utm_medium=readme)

---

## Quick Start

[Get started with the Quick Start Guide](https://docs.apiverve.com/quickstart?utm_source=go&utm_medium=readme)

The Due Date Calculator API documentation is found here: [https://docs.apiverve.com/ref/duedatecalculator](https://docs.apiverve.com/ref/duedatecalculator?utm_source=go&utm_medium=readme)

---

## Usage

```go
package main

import (
    "fmt"
    "log"

    "github.com/apiverve/duedatecalculator-api/go"
)

func main() {
    // Create a new client
    client := duedatecalculator.NewClient("YOUR_API_KEY")

    // Set up parameters
    params := map[string]interface{}{
        "last_period": "2024-01-01"
    }

    // Make the request
    response, err := client.Execute(params)
    if err != nil {
        log.Fatal(err)
    }

    fmt.Printf("Status: %s\n", response.Status)
    fmt.Printf("Data: %+v\n", response.Data)
}
```

---

## Example Response

```json
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

Need any assistance? [Get in touch with Customer Support](https://apiverve.com/contact?utm_source=go&utm_medium=readme).

---

## Updates

Stay up to date by following [@apiverveHQ](https://twitter.com/apiverveHQ) on Twitter.

---

## Legal

All usage of the APIVerve website, API, and services is subject to the [APIVerve Terms of Service](https://apiverve.com/terms?utm_source=go&utm_medium=readme), [Privacy Policy](https://apiverve.com/privacy?utm_source=go&utm_medium=readme), and [Refund Policy](https://apiverve.com/refund?utm_source=go&utm_medium=readme).

---

## License
Licensed under the The MIT License (MIT)

Copyright (&copy;) 2026 APIVerve, and EvlarSoft LLC

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
