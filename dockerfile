FROM java:8
VOLUME /tmp
ADD demo-0.0.1-SNAPSHOT.jar app.jar
RUN sh -c 'touch /app.jar'
RUN echo "Asia/Shanghai" > /etc/timezone
ARG active="prod"
ENV JAVA_OPTS=""
ENV spring.profiles.active="dev"
#ENV spring.profiles.active=${active}
ENTRYPOINT ["sh", "-c","java -Dspring.profiles.active=prod $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.war"]
#ENTRYPOINT ["java","-jar","/app.jar"]