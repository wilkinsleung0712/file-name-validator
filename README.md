<!-- ABOUT THE PROJECT -->
## About The Project

### Built With
* [Gradle](https://gradle.org/)
* [Java](https://java.com/)

<!-- GETTING STARTED -->
## Getting Started

<!-- GETTING STARTED -->
### Build

```agsl
./gradlew clean build
```

### Test
```agsl
./gradlew test
```
###

## Usage
### Demo
As a showcase of the application, run below command from terminal, application will ask user to input `./src/main/resources`. This has been setup as test data according to the document
```agsl
./gradlew -q --console plain run

Enter absolute directory path : ./src/main/resources
File ‘Test_A_07121987.txt’ failed validation. Invalid File format.Expected ‘csv’ found ‘txt’
File ‘Test_A_13121987.csv’ passed validation.
File ‘Test.txt’ failed validation. File format should be ‘Test_<portfoliocode>_<ddmmyyyy>_<2digit-sequencenumber>.csv’
File ‘Test_A_07121987_123.csv’ failed validation. SequenceNumber for the file should be only 2 digits found ‘123’
File ‘Test_A_07121987_11.csv’ passed validation.
File ‘Test_A_07121987.csv’ passed validation.
File ‘Test_E_07121987.csv’ failed validation. PortfolioCode should be A/B/C found E
File ‘Hello_A_07121987.csv’ failed validation. Prefix for the file should be ‘Test’ found ‘Hello’
File ‘Test_A_07121987_dd.csv’ failed validation. SequenceNumber for the file should be only 2 digits found ‘dd’

```

## Assumption

1. Assuming `SequenceNumber` matching is optional. Since there are no example giving with `SequenceNumber`. The application will handle cases with/without `SequenceNumber` in the file location.
2. Assuming application will be enhanced with various validation in the future, so introduce OOP from fileName, and also put in individual validator for different fields.
3. Assuming we will process the validation for each fileName in an order. e.g. validate prefix, and extension first, then validate portfolio code.
4. Assuming `ddmmyyyy` format will be passed for test data `Test_A_13121987.csv`, since `13121987` is actually a valid date. However, in the exercise this was mentioned as failed.
5. Assuming user will using a `Mac like environment`, otherwise we can enhanced by using container technology like docker.
6. Assuming user will run with `gradle` command