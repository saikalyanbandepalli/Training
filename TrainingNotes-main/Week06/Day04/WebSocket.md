WebSockets provide a full-duplex communication channel over a single TCP connection, allowing for real-time data transfer between a client and server. Here's an overview of WebSockets, including their purpose, how they work, and their key features:

### What are WebSockets?

WebSockets are a protocol that enables bidirectional communication between a client (usually a web browser) and a server. Unlike traditional HTTP requests, which are initiated by the client and involve a request-response pattern, WebSockets allow either the client or the server to send messages to each other at any time.

### Key Features

1. **Full-Duplex Communication**: Both the client and server can send messages independently and simultaneously.
2. **Persistent Connection**: Once established, the connection remains open, reducing the overhead of opening and closing connections repeatedly.
3. **Low Latency**: Ideal for applications requiring real-time updates, such as chat applications, live sports scores, financial tickers, and multiplayer games.
4. **Efficiency**: Reduces the overhead of HTTP headers, resulting in faster communication.

### How WebSockets Work

1. **Handshake**: The WebSocket protocol starts with an HTTP handshake. The client sends an HTTP request to the server requesting an upgrade to the WebSocket protocol. If the server supports WebSockets, it responds with an HTTP 101 status code, upgrading the connection from HTTP to WebSocket.
   
   **Client Request:**
   ```http
   GET /chat HTTP/1.1
   Host: example.com
   Upgrade: websocket
   Connection: Upgrade
   Sec-WebSocket-Key: dGhlIHNhbXBsZSBub25jZQ==
   Sec-WebSocket-Version: 13
   ```

   **Server Response:**
   ```http
   HTTP/1.1 101 Switching Protocols
   Upgrade: websocket
   Connection: Upgrade
   Sec-WebSocket-Accept: s3pPLMBiTxaQ9kYGzzhZRbK+xOo=
   ```

2. **Data Frames**: After the connection is established, data is transmitted in the form of frames. WebSocket frames can be of different types, such as text frames, binary frames, close frames, ping frames, and pong frames.
   
   **Frame Structure:**
   - **FIN**: Indicates if the frame is the final fragment.
   - **Opcode**: Defines the frame type (e.g., text, binary, close, ping, pong).
   - **Mask**: Indicates if the payload data is masked.
   - **Payload Length**: Length of the payload data.
   - **Payload Data**: The actual message data.

3. **Closing the Connection**: Either the client or the server can close the connection by sending a close frame. The other party must respond with a close frame, after which the connection is terminated.

### Use Cases

1. **Chat Applications**: WebSockets allow real-time messaging between users.
2. **Real-Time Notifications**: Applications can push notifications to users in real-time.
3. **Online Gaming**: Multiplayer games can use WebSockets for real-time interaction.
4. **Live Data Feeds**: Stock tickers, sports scores, and other live data can be updated in real-time.
5. **Collaborative Tools**: Tools like online document editors and whiteboards can use WebSockets for real-time collaboration.

### WebSocket vs. HTTP Polling

- **HTTP Polling**: The client repeatedly sends HTTP requests to the server at regular intervals to check for updates. This can lead to increased latency and higher bandwidth usage due to the overhead of HTTP headers in each request and response.
- **WebSockets**: The client and server maintain a single open connection, allowing for instant communication without the overhead of repeatedly opening and closing connections.


### Step 1: Set Up Your Spring Boot Application

First, create a new Spring Boot project using Spring Initializr (https://start.spring.io/), and include the following dependencies:
- Spring Web
- WebSocket
- Spring Boot DevTools (optional, for development purposes)
- Spring Security (if you need security)

### Step 2: Add Dependencies to `pom.xml`

Add the necessary dependencies to your `pom.xml`:

```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-websocket</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-security</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter</artifactId>
    </dependency>
</dependencies>
```

### Step 3: Configure WebSocket with STOMP

Create a WebSocket configuration class to set up WebSocket with STOMP.

```java
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/topic", "/queue");
        config.setApplicationDestinationPrefixes("/app");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws").withSockJS();
    }
}
```

### Step 4: Create a Message Controller

Create a controller to handle messages sent to the WebSocket.

```java
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public String greeting(String message) throws Exception {
        return "Hello, " + message + "!";
    }
}
```

### Step 5: Create the Frontend

Create an HTML file to interact with the WebSocket.

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>WebSocket with STOMP</title>
    <script src="https://cdn.jsdelivr.net/npm/sockjs-client@1.5.0/dist/sockjs.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/stompjs@2.3.3/lib/stomp.min.js"></script>
    <script>
        var stompClient = null;

        function connect() {
            var socket = new SockJS('/ws');
            stompClient = Stomp.over(socket);
            stompClient.connect({}, function (frame) {
                console.log('Connected: ' + frame);
                stompClient.subscribe('/topic/greetings', function (greeting) {
                    showGreeting(greeting.body);
                });
            });
        }

        function disconnect() {
            if (stompClient !== null) {
                stompClient.disconnect();
            }
            console.log("Disconnected");
        }

        function sendName() {
            var name = document.getElementById('name').value;
            stompClient.send("/app/hello", {}, name);
        }

        function showGreeting(message) {
            var response = document.getElementById('response');
            var p = document.createElement('p');
            p.appendChild(document.createTextNode(message));
            response.appendChild(p);
        }
    </script>
</head>
<body>
    <div>
        <input type="text" id="name" placeholder="Your name"/>
        <button onclick="connect()">Connect</button>
        <button onclick="disconnect()">Disconnect</button>
        <button onclick="sendName()">Send</button>
    </div>
    <div id="response"></div>
</body>
</html>
```

### Step 6: Run the Application

Run your Spring Boot application and open the HTML file in a browser. You should be able to connect to the WebSocket, send a message, and receive a response.

### Optional: Add Security (if needed)

If you need to add security, you can configure it in a security configuration class.

```java
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/").permitAll()
                .anyRequest().authenticated()
                .and()
            .formLogin().permitAll()
                .and()
            .logout().permitAll();
    }
}
```

### Complete Project Structure

```
src
├── main
│   ├── java
│   │   └── com
│   │       └── example
│   │           └── websocket
│   │               ├── WebSocketConfig.java
│   │               ├── WebSocketController.java
│   │               └── WebSecurityConfig.java
│   ├── resources
│   │   └── application.properties
│   └── webapp
│       └── index.html
└── test
    └── java
        └── com
            └── example
                └── websocket
                    └── WebSocketApplicationTests.java
```

This should give you a good starting point for using WebSocket with STOMP in a Spring Boot application. Let me know if you have any questions or need further assistance!