

# Chat Application

<p align="center">
  <img src="https://github.com/younusFoysal/HR-Hub-Pro-Server/blob/main/images/chat.png" alt="Chat Application">
</p>
<br>

## Overview
This is a simple online chat application built in Java using socket programming. The application allows multiple clients to connect to a central server, send messages, and receive messages in real time. It is implemented with a text-based user interface.



## Features
### **Server Implementation**:
  - Manages client connections.
  - Assigns a unique user ID to each connected client.
  - Broadcasts messages to all connected clients.

### **Client Implementation**:
  - Connects to the server via sockets.
  - Sends and receives messages.
  - Displays a text-based user interface for interaction.



## Requirements
- **Java Development Kit (JDK)** version 18 or higher.
- An IDE such as Eclipse or a terminal with `javac` and `java` commands available.



## How to Run

### 1. Clone or Download the Repository
- Place all files (`ChatServer.java` and `ChatClient.java`) in the appropriate package directories (`server` and `client`).

### 2. Compile the Code
Using the terminal:
```bash
cd D:\eclipse-workspace\ChatApplication\src
javac -d ../bin server/ChatServer.java client/ChatClient.java
```



### 3. Run the Server
1. Navigate to the `bin` directory:
   ```bash
   cd D:\eclipse-workspace\ChatApplication\bin
   ```
2. Start the server:
   ```bash
   java server.ChatServer
   ```
3. The server will display messages when clients connect or send messages.



### 4. Run the Clients
1. Open another terminal or console.
2. Navigate to the same `bin` directory:
   ```bash
   cd D:\eclipse-workspace\ChatApplication\bin
   ```
3. Start a client instance:
   ```bash
   java client.ChatClient
   ```
4. Repeat the above step to launch multiple clients.



## Usage
1. After starting the server, each client will connect and receive a unique ID.
2. Clients can type messages in their terminal, and the server will broadcast the messages to all connected clients.
3. To exit a client, close the terminal or terminate the program.



## Implementation Details

### Server
- The `ChatServer` class:
  - Uses a `ServerSocket` to listen for client connections.
  - Maintains a list of connected clients using a `HashMap`.
  - Broadcasts messages received from one client to all others.

### Client
- The `ChatClient` class:
  - Connects to the server using a `Socket`.
  - Sends messages typed by the user to the server.
  - Listens for messages from the server and displays them on the terminal.

### User Interface
- Simple text-based UI:
  - Clients input messages through the terminal.
  - Messages are displayed in the format: `[UserID]: Message`.



## Example Output

### Server Console
```
Server started. Waiting for clients...
Client connected: User 1
Client connected: User 2
[User 1]: Hello, everyone!
[User 2]: Hi, User 1!
```

### Client Console
**Client 1:**
```
Connected to the server. Your User ID is User 1.
Hi, User 2!
```

**Client 2:**
```
Connected to the server. Your User ID is User 2.
Hello, User 1!
```

---

## Notes
- Ensure the server is running before starting any clients.
- To avoid version issues, ensure your JDK and JRE are compatible.

