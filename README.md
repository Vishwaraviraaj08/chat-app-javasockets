# chat-app-javasockets
JAVA client - client  ChatApplication 

ChatServer is a Java program that provides a simple chat functionality between two clients. It uses sockets to establish connections with clients and allows them to exchange messages with each other.

The program listens for incoming connections on port 8008 and accepts connections from two clients. Once connected, it creates input and output streams for each client, which allow them to send and receive messages.

The program uses an infinite loop to continuously read messages from each client's input stream. When it receives a message from one client, it prints the message to the console and sends it to the other client via their output stream. This way, the clients can chat with each other in real-time.

The program is designed to handle any errors that may occur during its execution, and it gracefully closes all connections once the chat session is complete.

This code can be useful for creating a basic chat application or as a starting point for more advanced chat applications that require additional features such as user authentication or encryption.






