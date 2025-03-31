FROM jenkins/jenkins:lts

ENV JAVA_OPTS="-Djenkins.install.runSetupWizard=false"

# Copia los plugins necesarios e instala los plugins con jenkins-plugin-cli
COPY plugins.txt /usr/share/jenkins/ref/plugins.txt
RUN jenkins-plugin-cli --plugin-file /usr/share/jenkins/ref/plugins.txt

# Creación del usuario "threepoints" con password "threepoints" en la carpeta /jenkins
COPY security.groovy /usr/share/jenkins/ref/init.groovy.d/security.groovy