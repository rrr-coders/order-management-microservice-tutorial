FROM adoptopenjdk/openjdk15:alpine-jre
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
VOLUME /tmp
ARG JAR_FILE
RUN echo ${JAR_FILE}
ADD ${JAR_FILE} /app/app.jar
EXPOSE 8888
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app/app.jar"]