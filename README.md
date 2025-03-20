# CarsShop - Projekt Dokumentation

## Projektbeschreibung
CarsShop ist eine Webanwendung, die eine Liste von Autos anzeigt. Das Frontend basiert auf Vue.js, während das Backend mit Spring Boot entwickelt wurde. Als Datenbank kommt PostgreSQL zum Einsatz, die in einem Docker-Container läuft.

Um die Webanwendung zu starten, müssen die Docker-Container, das Spring Boot Backend und das Vue.js Frontend gestartet werden.

## Projektstruktur

### Docker-Komponenten
Die Datei docker-compose.yml definiert zwei Services:
1. **`PostgreSQL`** – Die Datenbank, in der die Autodaten gespeichert sind.
2. **`pgAdmin`** Ein Web-Tool zur Verwaltung der Datenbank (erreichbar unter http://localhost:7070) Mail:elyas@admin.com Pass: mycar.

Docker starten:
```
docker-compose up -d
```
stoppen: 
```
docker-compose stop (Container werden gestoppt, aber Daten bleiben erhalten)
```
```
docker-compose down (Container werden entfernt, inklusive Netzwerke)
```


### Backend (Spring Boot)
Das Backend wird mit Gradle gestartet. Stelle sicher, dass Java (mindestens Version 23) und Gradle installiert sind.

Starten:
```
gradlew.bat bootRun
```
Das Backend ist dann unter `http://localhost:9090/` erreichbar.



### Frontend (Vue.js)
Das Vue.js-Frontend ruft die Autodaten vom Backend ab und zeigt sie an.

Falls die Abhängigkeiten noch nicht installiert sind:
```
npm install
```
Starte:
```
npm run serve
```
Das Frontend ist dann unter http://localhost:8080/ erreichbar.

