Для запуска приложения небходимо:
1) Создать БД с именем registry (порт 5432)
2) Сбилдить в Maven через команду package
3) Запустить созданный jar-файл appliances_registry-1.0-SNAPSHOT
4) Опционально: зайти в сваггер для просмотра всей документации по реализации

Страница Swagger с документацией:
http://localhost:8080/swagger-ui/index.html

Настройки БД для подключения в application.properties (по факту все настройки там уже прописаны):
spring.datasource.url=jdbc:postgresql://localhost:5432/registry

Все необходимые таблицы создадутся автоматически при первом запуске приложения.


Предусловие:
- Java 8
- Spring Boot Starter, Spring Web, Spring JPA, Spring Hibernate
- Postgres SQL
- springdoc-openapi


Ход работ:
Необходимо реализовать реестр техники (телевизоры, пылесосы, холодильники, смартфоны и ПК) с привязкой к ним моделей с 
собственными характеристиками. Например, смартфоны Iphone имеют ряд общих атрибутов, равных для всей линейки, но каждая 
модель линейки имеет собственные характеристики.
В роли сущностей должен выступать вид техники: 
- телевизор
- пылесос
- холодильник
- смартфон
- ПК.

Атрибуты сущности: 
- наименование
- страна производитель
- фирма производитель
- возможность заказа онлайн(да/нет)
- возможность оформления рассрочки(да/нет)
- модели в наличии (выборка из моделей, которые представлены в виде справочника)

Сами модели должны иметь ряд атрибутов в зависимости от вида техники:
- телевизоры: наименование, серийный номер, цвет, размер, цена, категория, технология, наличие товара (Да/Нет)
- пылесосы: наименование, серийный номер, цвет, размер, цена, объём пылесборника, количество режимов, наличие товара (Да/Нет)
- холодильники: наименование, серийный номер, цвет, размер, цена, количество дверей, тип компрессора, наличие товара (Да/Нет)
- смартфоны: наименование, серийный номер, цвет, размер, цена, память, количество камер, наличие товара (Да/Нет)
- компьютеры: наименование, серийный номер, цвет, размер, цена, категория, тип процессора, наличие товара (Да/Нет)

В реестр достаточно добавить по три позиции на каждый вид техники с двумя моделями для каждой.
По выделенным атрибутам необходимо реализовать поиск по наименованию, вне зависимости от регистра, а также реализовать 
фильтрацию по виду техники, цвету, цене (от/до). Остальные фильтры сделать зависимыми от выбора вида техники и 
фильтровать по атрибутам моделей.
Реализовать сортировку реестра техники по алфавиту и по стоимости.
Реализовать возможность добавлять новые позиции и модели к ним, в зависимости от выбранного вида техники.

Ожидаемый результат:
REST-приложение с Open API v3 документацией в виде страницы swagger. Доступ к репозиторию с исходниками приложения. 
README файл с инструкцией для запуска.
