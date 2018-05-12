FROM openjdk:8-jdk

ENV JAVA_HOME              /usr/lib/jvm/java-8-openjdk-amd64
ENV JAVA_OPTS              ""
ENV PATH                   $PATH:$JAVA_HOME/bin

ENV SPRING_PROFILES_ACTIVE test

WORKDIR /app

EXPOSE 8080

COPY target/app.jar /app/app.jar

CMD ["/bin/sh", "-c", "java $JAVA_OPTS -jar /app/app.jar --spring.profiles.active=$SPRING_PROFILES_ACTIVE"]