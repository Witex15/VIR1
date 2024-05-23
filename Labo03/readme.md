# Labo03 - Run a first container

## Pedagogical intent

In this lab, you'll:

* Get to grips with the first Docker commands,
* Run your first Docker
* Familiarize yourself with port publishing

---

Note: the docker engine must be running

## Task 01 - Get to grips with the first Docker commands

* List all images present on your installation

[INPUT]
```bash
docker images
```

[OUTPUT]
```
REPOSITORY               TAG       IMAGE ID       CREATED         SIZEcker images                                                                             ✔  08:40:17  
mysql                    8.2       a76e521c0292   4 months ago    639MB
testcontainers/ryuk      0.5.1     8be3fdcaa3e8   12 months ago   12.2MB
docker/getting-started   latest    289dc403af49   17 months ago   46.5MB

```

* Get the official Nginx image using this command

[INPUT]
```bash
docker pull nginx
```

[OUTPUT]
```
latest: Pulling from library/nginx
24c63b8dcb66: Pull complete 
ac894f1d1dfb: Pull complete 
2572d4eb2260: Pull complete 
0ac3805c647c: Pull complete 
da20f09652a8: Pull complete 
2de21a3abd85: Pull complete 
77cea143f3c3: Pull complete 
Digest: sha256:a484819eb60211f5299034ac80f6a681b06f89e65866ce91f356ed7c72af059c
Status: Downloaded newer image for nginx:latest
docker.io/library/nginx:latest
```

Note : do you see the different layer uploaded ?

* List -again- all image present on your installation

[INPUT]
```bash
docker images
```

[OUTPUT]
```
REPOSITORY               TAG       IMAGE ID       CREATED         SIZE images                                                                         ✔  22s   08:48:57  
nginx                    latest    8dd77ef2d82e   12 days ago     193MB
mysql                    8.2       a76e521c0292   4 months ago    639MB
testcontainers/ryuk      0.5.1     8be3fdcaa3e8   12 months ago   12.2MB
docker/getting-started   latest    289dc403af49   17 months ago   46.5MB
```

Note : 188 MB is the size of your image... check it.

* List -again- all image present on your installation

[INPUT]
```bash
docker images
```

[OUTPUT]
```
REPOSITORY               TAG       IMAGE ID       CREATED         SIZEker images                                                                              ✔  08:49:28  
nginx                    latest    8dd77ef2d82e   12 days ago     193MB
mysql                    8.2       a76e521c0292   4 months ago    639MB
testcontainers/ryuk      0.5.1     8be3fdcaa3e8   12 months ago   12.2MB
docker/getting-started   latest    289dc403af49   17 months ago   46.5MB
```

* List all Docker

[INPUT]
```
docker ps -a
```

[OUTPUT]
```
CONTAINER ID   IMAGE                    COMMAND                  CREATED         STATUS                     PORTS     NAMES
c86755b39171   docker/getting-started   "/docker-entrypoint.…"   6 minutes ago   Created                              silly_blackwell
e427909d92fa   docker/getting-started   "/docker-entrypoint.…"   6 minutes ago   Exited (0) 2 minutes ago             condescending_booth
```

## Task 02 - Run the container

* Run Nginx Docker

[INPUT]
```
docker run nginx
```

[OUTPUT]
```
/docker-entrypoint.sh: /docker-entrypoint.d/ is not empty, will attempt to perform configuration
/docker-entrypoint.sh: Looking for shell scripts in /docker-entrypoint.d/
/docker-entrypoint.sh: Launching /docker-entrypoint.d/10-listen-on-ipv6-by-default.sh
10-listen-on-ipv6-by-default.sh: info: Getting the checksum of /etc/nginx/conf.d/default.conf
10-listen-on-ipv6-by-default.sh: info: Enabled listen on IPv6 in /etc/nginx/conf.d/default.conf
/docker-entrypoint.sh: Sourcing /docker-entrypoint.d/15-local-resolvers.envsh
/docker-entrypoint.sh: Launching /docker-entrypoint.d/20-envsubst-on-templates.sh
/docker-entrypoint.sh: Launching /docker-entrypoint.d/30-tune-worker-processes.sh
/docker-entrypoint.sh: Configuration complete; ready for start up
2024/05/23 06:35:20 [notice] 1#1: using the "epoll" event method
2024/05/23 06:35:20 [notice] 1#1: nginx/1.25.5
2024/05/23 06:35:20 [notice] 1#1: built by gcc 12.2.0 (Debian 12.2.0-14) 
2024/05/23 06:35:20 [notice] 1#1: OS: Linux 6.6.22-linuxkit
2024/05/23 06:35:20 [notice] 1#1: getrlimit(RLIMIT_NOFILE): 1048576:1048576
2024/05/23 06:35:20 [notice] 1#1: start worker processes

```

* Can you reach the default page of nginx

I had to run the following command to acces the nginx homepage

https://www.docker.com/blog/how-to-use-the-official-nginx-docker-image/

```
docker run -it --rm -d -p 8080:80 --name web nginx
```

Note : By default, Nginx is listening on port 80

[INPUT]
```
curl localhost
had to call curl localhost:8080
```

[OUTPUT]
```
the content of the homepage
```

* Stop this first attempt

[INPUT]
```
docker stop <id>
```

[OUTPUT]
```
docker ps -a
to see that it is stopped
```

## Task 03 - Familiarize yourself with port publishing

* Make it possible to reach nginx with this command

[Publish a port](https://docs.docker.com/network/#published-ports)

[INPUT]
```
curl localhost:8080
```

[OUTPUT]
```
docker run -it -p 8080:80  nginx
```

* Stop and delete the container

[INPUT]
```
//TODO delete the container
```

[OUTPUT]
```
docker rm <id>
```

* Delete the image

[INPUT]
```
//TODO delete the image
```

[OUTPUT]
```
 docker rmi nginx
 you need to delete the container first and the other container that use the image
```
