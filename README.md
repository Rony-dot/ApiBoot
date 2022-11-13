# ApiBoot

### Only do this
`docker-compose up`
### done


### Manual Process
- To build the image 
  - `docker build -t api-boot-server .`

`docker images`
- `mongo             latest    b70536aeb250   2 weeks ago   695MB`


`to run the image now:`
- `docker run -d --name container_name -p machine_port:docker_port iamge_name:tag`

- `docker run -d --name mongodb -p 27017:27017 mongo:latest`


`docker ps`
- `CONTAINER ID   IMAGE          COMMAND                  CREATED         STATUS         PORTS                      NAMES`
- `cd2810e44c57   mongo:latest   "docker-entrypoint.s…"   3 minutes ago   Up 3 minutes   0.0.0.0:27017->27017/tcp   mongodb`
