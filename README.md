## Приложение для подсчёта файлов и их страниц в заданной директории

### Необходимый софт для сборки и запуска
1. Maven 3.8.4 или выше
2. JDK 17 или выше

### Сборка

- Чтобы собрать проект, нужно выполнить в корне команду "mvn install".
- После сборки в директории target появляется исполняемый файл FindFiles-0.0.1.jar

### Запуск

Запуск исполняемого файла производится командой "java -jar FindFiles-0.0.1.jar".

### Swagger

http://localhost:8080/swagger-ui/index.html

----------------
### Особенности работы
- подстчёт файлов и страниц идёт только для поддерживаемых типов
