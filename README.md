# Web Programming URL-Shortnener
##### By Maximilian Anderlohr, Brandon Früh, Mats Brüning, Arno Wagner

## Das folgende Programm wurde nach folgenden Anforderungen entwickelt:
Ziel ist es die Erstellung eines Service zum Erstellen, Auflisten und Verwenden von URL-Verkürzungen (URL shortener service).
Das Service MVP besteht aus

Frontend mit Möglichkeit:
- Der Eingabe von neuen (langen) URLs
- Auflistung der eingetragenen URLs mit ID
- Löschen einzelner URLs

Backend mit Funktionen:
- Kein DB-Anschluss, alle Daten liegen im memory. Nach Neustart ist Datenbestand leer. 
- Zum Erfüllen der Funktionalitäten, die im Fronend angeboten werden 
- Umleiten eines Request von einen kurzen URL auf den originalen URL

		
## Unsere Lösung:
Wir haben begonnen uns über die notwendigen Funktionalitäten gedanken zu machen. Nachdem diese definiert wurden, wurde 
nach diesen Forgeben ein Wireframe (ebenfalls im Ordern zu finden) entwickelt. Dieser sollte es uns erleichtern ein gemeinsammes
Verständniss des Vorgehens zu besitzen. Nachdem Wir die Grundlegende HTML Stkuktur entwickelt haben, haben wir uns damit begonnen 
die einzelnen Funktionen im Backend zu implementieren, als auch die CSS Datei für das HTML zu entwickeln.
Um den Überblick zu behalten haben wir uns nach Scrumban mit einem Board organisiert. 
Die Punkte unter "User Storys" repräsentieren daher unser Product Backlog.

Implementierte Funktionen:
- Eingabe langer URLs
- Erzeugung eines vierstelligen Aliases
- Möglichkeit einen personalisierten Alias zu verwenden
- Einen anderen Alias anfordern duch Button press
- Anzeige des erstellten kurzen URLs
- Kopierfunktion des kurzen URLs
- Funktion den kurzen URL zu testen mit einer Weiterleitung auf die Seite
- Anzeige aller gespeicherten URLs in einer Tabelle
- Funktion "Update der Tabelle"
- Funktion Einträge per Alias zu löschen

Die Dateien des Frontends sind unter dem Order *static/frontend* zu finden. 
(Diese liegen alle im gleichen Ordner, da es ein Problem mit dem relativen Pfad und dem Webserver gab, welches wir nicht beheben konnten.)
Da wir eine Singe Page Application entwickelt haben, ist unsere einzige HTML Datei die index.html. Dort ist der Code underer Landing Page zu finden.
Das CSS Script, als auch die JS-Funktionen sind in die entsprechenden Dateien ausgelagert.
	
Unser Backend ist in dem Order *src/main/java/com/dhbw/ws/PlainWs* zu finden. 
Alle Funktionen sind nach Java-Doc dokumentiert.


## User Storys im Product Backlog:
- Anbindung einer Datenbank zur besseren Lösung wenn die Anzahl der Nutzer skaliert wird
- Überprüfung der URLs auf verschiedene Aspekte
- Eine erweiterte Alias Funktion um mehr Varianten zu erzeugen
- Wenn eine Datenbank implementiert wird, muss nach SQL Injektions geprüft werden
- Feedback an den User nach erfolgreicher/fehlgeschlagener Aktionen
- Funktionen der Tabelle implementieren z.B. Am meisten genutzte Links oben in der Tabelle anzeigen oder Weiterleitung durch klick auf Tabelleneintrag
- Objektorientiert im JavaScript-FrontEnd
- BackEnd: Eigene Klassenstruktur für Alias, lange URLs



## Wie startet man unseren Service:
Bitte verwenden Sie Chrome als Webbrowser um die Webseite anzeigen, Firefox funktioniert zwar, zeigt aber das Eingabefeld falsch an.Edge funktioniert noch nicht


## Bei Problemen:
BLA BLA



