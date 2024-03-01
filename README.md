# MessageHandler

## Требуется
- Docker 

## Запуск программы
- Создаем пустую папку и туда вставляем файл docker-compose.yml
- В терминале открываем ту папку
- запускаем команду docker compose up -d
- Проверяем на постмане

## curl RequestBody

```
curl --location --request GET 'http://localhost:8080/messages' \
--header 'Content-Type: application/xml' \
--data '<Message>
<message>Hello everyone</message>
<sender>Dimash</sender>
</Message>'
```

