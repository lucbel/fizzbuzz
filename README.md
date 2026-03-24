# FizzBuzz API

A Spring Boot REST API that exposes a classic FizzBuzz endpoint and tracks endpoint usage statistics.

---

## Requirements

- Java 21
- Maven

## Run the application

```bash
./mvnw spring-boot:run
```

The server starts on `http://localhost:8080`.

---

## Endpoints

### GET /v1/fizzbuzz

Runs the FizzBuzz algorithm from `1` to `limit`. Each number is replaced by:
- `str1` if divisible by `int1`
- `str2` if divisible by `int2`
- `str1 + str2` if divisible by both
- the number itself otherwise

The result is returned as a comma-separated string.

**Query parameters**

| Parameter | Type   | Description                        |
|-----------|--------|------------------------------------|
| `int1`    | int    | First divisor                      |
| `int2`    | int    | Second divisor                     |
| `limit`   | int    | Upper bound of the sequence        |
| `str1`    | string | Replacement for multiples of `int1` |
| `str2`    | string | Replacement for multiples of `int2` |

**Example request**

```
GET /v1/fizzbuzz?int1=3&int2=5&limit=15&str1=fizz&str2=buzz
```

**Example response** `200 OK`

```
1,2,fizz,4,buzz,fizz,7,8,fizz,buzz,11,fizz,13,14,fizzbuzz
```

---

### GET /v1/statistics/most-used-endpoint

Returns the most called endpoint, identified by the unique combination of URL and query parameters.

**No parameters required.**

**Example request**

```
GET /v1/statistics/most-used-endpoint
```

**Example response** `200 OK`

```json
{
  "url": "/v1/fizzbuzz",
  "params": "int1=3&int2=5&limit=15&str1=fizz&str2=buzz",
  "count": 42
}
```

**Response** `204 No Content` — returned when no endpoint has been called yet.

---

## How usage tracking works

Every request is intercepted by a filter that records the URL and query parameters into an in-memory H2 database. Each unique combination of URL + parameters is identified by an MD5 hash and counted. The `/v1/statistics/most-used-endpoint` endpoint queries that table to return the most frequently called combination.
