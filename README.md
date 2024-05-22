# Pipeline Teckton

## Prerequisitos 
- Contar con un cluster de OpenShift
- Tener instalado el Operador de Red Hat OpenShift Pipelines
- Poder crear PVC dentro de OpenShift
- Tener una cuenta de registry.redhat.com
[URL Registry Token](https://access.redhat.com/terms-based-registry/accounts)

## Despliegue
```console
Creamos un proyecto
$ oc new-project senasica
Creamos la tarea en el proyecto
$ oc apply -f pipeline/apply_manifest_task.yaml
Creamos el pipeline en el proyecto
$ oc apply -f pipeline/pipeline.yaml
```

Una vez que ya tenemos el pipeline creado lo podemos desplegar

- Vamos a la seccion de pipelines
- Ejecutamos el pipeline de build-and-deploy (los campos ya estan pre llenados)
- Creamos el PVC donde se almacenara la informacion mientras corre el pipeline
- Creamos el Secret con el login de registry.redhad.io
- Desplegamos el pipeline