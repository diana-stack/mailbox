Mikroserwisu bazujący na spring boot, umożliwia dodawanie wartości do bazy danych i wyświetlenie jej zawartości. Mikroserwis odpowiadać na żądania http w formacie json.

Na żądanie postaci:
POST http://localhost:8080/message

Odpowiada statusem 200 i zawartością dodaną do bazy danych:
{id: "1",
content:"Wartosc"}

Na żądanie http:
GET http://localhost:8080/message
Zwraca listę wcześniej dodanych wartość.

Na żądanie http:
PUT http://localhost:8080/message/4

Odpowiada statusem 200 i zmodyfikowaną zawartością.
{id: "d819302f-4b86-4815-8d39-9966d441f76f",
content:"Wartosc 2"}

Na żądanie http:GET http://localhost:8080/message/random/10
Zwróca listę 10 losowych wiadomości zapisanych w bazie.
