# Due Date Calculator API - Dart/Flutter Client

Due Date Calculator estimates pregnancy due dates using either last menstrual period or conception date, providing comprehensive pregnancy timeline information.

[![pub package](https://img.shields.io/pub/v/apiverve_duedatecalculator.svg)](https://pub.dev/packages/apiverve_duedatecalculator)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

This is the Dart/Flutter client for the [Due Date Calculator API](https://apiverve.com/marketplace/duedatecalculator?utm_source=dart&utm_medium=readme).

## Installation

Add this to your `pubspec.yaml`:

```yaml
dependencies:
  apiverve_duedatecalculator: ^1.1.14
```

Then run:

```bash
dart pub get
# or for Flutter
flutter pub get
```

## Usage

```dart
import 'package:apiverve_duedatecalculator/apiverve_duedatecalculator.dart';

void main() async {
  final client = DuedatecalculatorClient('YOUR_API_KEY');

  try {
    final response = await client.execute({
      'last_period': '2024-01-01'
    });

    print('Status: ${response.status}');
    print('Data: ${response.data}');
  } catch (e) {
    print('Error: $e');
  }
}
```

## Response

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

## API Reference

- **API Home:** [Due Date Calculator API](https://apiverve.com/marketplace/duedatecalculator?utm_source=dart&utm_medium=readme)
- **Documentation:** [docs.apiverve.com/ref/duedatecalculator](https://docs.apiverve.com/ref/duedatecalculator?utm_source=dart&utm_medium=readme)

## Authentication

All requests require an API key. Get yours at [apiverve.com](https://apiverve.com?utm_source=dart&utm_medium=readme).

## License

MIT License - see [LICENSE](LICENSE) for details.

---

Built with Dart for [APIVerve](https://apiverve.com?utm_source=dart&utm_medium=readme)
