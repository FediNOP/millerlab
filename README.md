# Лаба для Миллера
- Java 21 
- Spring boot 3
- postgresql

## Переменные среды
`PORT` - Порт сервера

### postgresql
`POSTGRES_DB_HOST` - Адрес <br>
`POSTGRES_DB_PORT` - Порт <br>
`POSTGRES_DB_NAME` - Название бд <br> 
`POSTGRES_DB_USER` - Пользователь <br>
`POSTGRES_DB_PASSWORD` - Пароль <br>

## Первоначальный запуск
1. Скачать файл devops/compose/docker-compose.yml
2. Запустить командой `docker compose up -d`
3. Зайти в админку Postgresql по ссылке http://localhost:5050/ пароль admin
4. Правой кнопкой по `Servers` -> `Register` -> `Server...`
5. Name `local` перейти вкладку `Connection` <br>
`Host name`: postgres <br>
`Port`: 5432 <br>
`Username`: admin <br>
`Password`: admin <br>
6. Кнопка `save`
7. Создать базу с названием `millerlab`
8. Перейти по ссылке http://localhost:8080/
9. Готово

Все данные сохраняются даже после выключения
Если нужно перенести данные то надо переносить volumes: `pgsql-data` `pgsqladmin-data`

