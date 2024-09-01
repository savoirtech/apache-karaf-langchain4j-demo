# Apache Karaf LangChain4J Application Demo

In this demo we’ll build an API Gateway Service which allows our users
to utilize various Generative API services.

To implement this pattern we’ll use Apache Karaf as our runtime
container, Apache CXF as our JAX-RS webservice implementation,
Savoirtech’s EOS library to implement a Keyed-Whiteboard
plugin-architecture, and LangChain4J to integrate various Generative API
Services.

## Architecture Overview:

## Installation:

``` bash
feature:repo-add mvn:com.savoir/application-features-file/1.0.0-SNAPSHOT/xml/features
feature:install application-all-demo
```

## Verify Installation:

``` bash
karaf@root()> list
START LEVEL 100 , List Threshold: 50
 ID │ State  │ Lvl │ Version        │ Name
────┼────────┼─────┼────────────────┼────────────────────────────────────────────────────────────────────────────────────
 33 │ Active │  80 │ 4.4.6          │ Apache Karaf :: OSGi Services :: Event
106 │ Active │  85 │ 1.0.0.SNAPSHOT │ Apache-Karaf-LangChain4J-AI-DEMO :: karaf-feature-project-api
107 │ Active │  85 │ 1.0.0.SNAPSHOT │ Apache-Karaf-LangChain4J-AI-DEMO :: karaf-feature-project-impl
108 │ Active │  85 │ 1.0.0.SNAPSHOT │ Apache-Karaf-LangChain4J-AI-DEMO :: karaf-feature-project-plugins
109 │ Active │  85 │ 1.0.0.SNAPSHOT │ Apache-Karaf-LangChain4J-AI-DEMO :: karaf-feature-project-spi
110 │ Active │  80 │ 2.10.1         │ Gson
111 │ Active │  80 │ 18.0.0         │ Guava: Google Core Libraries for Java
112 │ Active │  80 │ 1.1.0          │ SavoirTech :: Eos :: Core
120 │ Active │  80 │ 3.4.0          │ Apache Commons Lang
128 │ Active │  80 │ 0              │ wrap_file__Users_jgoodyear_.m2_repository_com_knuddels_jtokkit_1.1.0_jtokkit-1.1.0.jar
karaf@root()>
```

### Verify webservice available:

``` bash
http://localhost:8181/cxf/
```

### Test our webservice:

``` bash
curl --location --request POST 'http://0.0.0.0:8181/cxf/ai' \
--header 'Content-Type: application/json' \
--data-raw '
{
  "id": 1234567890,
  "sku": "demo",
  "quantity": 1
}'
```

``` bash
{"description":"This is a demo plugin."}
```

If you don’t install (modify features file to observe behavoir)

``` bash
 feature:install cxf-core
 feature:install cxf-jaxrs
```

You’ll see:

``` bash
karaf@root()> diag 53
karaf-application-lab :: karaf-feature-project-impl (53)
--------------------------------------------------------
Status: GracePeriod
Blueprint
2022-09-25, 8:15 p.m.
Missing dependencies:
(&(objectClass=org.apache.aries.blueprint.NamespaceHandler)(osgi.service.blueprint.namespace=http://cxf.apache.org/blueprint/core)) (&(objectClass=org.apache.aries.blueprint.NamespaceHandler)(osgi.service.blueprint.namespace=http://cxf.apache.org/blueprint/jaxrs))
```
