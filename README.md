qencode-api-java-client
====================

Java library for interacting with the Qencode API.

### Getting Started

Add the library as a dependancy to your project.

If you're using Maven, add this to your pom.xml file:

        <dependency>
              <groupId>com.qencode.java.api.client</groupId>
              <artifactId>qencode-java-api-client</artifactId>
              <version>1.0.14</version>
        </dependency>


Import the client and related classes:

```java
import QencodeApiClient;
import QencodeException;
import com.qencode.api.java.client.classes.*;
import com.qencode.api.java.client.response.*;
```

Instantiate a new client with your API key:

```java
QencodeApiClient client = new QencodeApiClient(YOUR_API_KEY);
```

### Usage

Create a new job:

```java
TranscodingTask task = client.CreateTask();
task.setUri(VIDEO_URL);
task.setTranscodingProfiles(TRANSCODING_PROFILE_ID);
task.start();
```

Query an existing job:

```java
TranscodingTaskStatus response = task.getStatus();
```

## Copyright
See LICENSE.txt for details.
