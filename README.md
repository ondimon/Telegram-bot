## Описание проекта

Проект представляет собой Telegram-бот, агрегирующий новости,
статьи, мероприятия с сайтов, посвящённых образованию.

Пользователь имеет возможность подписаться на бота и получать
необходимую информацию либо в интерфейс самого бота, либо просматривать
информацию в графическом пользовательском интерфейсе приложения.

Ценность продукта заключается в том, что у пользователя отпадает
необходимость мониторить каждый портал в отдельности, вместо этого
пользователь видит всю необходимую информацию в одном месте.

### Описание модулей проекта.

#### event-service

Сервис, предназначенный для получения, обработки, хранения в базе данных,
а также выдачи из базы данных событий.

#### parser-service

Сервис, который осуществляет парсинг сайтов, сбор необходимой информации
и передачу информации в event-service

#### telegram-bot

Модуль, осуществляющий работу непосредственно с телеграм-ботом

#### web-gui

Графический пользовательский интерфейс, отображающий информацию о событиях.

## Запуск при помощи Docker
#### Режим разработки
Для того чтобы собрать образы на своей машине и запустить контенеры необходимо выполнить команду в папке проекта

docker-compose -f docker-compose.dev.yaml up --build

Для того чтобы запустить только какой то конкретный сервис необхдимо выполнить команду
docker-compose -f docker-compose.dev.yaml up --build [ИмяСервиса]

#### Доступные сервисы
 - event-service - api доступ к инфорации по мероприятиям и событям
 - web-gui - фронт
 - parser-service - сервис парсера сайтов
 - bot-service - сервис для работы с телеграмм ботом. Для запуска необходимо задать переменные среды TELEGRAMBOT_NAME, TELEGRAMBOT_TOKEN 
#### Точки входа 
 - localhost:8081 - event-service
 - localhost:8080 - web-gui
