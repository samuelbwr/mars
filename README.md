# mars
A Robot that's going to explore Mars ground.

To run tests and build the project just do
<code>
mvn clean install
</code>

The Robot always start at the position <code>["0", "0", "N"]</code> and receives the command throught a REST interface to move according to instructions.

A exemple of a command is 
<code>
curl --request POST http://localhost:8080/rest/mars/MMRMML
</code>

After the command the robot will be positioned at <code>["2", "2", "N"]</code>

But if the robot is instructed to do a invalid move or receives a invalid command the service returns the code 400, as follows:

<code>
curl -is --request POST http://localhost:8080/rest/mars/I
</code>

Response:
<code>
HTTP/1.1 400 Bad Request
</code>
