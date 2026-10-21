# Due Date Calculator API - Ruby Gem

Due Date Calculator estimates pregnancy due dates using either last menstrual period or conception date, providing comprehensive pregnancy timeline information.

## Installation

Add this line to your application's Gemfile:

```ruby
gem 'apiverve_duedatecalculator'
```

And then execute:

```bash
$ bundle install
```

Or install it yourself as:

```bash
$ gem install apiverve_duedatecalculator
```

## Getting Started

Get your API key at [APIVerve](https://apiverve.com)

### Basic Usage

```ruby
require 'apiverve_duedatecalculator'

# Initialize the client
client = APIVerve::Duedatecalculator::Client.new(api_key: "YOUR_API_KEY")

# Make a request
response = client.execute({ last_period: "2025-06-01" })

# Print the response
puts response
```


### Error Handling

```ruby
begin
  response = client.execute({ last_period: "2025-06-01" })
  puts response["data"]
rescue APIVerve::Duedatecalculator::ValidationError => e
  puts "Validation error: #{e.errors.join(', ')}"
rescue APIVerve::Duedatecalculator::APIError => e
  puts "API error: #{e.message}"
  puts "Status code: #{e.status_code}"
end
```

### Debug Mode

```ruby
# Enable debug logging
client = APIVerve::Duedatecalculator::Client.new(
  api_key: "YOUR_API_KEY",
  debug: true
)
```

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
      "days_pregnant": 715,
      "weeks_pregnant": 102,
      "days_into_week": 1,
      "formatted": "102 weeks, 1 days",
      "trimester": 3,
      "percentage_complete": 255.36
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

## Documentation

For more information, visit the [API Documentation](https://docs.apiverve.com/ref/duedatecalculator?utm_source=rubygems&utm_medium=referral&utm_content=readme).

## Support

- Website: [https://apiverve.com/marketplace/duedatecalculator?utm_source=ruby&utm_medium=referral&utm_content=readme](https://apiverve.com/marketplace/duedatecalculator?utm_source=ruby&utm_medium=referral&utm_content=readme)
- Email: hello@apiverve.com

## License

This gem is available under the [MIT License](LICENSE).
