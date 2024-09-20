# FGC La Pobla line: Favorite Journeys

The domain of the application is the public transportation (Ferrocarrils de la Generalitat de Catalunya - Catalan Trains) and their users.
Its aim is to give some complementary services around FGC lines.

Exercises in for this project consist in doing queries to the database using JPA, JPQL and Spring Data JPA. 


JPA
* Journey id
* ManyToOne avoiding onetomany
* OneToMany only when it's actually OneToFew

## Classes in the domain:
* User
* Station (name and position)
* Journey (consists of two stations: the origin and the destination. Both stations must be different)
* DayTimeStart (consists of a dayOfWeek and a start time, both represented as strings)
* FavoriteJourney (a journey that a user travels frequently and the moment he uses it: consists of a Journey and a list of DayTimeStart)
* Friend (a user, existing as a user in the system, that declares who are her friends. The later ara just string names that don't need to be in the system).
See also, that a user cannot have the same friend twice.

## JPA associations:
You already have the JPA associations in the domain classes. You can check them in the domain package. In general, we avoid using OneToMany associations because they are not efficient in the database.
We use ManyToOne associations instead. We only use OneToMany associations when it's actually a OneToFew.

For example a User has a list of FavoriteJourneys but the association is implemented as a ManyToOne in the FavoriteJourney class. Note that the
list of FavoriteJourneys in the User class is not annotated with OneToMany, it has @Transient annotation to tell JPA that it's not an association 
to be stored in the database.

Note that when a domain class has a composed id (for exemple, Journey and Fried), the Id should be implemented as an Embeddable class.

## Http calls to the application Api Rest
You have examples of all the endpoints of the application in the files 'callsXxx.http'. You can use them to test the application. 
When using these files, you are actually using the IntelliJ IDEA HTTP client. 

Alternatively, you can use the OpenApi (Swagger) documentation of the application. You can access it by typing the following URL in your browser:
http://localhost:8080/swagger-ui.html

## The queries you should implement
See the TODOs in the service classes ot the application to know the queries you should implement.

There are queries where you are asked to return domain objects and others where you are asked to return DTOs both as interfaces and as records.
Each kind of return types (domain objects, interfaces and records) has its own advantages. However, domain objects never should be returned to the client.

