[![Build Status](https://app.travis-ci.com/bespalov0928/work_forum.svg?branch=main)](https://app.travis-ci.com/bespalov0928/work_forum)

## Описание

### О проекте
Приложение представляет аналог асинхронной очереди.
Приложение запускает Socket и ждет клиентов.
Клиенты могут быть двух типов: отправители (publisher), получатели (subscriber).
В качестве клиента будем использовать cURL. https://curl.se/download.html
В качестве протокола будем использовать HTTP.

### Стек технологий
* Java 17
* jacoco
* Multithreading



### Сборка и запуск
Сборка
```
mvn install
```
запуск
```
java -jar target/pooh.jar
```

### Как использовать

### тип queue
POST запрос добавить элемент в очередь weather тип queue 
```
curl -X POST -d "temperature=18" http://localhost:9001/queue/weather
```


GET запрос получить элементы из очереди weather.
```
curl -X GET http://localhost:9001/queue/weather
```
###Тип topic
POST запрос добавить элемент в очередь weather тип topic
```
curl -X POST -d "temperature=17" http://localhost:9001/topic/weather
```

GET запрос получить элементы из очереди weather тип topic
```
curl -X GET http://localhost:9001/topic/weather/1
```


### Контакты
Skype: bespalov0928



