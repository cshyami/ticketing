Walmart Coding Assignment

Shyamala C : 05/31/2018
**************************
Assumptions:
1. The venue is split into multiple zones (eg: Orchestra, Mezzanine, Balcony)
2. Each zone has a different ticket price, with the best seating associated with a higher price
3. For simplicity, seat numbers are not allotted

**************************
The ticketing service implements the following features:
1. Ability to get the number of available seats
2. Ability to get the number of available seats in a zone
3. A customer can request a specific number of seats, in which case the service selects the seats from best zone first
4. A customer can request a specific number of seats in a specific zone
5. If the number of available seats are not available in any zone, a message is displayed asking user to select lesser number of seats
6. If the number of available seats are lesser than the number of seats requested in a zone, a message is displayed asking user to select a different zone
7. If the seats are available, the customer can hold the seats for the next 60 secs, where the seats are put on 'HOLD' status
8. Any holds past the 60 sec duration are cleared and the seats' status are set back to 'AVAILABLE'
9. Customer can confirm a hold within 60 secs, in which case the seat status are marked as 'RESERVED' for that customer

**************************
Architecture:

Entities:
1. Venue
2. Zone
3. Seat
2. SeatStatus
3. SeatHold
4. User

Repositories:
1. ZoneRepository
2. UserRepository
3. SeatRepository
4. SeatHoldRepository

Service:
1. TicketService Interface
2. TicketServiceImplementation

***************************

Features Not Implemented:
1. Test cases : Since I am not familiar with the Java testing frameworks such as JUnit, I had issues Autowiring the service for the unit tests. So the testing portion
is incomplete

****************************
GitHub: https://github.com/cshyami/ticketing

Steps to run:
1. Clone the project: git clone https://github.com/cshyami/ticketing
2. Navigate to the directory to the project
3. mvn clean package -DskipTests
4. Navigate to target directory
5. Run the Spring Boot App: java -jar ticketing-0.0.1-SNAPSHOT.jar

