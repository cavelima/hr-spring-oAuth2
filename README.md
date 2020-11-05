# HR aplikacija - OAuth2 (GitHub Login)

## Instrukcije za lokalno pokretanje:
- Instalirati XAMPP https://www.apachefriends.org/index.html i neki alat za slanje HTTP zahtjeva (npr. Postman https://www.postman.com/)
- Pokrenuti Apache web server i MySQL u XAMPP alatu
- Kroz phpMyAdmin odraditi import baze
- Za testiranje prikaza povijesti zaposlenja radnika možemo posjetiti localhost:8080
- CRUD zahtjevi za entitet "Regija" mogu se testirati preko Postman alata

### Rest API
1. Povijest zaposlenja radnika
    GET 'http://localhost:8080/api/employees/{id}'
2. Prikaz svih regija
    GET 'http://localhost:8080/api/regions/all'
3. Prikaz jedne regije
    GET 'http://localhost:8080/api/regions/{id}'
4. Dodavanje regije
    POST 'http://localhost:8080/api/regions/add'
    
    JSON body:
    ```
    {
    "regionId": {id},
    "regionName": {ime}
    }
    ```

5. Promjena regije
    PUT 'http://localhost:8080/api/regions/update/{id}'

    JSON body:
    ```
    {
    "regionId": {id},
    "regionName": {ime}
    }
    ```

6. Brisanje regije
    DELETE 'http://localhost:8080/api/regions/delete/{id}'

