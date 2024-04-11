How to setup and run code
Created an API that supports the requirements
1. Install Gradle: Ensure that you have Gradle installed on your system. You can download and install Gradle from the official website.
2. Open the Project in an IDE: Open the project in your preferred Integrated Development Environment (IDE) such as IntelliJ IDEA, Eclipse, or Visual Studio Code.
3. Configure the Database: The application is configured to use PostgreSQL as the database. Ensure that you have PostgreSQL installed and running on your system.
   Create a database with the appropriate credentials as specified in the application.properties file.
4. Build the Project: Open a terminal or command prompt, navigate to the root directory of the project, and run the following command to build the project: gradlew build
   This command will download dependencies, compile the code, and build the project.
5. Access the Application: Once the application is running, you can access it using a web browser or a tool like Postman. By default, the application will be accessible at http://localhost:8080.
6. Ooverview of the RESTful endpoints exposed by the application:

User Authentication Endpoints:

POST /api/v1/auth/register: Register a new user.
POST /api/v1/auth/login: Authenticate a user and generate a JWT token.

Train Management Endpoints:

POST /api/v1/train/add: Add a new train to the system. (Requires ADMIN role)
PUT /api/v1/train/{trainId}/seats: Update the total number of seats in a train. (Requires ADMIN role)

Train Booking Endpoints:

POST /api/v1/train/book: Book a train by providing source, destination, number of seats, and traveler name.
GET /api/v1/train/book/{bookingId}: Retrieve booking details by booking ID.


User Management Endpoints:

GET /api/v1/user/profile: Retrieve the profile of the currently authenticated user.
PUT /api/v1/user/password: Change the password of the currently authenticated user.




