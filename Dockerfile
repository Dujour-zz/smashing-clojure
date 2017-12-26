FROM java:8-alpine
MAINTAINER Your Name <you@example.com>

ADD target/smashing-clojure-0.0.1-SNAPSHOT-standalone.jar /smashing-clojure/app.jar

EXPOSE 8080

CMD ["java", "-jar", "/smashing-clojure/app.jar"]
