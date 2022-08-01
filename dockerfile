# In docker engine, change - > buildkit": true to false.
ARG DOCKER_BUILDKIT=0
ARG COMPOSE_DOCKER_CLI_BUILD=0

# Below step give us these setup dependencies (a linux machine, which has maven and JDK installed)
FROM maven:3.8.1-jdk-11

ARG HERE='/workspace/app'
WORKDIR /usr/amazon

ARG USER_HOME_DIR="/usr"
ENV MAVEN_CONFIG "$USER_HOME_DIR/.m2"

# Get latest stable Google Chrome browser (This step installs stable chrome browser for us)
RUN apt-get update || true && apt-get -y install unzip wget curl vim \
    && wget -q -O - https://dl-ssl.google.com/linux/linux_signing_key.pub | apt-key add - \
	&& echo "deb http://dl.google.com/linux/chrome/deb/ stable main" >> /etc/apt/sources.list.d/google-chrome.list \
    && apt-get update \
    && apt-get upgrade --yes \
    && apt-get install --yes google-chrome-stable \
	&& rm /etc/apt/sources.list.d/google-chrome.list \
	&& sed -i 's/"$HERE\/chrome"/"$HERE\/chrome" --headless --disable-dev-shm-usage --no-sandbox/g' /opt/google/chrome/google-chrome \
    && apt-get clean \
    && rm -rf /var/lib/apt/lists/* /var/cache/apt/*

# map the volume
VOLUME /dev/shm

# Copy the src code and pom file.
   COPY pom.xml .
   COPY ./src src

# Keep container running (When running a container from this image)
CMD mvn clean test
