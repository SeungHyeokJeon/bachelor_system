# README

![Backend README](/README/BACKEND_README.md)
![Frontend README](/README/FRONTEND_README.md)

### Dev Environment

- vue.js
- spring boot 2.7.5 with temurinJDK 17
- postgresql 15

### Requirement

- Front: node 18
- Back: jdk 17
- DB: Docker, docker-compose

### Execution

1. Edit `/.env`, `/backend/config/application.yml` file

```yaml
# /backend/config/application.yml
server:
  port: { yourPORT }

...
  #    db info sample begin
  url: jdbc:postgresql://{address}:{port}/{dbname}
  username: { your username }
  password: { your password }
  ...
```

```
# ./env
POSTGRES_HOST=localhost
POSTGRES_PORT=[your PORT Number]
POSTGRES_DB=uams
POSTGRES_USER=[your USERNAME]
POSTGRES_PASSWORD=[your PASSWORD]
```

3. Run Database

```bash
docker-compose up -d
```

- If you set the image name to `node-test`, you must rename `image` in `docker-compose.yml`

- If you run `docker-compose up -d` once, `start` and `stop` manage the container

```bash
docker-compose start
docker-compose stop
```

4. Run Backend

- Go to `/commands` Folder

```
# /commands
./back_bootrun.sh
```

5. Run Frontend

- Go to `/frontend` Folder

```
# /frontend
npm install; npm update

npm run serve
```
