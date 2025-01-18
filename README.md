# kong-zipkin

```
podman build -t kong:kong-zipkin .
podman network create foo
podman play kube pods.yml --net foo
podman play kube pods.yml --down
```

