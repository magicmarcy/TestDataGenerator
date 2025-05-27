> [!CAUTION]
> WORK IN PROGRESS: This project is not yet functional

# TestDataGenerator
This libary can be used to create various test data for testing purposes. It can generate random data such as names, addresses, phone numbers, and more. The generated data can be used for testing applications, databases, or any other purpose where random data is needed.


## How to use

### Birthdate Generator
With the Birthdate Generator you can create random birthdates. The default range is 18 to 90 years, but you can specify a custom range.

**Create a random birthdate between 18 and 90 years:**
```java
final Birthdate randomBirthdate = Birthdate.builder().buildOne();
```

**Create a random birthdate between 40 and 50 years:**
```java
final Birthdate randomBirthdate = Birthdate.builder().minAge(40).maxAge(50).buildOne();
```

**You can also create a list of random birthdates:**
```java
final List<Birthdate> randomBirthdates = Birthdate.builder().build(10);
```
