# README

![Backend README](/README/BACKEND_README.md)
![Frontend README](/README/FRONTEND_README.md)

### Dev Environment

- vue.js
- spring boot 2.7.5 with openJDK11
- postgresql 15

### Requirement

- Docker, docker-compose

### Execution

1. create `/.env` file

```
FRONT_PORT = [your PORT Number]
BACK_PORT = [your PORT Number]

POSTGRES_HOST=localhost
POSTGRES_PORT=[your PORT Number]
POSTGRES_DB=uams
POSTGRES_USER=[your USERNAME]
POSTGRES_PASSWORD=[your PASSWORD]
```

2. synchronize db ip

- check db ip

```
$ docker inspect [container_id] | grep IP

...
    "IPAddress": "172.19.0.2",
...
```

- go to `/backend/src/main/resources/application.yml`

```
...
  datasource:
    platform: postgres
    #    db info sample begin
    url: jdbc:postgresql://[your db ip]:5432/uams
...
```

3. load/build docker image

```bash
docker-compose up -d
```

- if you set the image name to `node-test`, you must rename `image` in `docker-compose.yml`

4. docker-compose start / stop

- If you run `docker-compose up -d` once, `start` and `stop` manage the container

```bash
docker-compose start
docker-compose stop
```

- If you only restart spring boot project, then run `./util/restart_back.sh`
