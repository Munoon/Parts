# Parts
Приложение на Java которое сделано для прохождения на стажировку JavaRush.

## Установка
1) Загрузить файлы на компъютер командой ``git clone https://github.com/Munoon/Parts.git``
2) На MySQL сервере создать базу данных ``test`` и выполнить там ``test.sql`` скрипт
3) Ввести данные базы данных в файле ``src/main/resources/application.properties``
4) В корневой папке программы выполнить команду ``mvn clean package``
5) Затем, что бы запустить программу нужно выполнить команду ``java -jar target/Parts-1.0-SNAPSHOT.jar``